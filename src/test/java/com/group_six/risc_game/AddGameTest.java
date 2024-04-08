package com.group_six.risc_game;

import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.service.InitGameService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
public class AddGameTest{

    /*
    * test add game request
     */
    @Autowired
    InitGameService initGameService;
    @Test
    public void testGetMessage(){
        AddGameResp addGameResp =  initGameService.addGame("test_1234", 2);
        System.out.println(addGameResp.getCurNum());

    }
}

