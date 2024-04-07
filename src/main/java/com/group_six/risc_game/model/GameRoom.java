package com.group_six.risc_game.model;

import com.group_six.risc_game.model.Impl.TextPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameRoom {
    private int roomSize;

    List<Player> players;
    WorldMap worldMap;

    public GameRoom(int roomSize, List<String> playersId){
        // create Players
        this.players = new ArrayList<>();
        for(String playerId : playersId)
            this.players.add(new TextPlayer(playerId));
        this.roomSize = roomSize;
        // create territory factory

        // random assingn territories for each player

    }

    private HashMap<String, Territory> randomAssign(int roomSize, List<String> playersId){
        // the number of player equal to the number of territory
        // TODO finish the function
        return new HashMap<>();
    }



}
