package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetTerritoryReqTest {
    @Test
    void testGetTerritoryReqConstructor() {
        String playerId = "player123";
        String roomId = "room456";

        GetTerritoryReq getTerritoryReq = new GetTerritoryReq();
    }

    @Test
    void testGetTerritoryReqGettersAndSetters() {
        GetTerritoryReq getTerritoryReq = new GetTerritoryReq();
        String playerId = "player789";
        String roomId = "room1011";

        getTerritoryReq.setPlayerId(playerId);
        getTerritoryReq.setRoomId(roomId);

        assertEquals(playerId, getTerritoryReq.getPlayerId());
        assertEquals(roomId, getTerritoryReq.getRoomId());
    }
}