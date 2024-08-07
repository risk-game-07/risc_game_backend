package com.group_six.risc_game.model;

import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.factory.Impl.TextTerritoryFactory;
import com.group_six.risc_game.factory.TerritoryFactory;
import com.group_six.risc_game.model.Impl.TextPlayer;
import com.group_six.risc_game.model.Impl.TextSolider;
import com.group_six.risc_game.utils.AbstractChecker;
import com.group_six.risc_game.utils.AttackChecker;
import com.group_six.risc_game.utils.MovementChecker;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRoom {

    private int roomSize;
    List<Player> players;
    Map<String, Player> playernameMap;
    Map<String, Territory> territoryNameMap;
    String roomId;
    int gamePhase;
    int curEndNum;

    public GameRoom(int roomSize, List<String> playersId, String roomID){
        this.roomId = roomID;
        // create Players
        this.players = new ArrayList<>();
        this.playernameMap = new HashMap<>();
        this.territoryNameMap = new HashMap<>();
        // add players
        for(String playerId : playersId) {
            Player player= new TextPlayer(playerId);
            this.players.add(player);
            // name <-> plauer
            playernameMap.put(playerId, player);
        }
        this.roomSize = roomSize;
        // init assign
        randomAssignTerritory();
        gamePhase = 0;
        curEndNum = 0;
    }

    private void randomAssignTerritory(){
        //TODO: change it to random assign
        //TODO: change the hard code 12
        TerritoryFactory territoryFactory= new TextTerritoryFactory();
        int num = 12 / roomSize;
        int index = 0;
        for(Player player : players){
            for(int i = 0; i < num; i++) {
                // create territory
                Territory territory = territoryFactory.makeTerritory(index + i);
                player.assignTerritory(territory);
                territoryNameMap.put(territory.getTerritoryName(), territory);
            }
            // set neibor
            for(Territory territory : territoryNameMap.values()){
                territory.setNeighbors(this);
            }

            index += num;
            // TODO: change the hard code
            player.setAvaliableUnits(24);
        }

    }

    public Player getPlayer(String playerId){
        return playernameMap.get(playerId);
    }

    public Territory getTerritory(String territoryName){
        return territoryNameMap.get(territoryName);
    }

    private HashMap<String, Territory> randomAssign(int roomSize, List<String> playersId){
        // the number of player equal to the number of territory
        // TODO finish the function
        return new HashMap<>();
    }

    String tryAttack(String playerId, String from, String to, int units){
        //TODO: change it to reposibiliy link list
        // choose player
        Player curPlayer = playernameMap.get(playerId);
        if(curPlayer == null){
            return "cannot find this player ID in " + roomId;
        }
        //check whether source territory blong to player
        if(!curPlayer.isMyTerritory(from)){
            return from + " do not blong to " + playerId;
        }
        if(curPlayer.isMyTerritory(to)){
            return "cannot attack your own place";
        }
        // check whether have some units
        if(territoryNameMap.get(from).getSoliderNum() < units){
            return "do not have enough units";
        }

        // check attack rule
        List<Territory> neibor = territoryNameMap.get(from).getNeighbors();
        if(!neibor.contains(territoryNameMap.get(to))){
            return "they are not neibour";
        }
        /*
        AbstractChecker attackChecker = new AttackChecker(null);
        if(!attackChecker.checkAction( territoryNameMap.get(from), territoryNameMap.get(to),curPlayer)){
            return "you cannot attack from " + from + " to " + to;
        }*/
        return null;
    }

//    String tryMove(String playerId, String from, String to, int units){
//        //TODO: change it to reposibiliy link list
//        // choose player
//        Player curPlayer = playernameMap.get(playerId);
//        if(curPlayer == null){
//            return "cannot find this player ID in " + roomId;
//        }
//        //check whether source territory blong to player
//        if(!curPlayer.isMyTerritory(from)){
//            return from + " do not blong to " + playerId;
//        }
//
//        if(!curPlayer.isMyTerritory(to)){
//            return to + " do not blong to " + playerId;
//        }
//
//        // check whether have enough units
//        if(territoryNameMap.get(from).getSoliderNum() < units){
//            return "do not have enough units";
//        }
//
//        // check movement
//        List<Territory> neibor = territoryNameMap.get(from).getNeighbors();
//        if(!neibor.contains(territoryNameMap.get(to))){
//            return "they are not neibour";
//        }
//        /*
//        AbstractChecker moveChecker = new MovementChecker(null);
//        if(!moveChecker.checkAction( territoryNameMap.get(from), territoryNameMap.get(to),curPlayer)){
//            return "you cannot move from " + from + " to " + to;
//        }*/
//        return null;
//    }

    // @return null :success
    public synchronized String receiveOrder(GameActionReq gameActionReq){
        Player curPlayer = playernameMap.get(gameActionReq.getPlayerId());
        if(gameActionReq.getType().equals( "attack")){
            //TODO: need to check whether having enough units
            /*
            String errMes =
                tryAttack(curPlayer.getPlayerId(),
                          gameActionReq.getFrom(),
                          gameActionReq.getTo(),
                        gameActionReq.getUnits());


            if(errMes != null){
                return errMes;
            }*/
            //TODO: add soliders factory
            int val =territoryNameMap.get(gameActionReq.getFrom()).getFood() - gameActionReq.getConsume();
            territoryNameMap.get(gameActionReq.getFrom()).setFood(val);
            List<Soldier> soldiers = territoryNameMap.get(gameActionReq.getFrom()).moveDenfder(
                    gameActionReq.getUnits()
            );

            territoryNameMap.get(gameActionReq.getTo()).addAttacker(
                     playernameMap.get(gameActionReq.getPlayerId()),
                    soldiers
            );
            curPlayer.storeAttack(new ActionLog(
                    gameActionReq.getFrom(),
                    gameActionReq.getTo(),
                    gameActionReq.getUnits()
            ));
        }else if(gameActionReq.getType().equals("move")){
            //TODO: need to check whether having enough units
            /*
            String errMes =
                    tryMove(curPlayer.getPlayerId(),
                            gameActionReq.getFrom(),
                            gameActionReq.getTo(),
                            gameActionReq.getUnits());
            if(errMes != null){
                return errMes;
            }
            */
            int val =territoryNameMap.get(gameActionReq.getFrom()).getFood() - gameActionReq.getConsume();
            territoryNameMap.get(gameActionReq.getFrom()).setFood(val);
            List<Soldier> soldiers = territoryNameMap.get(gameActionReq.getFrom()).moveDenfder(
                    gameActionReq.getUnits()
            );
            territoryNameMap.get(gameActionReq.getTo()).addDenfder(
                    soldiers
            );
            curPlayer.storeMove(new ActionLog(
                    gameActionReq.getFrom(),
                    gameActionReq.getTo(),
                    gameActionReq.getUnits()
            ));
        }else if(gameActionReq.getType() .equals("end")){
            endPhase();
        }else if(gameActionReq.getType().equals("upgrade")){
            Territory territory = territoryNameMap.get(gameActionReq.getFrom());
            String[] arr = gameActionReq.getTo().split(",");
            int[] nums = new int[3];
            int i = 0;
            // 遍历数组并对每个字符串进行判断和转换
            for (String value : arr) {
                // 使用正则表达式检查字符串是否表示一个数字
                if (value.matches("-?\\d+")) {
                    // 如果是数字，则将其转换为整数
                    nums[i] = Integer.parseInt(value);
                }
                i++;
            }
            territory.upgradeLevel(nums[0], nums[1], nums[2]);
            // consume tech
            int val =territoryNameMap.get(gameActionReq.getFrom()).getTechnology() - gameActionReq.getConsume();
            territoryNameMap.get(gameActionReq.getFrom()).setTechnology(val);
        }else if(gameActionReq.getType().equals("research")){
            Territory territory = territoryNameMap.get(gameActionReq.getFrom());
            int tempTech = territory.getMaxTechnology();
            territory.setMaxTechnology(tempTech + 1);
            // cosume tech
            int val =territoryNameMap.get(gameActionReq.getFrom()).getTechnology() - gameActionReq.getConsume();
            territoryNameMap.get(gameActionReq.getFrom()).setTechnology(val);
        }

        return null;
    }


    public void endPhase(){
        curEndNum++;
        if(curEndNum == roomSize){
            curEndNum = 0;
            gamePhase++;
            // combat
            territoryNameMap.forEach((key, value) ->
                value.combat());
            if(gamePhase != 1){
                // add one basic unit
                territoryNameMap.forEach((key, value) ->
                        value.addOneDenfder(new TextSolider()));
                // add one basic food
                territoryNameMap.forEach((key, value) ->
                                value.setTechnology(value.getTechnology() + 5));
                // add one
                territoryNameMap.forEach((key, value) ->
                        value.setFood(value.getFood() + 5));
            }
        }
        System.out.println("current end num" + curEndNum);
        System.out.println(gamePhase);
    }
    public List<Player> getPlayers(){
        return players;
    }
    public boolean canMoveNextPhase(int curPhase){
        return curPhase < gamePhase;
    }

    public List<String> getPlayersName(){
        ArrayList<String> playersName = new ArrayList<>();
        for(Player player : players){
            playersName.add(player.getPlayerId());
        }
        return playersName;
    }

    public int getGamePhase(){
        return this.gamePhase;
    }
}
