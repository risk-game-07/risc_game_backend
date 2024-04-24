package com.group_six.risc_game.domain.vo.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddGameRespTest {

    @Test
    void testAddGameRespConstructor() {
        AddGameResp addGameResp = new AddGameResp();
        assertNull(addGameResp.getCurNum());
    }

    @Test
    void testAddGameRespGettersAndSetters() {
        Long curNum = 5L;
        AddGameResp addGameResp = AddGameResp.builder().curNum(curNum).build();
        assertEquals(curNum, addGameResp.getCurNum());
    }

    @Test
    void testAddGameRespGettersAndSetter() {
        Long curNum = 5L;
        AddGameResp addGameResp = new AddGameResp();
        addGameResp.setCurNum(curNum);
        assertEquals(curNum, addGameResp.getCurNum());
    }

}