package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EachTerrInfoTest {
    @Test
    void testEachTerrInfoConstructor() {
        String roomId = "room123";
        String playerId = "player456";
        String name = "territoryName";

        EachTerrInfo eachTerrInfo = new EachTerrInfo();
    }

    @Test
    void testEachTerrInfoGettersAndSetters() {
        EachTerrInfo eachTerrInfo = new EachTerrInfo();
        String roomId = "room789";
        String playerId = "player123";
        String name = "territoryName123";

        eachTerrInfo.setRoomId(roomId);
        eachTerrInfo.setPlayerId(playerId);
        eachTerrInfo.setName(name);

        assertEquals(roomId, eachTerrInfo.getRoomId());
        assertEquals(playerId, eachTerrInfo.getPlayerId());
        assertEquals(name, eachTerrInfo.getName());
    }
}