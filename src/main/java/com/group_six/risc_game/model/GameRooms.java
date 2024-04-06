package com.group_six.risc_game.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameRooms {
    List<GameRoom> rooms;

    public void GameRooms(){
        rooms = new ArrayList<>();
    }
    void createRoom(int roomSize, List<String> playerIds){

    }
}
