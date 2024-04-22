package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.request.AddGameReq;
import com.group_six.risc_game.domain.vo.request.GetTerritoryReq;
import com.group_six.risc_game.domain.vo.response.WaitOthersResp;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
class RoomServiceImplTest {

    @Autowired
    private RoomServiceImpl roomServiceImpl;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private GameRooms gameRooms;


    @Test
    void testAddToRoomWaitList() {
        roomServiceImpl.addToRoomWaitList("1", 2);
    }

    @Test
    void testGetCurPlayerNum() {
        long curPlayerNum = roomServiceImpl.getCurPlayerNum(2);
    }

    @Test
    void testGetRoomId() {
        WaitOthersResp roomId = roomServiceImpl.getRoomId("1");
    }
}