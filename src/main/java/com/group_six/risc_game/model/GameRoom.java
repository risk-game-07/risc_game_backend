package com.group_six.risc_game.model;

import com.group_six.risc_game.factory.TerritoryFactory;
import com.group_six.risc_game.model.Impl.BasicWorldMap;
import com.group_six.risc_game.model.Impl.TextPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameRoom {
    private int roomSize;
    List<Player> players;
    WorldMap worldMap;
    TerritoryFactory territoryFactory;
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
