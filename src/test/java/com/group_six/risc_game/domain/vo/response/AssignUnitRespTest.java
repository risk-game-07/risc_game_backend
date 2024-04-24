package com.group_six.risc_game.domain.vo.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssignUnitRespTest {
    @Test
    void testConstructor() {
        // Given
        String playerId = "player1";

        // When
        AssignUnitResp assignUnitResp = new AssignUnitResp(playerId);

        // Then
        assertEquals(playerId, assignUnitResp.getPlayerID());
    }
}