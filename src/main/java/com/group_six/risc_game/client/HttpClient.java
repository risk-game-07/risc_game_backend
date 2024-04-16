package com.group_six.risc_game.client;

import com.alibaba.fastjson.JSONObject;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


// Adpter
public class HttpClient{
    //@return current num
    public int addGame(String playerId, int roomSize) {
        String url = "http://localhost:8080/game/init/addGame";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomSize", roomSize);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return getInt(result,"data", "curNum");
    }
    public String waitOther(String playerId){
        String url = "http://localhost:8080/game/init/waitOther";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return getString(result,"data", "roomId");
    }
    /*
      @NotNull
    Map<String, Integer> assignPattern;
    @NotNull
    String playerId;
    @NotNull
    String roomId;
     */
    public String assignUnit(Map<String, Integer> assignPattern, String playerId, String roomId){
        String url = "http://localhost:8080/game/start/assignUnit";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        json.put("assignPattern", assignPattern);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return result;
    }

    public ClientPlayer getTerritory(String playerId, String roomId){
        String url = "http://localhost:8080/game/init/getTerritory";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return new ClientPlayer(
                getStringList(result, "data", "territoiesName"),
                getInt(result, "data", "units"),
                getIntegerList(result, "data", "terrUnit")
        );
    }

    public String getWorldMap(String playerId, String roomId){
        String url = "http://localhost:8080/game/start/getWorldMap";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        // System.out.println(result);
        return createWolrdMap(result);
    }

    private String createWolrdMap(String jsonString){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode playersNameArray = rootNode.path("data").path("playersName");
            JsonNode playersStateArray = rootNode.path("data").path("playersState");
            Iterator<JsonNode> playersNameIterator = playersNameArray.elements();
            Iterator<JsonNode> playersStateIterator = playersStateArray.elements();
            StringBuilder str = new StringBuilder();
            while (playersNameIterator.hasNext() && playersStateIterator.hasNext()) {
                String playerName = playersNameIterator.next().asText();
                JsonNode playerState = playersStateIterator.next();
                String territoriesStr = getPlayerTerritoriesString(playerState);
                str.append("player: ").append(playerName).append("\n").append("has ").append(territoriesStr);
                str.append("\n");
            }
            return str.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }

    private static String getPlayerTerritoriesString(JsonNode playerState) {
        StringBuilder territoriesStr = new StringBuilder();
        JsonNode territoriesNameArray = playerState.path("territoiesName");
        JsonNode terrUnitArray = playerState.path("terrUnit");

        Iterator<JsonNode> territoriesNameIterator = territoriesNameArray.elements();
        Iterator<JsonNode> terrUnitIterator = terrUnitArray.elements();

        while (territoriesNameIterator.hasNext() && terrUnitIterator.hasNext()) {
            String territoryName = territoriesNameIterator.next().asText();
            int territoryUnit = terrUnitIterator.next().asInt();
            territoriesStr.append(territoryName).append("(").append(territoryUnit).append(" units)");
            if (territoriesNameIterator.hasNext() && terrUnitIterator.hasNext()) {
                territoriesStr.append(", ");
            }
        }
        return territoriesStr.toString();
    }

    public int sendEndPhase(String playerId, String roomId){
        String url = "http://localhost:8080/game/start/sendGameAction";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        json.put("type", "end");
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return getInt(result, "data", "curPhase");
    }

    public int sendAttack(String playerId, String roomId, GameActionReq gameActionReq){
        String url = "http://localhost:8080/game/start/sendGameAction";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        json.put("type", "attack");
        json.put("from", gameActionReq.getFrom());
        json.put("to", gameActionReq.getTo());
        json.put("units", gameActionReq.getUnits());
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return getInt(result, "data", "curPhase");
    }

    public int sendMove(String playerId, String roomId, GameActionReq gameActionReq){
        String url = "http://localhost:8080/game/start/sendGameAction";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        json.put("type", "move");
        json.put("from", gameActionReq.getFrom());
        json.put("to", gameActionReq.getTo());
        json.put("units", gameActionReq.getUnits());

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);
        return getInt(result, "data", "curPhase");
    }


    public boolean moveNextPhase(int curPhase, String playerId, String roomId){
        String url = "http://localhost:8080/game/start/endPhase";
        JSONObject json = new JSONObject();
        json.put("playerId", playerId);
        json.put("roomId", roomId);
        json.put("numPhase", curPhase);

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.postForObject(url, json, String.class);

        return getBoolean(result, "data", "end");
    }

    private boolean getBoolean(String jsonString, String rootKey, String key){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode dataNode = rootNode.get(rootKey);
            return dataNode.get(key).asBoolean();
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    private int getInt(String jsonString, String rootKey, String key){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode dataNode = rootNode.get(rootKey);
            return dataNode.get(key).asInt();
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }

    private String getString(String jsonString, String rootKey, String key){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonString);
            JsonNode dataNode = rootNode.get(rootKey);
            return dataNode.get(key).asText();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }
    public List<String>  getStringList(String jsonString, String rootKey, String key) {
        List<String> ans = new ArrayList<>();
        try {
            // 创建 ObjectMapper 对象
            ObjectMapper objectMapper = new ObjectMapper();

            // 将 JSON 字符串解析为 JsonNode 对象
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // 获取 data 字段
            JsonNode dataNode = rootNode.get(rootKey);

            // 获取 territoriesName 字段对应的数组
            JsonNode territoriesArray = dataNode.get(key);


            for (JsonNode node : territoriesArray) {
                String territoryName = node.asText();
                ans.add(territoryName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }
    public List<Integer>  getIntegerList(String jsonString, String rootKey, String key) {
        List<Integer> ans = new ArrayList<>();
        try {
            // 创建 ObjectMapper 对象
            ObjectMapper objectMapper = new ObjectMapper();

            // 将 JSON 字符串解析为 JsonNode 对象
            JsonNode rootNode = objectMapper.readTree(jsonString);

            // 获取 data 字段
            JsonNode dataNode = rootNode.get(rootKey);

            // 获取 territoriesName 字段对应的数组
            JsonNode territoriesArray = dataNode.get(key);


            for (JsonNode node : territoriesArray) {
                Integer territoryUnits = node.asInt();
                ans.add(territoryUnits);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }
    }

