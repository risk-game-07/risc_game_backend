package com.group_six.risc_game.model;

import com.group_six.risc_game.model.Impl.TextPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameRoom {
    private int roomSize;
    List<Player> players;
    WorldMap worldMap;
    GameRoom(int roomSize, List<String> playersId){
        // create Players
        this.players = new ArrayList<>();
        for(String playerId : playersId)
            this.players.add(new TextPlayer(playerId));
        this.roomSize = roomSize;
        this.worldMap =
    }
}
