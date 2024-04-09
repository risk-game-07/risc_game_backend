package com.group_six.risc_game.client;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import com.group_six.risc_game.client.RoomDetails;


public class Client {
    private final HttpClient httpClient;
    private final String baseUrl = "http://localhost:8080";
    public Client() {
        this.httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    public void joinGame(String playerID, int roomSize) {
        // Step 1: Add game
        String addGameResponse = sendAddGameRequest(playerID, roomSize);
        System.out.println("Add Game Response: " + addGameResponse);

        // Step 2: Poll /game/init/waitOther until the room size is reached
        String roomId = pollUntilRoomIsReady(playerID, roomSize);
        if(roomId == null)
            System.out.println("ERROR: cannot find the room");
        // get assign Pattern

        RoomDetails roomDetails = getRoomDeatils(playerID, roomId);
        // Step 3: Parse room details and assign units to territories
        if (roomDetails != null) {
            assignUnitsToTerritories(roomDetails, playerID, roomId);
        } else {
            System.out.println("Failed to get the room details or the room is not ready.");
        }

    }

    private RoomDetails getRoomDeatils(String playerID, String roomId) {
        String getDetailsUrl = baseUrl + "/game/init/getTerritory?playerId=" + playerID+"&roomId=" + roomId;
        HttpRequest getDetailRequest = HttpRequest.newBuilder()
                .uri(URI.create(getDetailsUrl))
                .GET()
                .build();
        RoomDetails roomDetails;

        try {
            HttpResponse<String> response = httpClient.send(getDetailRequest, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            JSONObject jsonResponse = new JSONObject(responseBody);
            JSONObject dataObject = jsonResponse.getJSONObject("data");
            JSONArray territoriesArray = dataObject.getJSONArray("territoiesName");
            String[] territories =  new String[territoriesArray.length()];
            for(int i = 0; i < territoriesArray.length(); i++)
                territories[i] = territoriesArray.getString(i);
            roomDetails = new RoomDetails(
                    territories,
                    dataObject.getInt("units"),
                    playerID
                    );
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return roomDetails;
    }
    private String sendAddGameRequest(String playerID, int roomSize) {
        String addGameUrl = baseUrl + "/game/init/addGame";
        String json = "{\"playerId\":\"" + playerID + "\",\"roomSize\":" + roomSize + "}";

        HttpRequest addGameRequest = HttpRequest.newBuilder()
                .uri(URI.create(addGameUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(addGameRequest, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // @return: room Id
    private String pollUntilRoomIsReady(String playerID, int roomSize) {
        String waitOtherUrl = baseUrl + "/game/init/waitOther?playerId=" + playerID;
        String roomId = null;
        while (true) {
            HttpRequest waitOtherRequest = HttpRequest.newBuilder()
                    .uri(URI.create(waitOtherUrl))
                    .GET()
                    .build();
            try {
                HttpResponse<String> response = httpClient.send(waitOtherRequest, HttpResponse.BodyHandlers.ofString());
                // change it to a function
                String responseBody = response.body();
                JSONObject jsonResponse = new JSONObject(responseBody);
                JSONObject dataObject = jsonResponse.getJSONObject("data");
                roomId = dataObject.getString("roomId");
                if(!roomId.equals("0")) break;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Polling interrupted.");
                return null;
            } catch (Exception e) {
                System.err.println("An error occurred during polling: " + e.getMessage());
                return null;
            }
        }
        return roomId;
    }


    private void assignUnitsToTerritories(RoomDetails roomDetails, String playerId, String roomId) {
        String[] territories = roomDetails.getTerritories();
        int totalUnits = roomDetails.getTotalUnits();
        Map<String, Integer> assignments = new HashMap<>();

        for (String territory : territories) {
            // Simple Way: assign an equal number of units to each territory
            assignments.put(territory, totalUnits / territories.length);
        }

        // Build the JSON string
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{\"assignPattern\":{");
        assignments.forEach((territory, units) -> jsonBuilder.append("\"").append(territory).append("\":").append(units).append(","));
        jsonBuilder.deleteCharAt(jsonBuilder.length() - 1); // Remove last comma
        jsonBuilder.append("},");
        jsonBuilder.append("\"playerId\":\"" + playerId + "\",\"roomId\":\"" + roomId  +"\"" + "}");
        // Send the POST request with the assignments
        String assignUrl = baseUrl + "/game/start/assignUnit";
        HttpRequest assignRequest = HttpRequest.newBuilder()
                .uri(URI.create(assignUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBuilder.toString()))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(assignRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("Units assigned successfully to territories.");
                // polling to check players all ready to start game
                // pollUntilGameStarts(roomDetails);
            } else {
                System.out.println("Failed to assign units. Status code: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pollUntilGameStarts(RoomDetails roomDetails) {
        String startGameUrl = baseUrl + "/game/start/waitForStart?playerId=" + roomDetails.getPlayerID();

        while (true) {
            HttpRequest startGameRequest = HttpRequest.newBuilder()
                    .uri(URI.create(startGameUrl))
                    .GET()
                    .build();

            try {
                HttpResponse<String> response = httpClient.send(startGameRequest, HttpResponse.BodyHandlers.ofString());
                String responseBody = response.body();
                JSONObject jsonResponse = new JSONObject(responseBody);
                boolean isFinished = jsonResponse.getBoolean("isFinished");

                if (isFinished) {
                    System.out.println("All players have assigned their units. The game is starting.");
                    break;
                } else {
                    System.out.println("Waiting for all players to finish assigning units...");
                    Thread.sleep(5000); // wait for 5s to polling
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Polling interrupted.");
                break;
            } catch (Exception e) {
                System.err.println("An error occurred during polling: " + e.getMessage());
            }
        }
    }

    // Send Game Orders（Attack/Move/End）
    public void sendOrder(String type, JSONObject orderDetails) {
        String orderUrl = baseUrl + "/game/start/sendOrder";
        JSONObject json = new JSONObject();
        json.put("type", type); // "attack", "move", or "end"
        json.put("details", orderDetails); // Additional details for the order

        HttpRequest orderRequest = HttpRequest.newBuilder()
                .uri(URI.create(orderUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json.toString()))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(orderRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject responseBody = new JSONObject(response.body());
            boolean isSuccess = responseBody.getBoolean("isSuccess");
            String errMsg = responseBody.optString("errMsg", "");

            if (isSuccess) {
                System.out.println("Order successfully processed.");
            } else {
                System.out.println("Failed to process order: " + errMsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // End Current Game Phase
    public void endPhase() {
        String endPhaseUrl = baseUrl + "/game/start/endPhase";

        HttpRequest endPhaseRequest = HttpRequest.newBuilder()
                .uri(URI.create(endPhaseUrl))
                .GET()
                .build();

        try {
            HttpResponse<String> response = httpClient.send(endPhaseRequest, HttpResponse.BodyHandlers.ofString());
            JSONObject responseBody = new JSONObject(response.body());
            boolean isFinished = responseBody.getBoolean("isFinished");
            boolean isLose = responseBody.getBoolean("isLose");
            boolean isWin = responseBody.getBoolean("isWin");

            if (isWin) {
                System.out.println("You won the game!");
            } else if (isLose) {
                System.out.println("You lost the game.");
            } else if (!isFinished) {
                System.out.println("The game is not finished. Waiting for the next phase.");

                // continue polling or other operations....

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
