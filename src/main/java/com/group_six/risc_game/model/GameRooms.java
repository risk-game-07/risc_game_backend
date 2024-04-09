package com.group_six.risc_game.model;

import org.springframework.stereotype.Component;
import cn.hutool.core.util.RandomUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class GameRooms {
    private Map<String,GameRoom> rooms;

    public void GameRooms(){
        rooms = new HashMap<>();
    }
    // @return: new room id
    public String createRoom(int roomSize, List<String> playersId){
        // create room ID
        String roomId = RandomUtil.randomNumbers(6);
        while (rooms.containsKey(roomId))
            roomId = RandomUtil.randomNumbers(6);
        // create new room
        GameRoom gameRoom = new GameRoom(roomSize,playersId, roomId);
        rooms.put(roomId, gameRoom);
        return roomId;
    }
    //@decript: if do not have, return null
    public GameRoom getGameRoom(String roomId){
        return rooms.get(roomId);
    }
}
