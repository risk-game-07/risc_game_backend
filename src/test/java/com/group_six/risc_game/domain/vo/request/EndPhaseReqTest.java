package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EndPhaseReqTest {
    @Test
    void testEndPhaseReqConstructor() {
        String roomId = "room123";
        String playerId = "player456";
        int numPhase = 1;

        EndPhaseReq endPhaseReq = new EndPhaseReq();
    }

    @Test
    void testEndPhaseReqGettersAndSetters() {
        EndPhaseReq endPhaseReq = new EndPhaseReq();
        String roomId = "room789";
        String playerId = "player123";
        int numPhase = 2;

        endPhaseReq.setRoomId(roomId);
        endPhaseReq.setPlayerId(playerId);
        endPhaseReq.setNumPhase(numPhase);

        assertEquals(roomId, endPhaseReq.getRoomId());
        assertEquals(playerId, endPhaseReq.getPlayerId());
        assertEquals(numPhase, endPhaseReq.getNumPhase());
    }

}