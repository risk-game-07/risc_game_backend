package com.group_six.risc_game.domain.vo.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameActionRespTest {
    @Test
    void testGameActionRespConstructor() {
        String errMess = "error message";
        int curPhase = 1;

        GameActionResp gameActionResp = new GameActionResp();
    }

    @Test
    void testGameActionRespGettersAndSetters() {
        GameActionResp gameActionResp = new GameActionResp();
        String errMess = "new error message";
        int curPhase = 2;

        gameActionResp.setErrMess(errMess);
        gameActionResp.setCurPhase(curPhase);

        assertEquals(errMess, gameActionResp.getErrMess());
        assertEquals(curPhase, gameActionResp.getCurPhase());
    }
}