package com.group_six.risc_game.model;

import com.group_six.risc_game.domain.vo.domain.UserActionDTO;
import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
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

    private HashMap<String, Territory> randomAssign(int roomSize, List<String> playersId){
        // the number of player equal to the number of territory
        // TODO finish the function
        return new HashMap<>();
    }

    private String tryAttack(String playerId, String from, String to){
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

    private String tryMove(String playerId, String from, String to){
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
        AbstractChecker moveChecker= new MovementChecker(null);
        if(!moveChecker.checkAction( territoryNameMap.get(from), territoryNameMap.get(to),curPlayer)){
            return "you cannot attack from " + from + " to " + to;
        }
        return null;
    }

    /*
    * @return : null means success store the action
     */
    public String receiveOrder(UserActionDTO userActionDTO){
        ActionTypeEnum actionTypeEnum = userActionDTO.getType();
        String ans;
        //TODO: change it to switch case
        if(actionTypeEnum == ActionTypeEnum.ATTACK){
            ans = tryAttack(userActionDTO.getPlayerId(),userActionDTO.getFrom(), userActionDTO.getTo());
            if(ans != null) return ans;
            //store action
            playernameMap.get(userActionDTO.getPlayerId()).storeAction(userActionDTO);
        }else if(actionTypeEnum == ActionTypeEnum.MOVE){
            ans =tryMove(userActionDTO.getPlayerId(),userActionDTO.getFrom(), userActionDTO.getTo());
            if(ans != null) return ans;
            // store action
            playernameMap.get(userActionDTO.getPlayerId()).storeAction(userActionDTO);
        }
        return null;
    }

    // compute the results

}
