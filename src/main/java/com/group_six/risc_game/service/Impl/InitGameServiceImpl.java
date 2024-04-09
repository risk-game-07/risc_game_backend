package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.service.InitGameService;
import com.group_six.risc_game.service.RoomService;
import com.group_six.risc_game.task.CreateRoomTask;
import com.group_six.risc_game.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class InitGameServiceImpl implements InitGameService {
    @Autowired
    RoomService roomService;
    @Autowired
    CreateRoomTask createRoomTask;
    @Autowired
    RedisUtils redisUtils;

    public AddGameResp addGame(String playerId, int roomSize){
        // find avaliable game
        roomService.addToRoomWaitList(playerId, roomSize);

        // add to the room
        return new AddGameResp(roomService.getCurPlayerNum(roomSize));
    }



}
