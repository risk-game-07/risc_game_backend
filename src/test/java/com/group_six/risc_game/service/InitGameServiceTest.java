package com.group_six.risc_game.service;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.controller.InitController;
import com.group_six.risc_game.domain.vo.request.AddGameReq;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
public class InitGameServiceTest {
    @Autowired
    InitController initGameService;
    @Autowired
    private RedisUtils redisUtils;

    @Test
   void  addGameTest(){
        AddGameReq addGameReq = new AddGameReq();
        addGameReq.setPlayerId("test_1");
        addGameReq.setRoomSize(2);
        initGameService.addGame(addGameReq);
    }

}
