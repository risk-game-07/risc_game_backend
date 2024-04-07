package com.group_six.risc_game.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameRooms {
    Map<String,GameRoom> rooms;

    public void GameRooms(){
        rooms = new HashMap<>();
    }
    void createRoom(int roomSize, List<String> playerIds){
        // create room ID

        // create
    }

    public GameRoom getGameRoom(String roomId){
        return rooms.get(roomId);
    }
}
