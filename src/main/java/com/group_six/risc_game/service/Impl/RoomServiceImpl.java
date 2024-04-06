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
    public void addToRoomWaitList(int playerId, int roomSize){
        redisUtils.addToListTail(Integer.toString(roomSize), Integer.toString(playerId));
    }

    @Override
    public long getCurPlayerNum(int roomSize){
        return redisUtils.getListLength(Integer.toString(roomSize)) % roomSize;
    }


}
