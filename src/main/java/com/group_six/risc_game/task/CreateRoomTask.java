package com.group_six.risc_game.task;

import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateRoomTask {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    GameRooms gameRooms;

    // each second run this task one time
    @Scheduled(fixedRate = 1000)
    public void create() {
        // 2-4 players room
        List<String> playersId = new ArrayList<>();
        if(redisUtils.getListLength("2") >= 2){
            createCertainNum(2);
        }
        else if(redisUtils.getListLength("3") >= 3){
            createCertainNum(3);
        }else if(redisUtils.getListLength("4") >= 4){
            createCertainNum(4);
        }
    }

    private void createCertainNum(int nums){
        List<String> playersId = new ArrayList<>();
        for(int i = 0; i < nums; i++)
            playersId.add(redisUtils.getFromListHead(Integer.toString(nums)));

        // use factory to create
        String roomId = gameRooms.createRoom(nums, playersId);

        // add to the finish list
        for(String playerId : playersId)
            redisUtils.set(playerId, roomId);
    }


}










