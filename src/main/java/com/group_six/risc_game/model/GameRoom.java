package com.group_six.risc_game.model;

import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.factory.Impl.TextTerritoryFactory;
import com.group_six.risc_game.factory.TerritoryFactory;
import com.group_six.risc_game.model.Impl.TextPlayer;
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
                Territory territory = territoryFactory.makeTerritory(index + i);
                player.assignTerritory(territory);
                territoryNameMap.put(territory.getTerritoryName(), territory);
            }
            index += num;
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

    String tryAttack(String playerId, String from, String to){
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
        // check attack rule
        AbstractChecker attackChecker = new AttackChecker(null);
        if(!attackChecker.checkAction( territoryNameMap.get(from), territoryNameMap.get(to),curPlayer)){
            return "you cannot attack from " + from + " to " + to;
        }
        return null;
    }

    String tryMove(String playerId, String from, String to){
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
        // check movement
        AbstractChecker moveChecker = new MovementChecker(null);
        if(!moveChecker.checkAction( territoryNameMap.get(from), territoryNameMap.get(to),curPlayer)){
            return "you cannot move from " + from + " to " + to;
        }
        return null;
    }

    // @return null :success
    public String receiveOrder(GameActionReq gameActionReq){
        Player curPlayer = playernameMap.get(gameActionReq.getPlayerId());
        if(gameActionReq.getType() == "attack"){
            //TODO: need to check whether having enough units
            String errMes =
                tryAttack(curPlayer.getPlayerId(),
                          gameActionReq.getFrom(),
                          gameActionReq.getTo());
            if(errMes != null){
                return errMes;
            }
            //TODO: add soliders factory
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
        }else if(gameActionReq.getType() == "move"){
            //TODO: need to check whether having enough units
            String errMes =
                    tryAttack(curPlayer.getPlayerId(),
                            gameActionReq.getFrom(),
                            gameActionReq.getTo());
            if(errMes != null){
                return errMes;
            }

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
        }
        return null;
    }

    public void endPhase(){
        curEndNum++;
        if(curEndNum == roomSize){
            curEndNum = 0;
            gamePhase++;
        }
    }

    public boolean canMoveNextPhase(int curPhase){
        return curPhase > gamePhase;
    }

    public int getGamePhase(){
        return this.gamePhase;
    }
}
