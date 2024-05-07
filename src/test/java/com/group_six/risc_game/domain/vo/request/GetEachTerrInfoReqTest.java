package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetEachTerrInfoReqTest {
    @Test
    void testGetEachTerrInfoReqConstructor() {
        String playerId = "player123";
        String roomId = "room456";
        String territoryName = "territory789";

        GetEachTerrInfoReq getEachTerrInfoReq = new GetEachTerrInfoReq();
    }

    @Test
    void testGetEachTerrInfoReqGettersAndSetters() {
        GetEachTerrInfoReq getEachTerrInfoReq = new GetEachTerrInfoReq();
        String playerId = "player321";
        String roomId = "room654";
        String territoryName = "territory987";

        getEachTerrInfoReq.setPlayerId(playerId);
        getEachTerrInfoReq.setRoomId(roomId);
        getEachTerrInfoReq.setTerritoryName(territoryName);

        assertEquals(playerId, getEachTerrInfoReq.getPlayerId());
        assertEquals(roomId, getEachTerrInfoReq.getRoomId());
        assertEquals(territoryName, getEachTerrInfoReq.getTerritoryName());
    }

}