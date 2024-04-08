package com.group_six.risc_game.model;

import com.group_six.risc_game.domain.vo.domain.UserActionDTO;
import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
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
    WorldMap worldMap;
    AbstractChecker attackChecker;
    AbstractChecker moveChecker;


    public GameRoom(int roomSize, List<String> playersId){
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
        // init checkers
        //TODO: change it to checker list
        attackChecker = new AttackChecker(null);
        moveChecker = new MovementChecker(null);
        // create territory factory

        // random assingn territories for each player

    }

    private HashMap<String, Territory> randomAssign(int roomSize, List<String> playersId){
        // the number of player equal to the number of territory
        // TODO finish the function
        return new HashMap<>();
    }

    String erroMessage tryAttack(String playerId, String from, String to){
        //if( attackChecker.checkAction(playernameMap.get(playerId), )
    }

    String erroMessage tryDefendence(String playerId, String from, String to){

    }

    public String receiveOrder(UserActionDTO userActionDTO){

    }

}
