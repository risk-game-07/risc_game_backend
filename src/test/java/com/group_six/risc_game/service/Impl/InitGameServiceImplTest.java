package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
class InitGameServiceImplTest {
    @Autowired
    InitGameServiceImpl initGameServiceImpl;

    @Test
    void testAddGame() {
        AddGameResp addGameResp = initGameServiceImpl.addGame("1", 1);
    }
}