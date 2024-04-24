package com.group_six.risc_game.domain.vo.domain;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AssignUnitDTOTest {
    @Test
    void testAssignUnitDTOConstructor() {
        String playerId = "player1";
        String roomId = "room1";
        Map<String, Integer> assignPattern = new HashMap<>();
        assignPattern.put("territory1", 5);
        AssignUnitDTO assignUnitDTO = new AssignUnitDTO();
    }

    @Test
    void testAssignUnitDTOGettersAndSetters() {
        AssignUnitDTO assignUnitDTO = new AssignUnitDTO();
        String playerId = "player2";
        String roomId = "room2";
        Map<String, Integer> assignPattern = new HashMap<>();
        assignPattern.put("territory2", 10);
        assignUnitDTO.setPlayerId(playerId);
        assignUnitDTO.setRoomId(roomId);
        assignUnitDTO.setAssignPattern(assignPattern);
        assertEquals(playerId, assignUnitDTO.getPlayerId());
        assertEquals(roomId, assignUnitDTO.getRoomId());
        assertEquals(assignPattern, assignUnitDTO.getAssignPattern());
    }
}