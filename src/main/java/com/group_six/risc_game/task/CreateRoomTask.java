package com.group_six.risc_game.task;

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

    // each second run this task one time
    @Scheduled(fixedRate = 1000)
    public void create() {
        // 2 players room
        List<String> playersId = new ArrayList<>();
        if(redisUtils.getListLength("2") >= 2){
            for(int i = 0; i < 2; i++)
                playersId.add(redisUtils.getFromListHead("2"));
            // use factory to create

        }
        // 4 players room

        // 6 players room
    }


}










