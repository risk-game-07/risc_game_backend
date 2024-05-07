package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameActionReqTest {
    @Test
    void testGameActionReqConstructor() {
        String roomId = "room123";
        String playerId = "player456";
        String type = "attack";
        String from = "territory1";
        String to = "territory2";
        int units = 5;
        int consume = 2;

        GameActionReq gameActionReq = new GameActionReq();
    }

    @Test
    void testGameActionReqGettersAndSetters() {
        GameActionReq gameActionReq = new GameActionReq();
        String roomId = "room789";
        String playerId = "player123";
        String type = "move";
        String from = "territory3";
        String to = "territory4";
        int units = 10;
        int consume = 3;

        gameActionReq.setRoomId(roomId);
        gameActionReq.setPlayerId(playerId);
        gameActionReq.setType(type);
        gameActionReq.setFrom(from);
        gameActionReq.setTo(to);
        gameActionReq.setUnits(units);
        gameActionReq.setConsume(consume);

        assertEquals(roomId, gameActionReq.getRoomId());
        assertEquals(playerId, gameActionReq.getPlayerId());
        assertEquals(type, gameActionReq.getType());
        assertEquals(from, gameActionReq.getFrom());
        assertEquals(to, gameActionReq.getTo());
        assertEquals(units, gameActionReq.getUnits());
        assertEquals(consume, gameActionReq.getConsume());
    }
}