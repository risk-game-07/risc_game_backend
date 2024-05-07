package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class AssignUnitsReqTest {
    @Test
    void testAssignUnitsReqConstructor() {
        String playerId = "player1";
        String roomId = "room1";
        Map<String, Integer> assignPattern = new HashMap<>();
        assignPattern.put("territory1", 5);

        AssignUnitsReq assignUnitsReq = new AssignUnitsReq();
    }

    @Test
    void testAssignUnitsReqGettersAndSetters() {
        AssignUnitsReq assignUnitsReq = new AssignUnitsReq();
        String playerId = "player2";
        String roomId = "room2";
        Map<String, Integer> assignPattern = new HashMap<>();
        assignPattern.put("territory2", 10);

        assignUnitsReq.setPlayerId(playerId);
        assignUnitsReq.setRoomId(roomId);
        assignUnitsReq.setAssignPattern(assignPattern);

        assertEquals(playerId, assignUnitsReq.getPlayerId(), "The playerId getter or setter is not working as expected.");
        assertEquals(roomId, assignUnitsReq.getRoomId(), "The roomId getter or setter is not working as expected.");
        assertEquals(assignPattern, assignUnitsReq.getAssignPattern(), "The assignPattern getter or setter is not working as expected.");
    }


}