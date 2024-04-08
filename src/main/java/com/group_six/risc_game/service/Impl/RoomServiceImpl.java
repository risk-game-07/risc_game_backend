package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.service.RoomService;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public void addToRoomWaitList(String playerId, int roomSize){
        redisUtils.addToListTail(Integer.toString(roomSize), playerId);
    }

    @Override
    // get the number of player in the room
    public long getCurPlayerNum(int roomSize){
        long curNum = redisUtils.getListLength(Integer.toString(roomSize)) % roomSize;
        return curNum == 0 ? roomSize : curNum;
    }

    @Override
    public boolean isValid(String playerId) {
        Object status = (redisUtils.get(playerId));
        if(status == null){
            return false;
        } else{

        }
    }


}
