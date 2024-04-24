package com.group_six.risc_game.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionLogTest {
    @Test
    void testConstructor() {
        // Given
        String from = "A";
        String to = "B";
        int units = 10;

        // When
        ActionLog actionLog = new ActionLog(from, to, units);

        // Then
        assertEquals(from, actionLog.getFrom());
        assertEquals(to, actionLog.getTo());
        assertEquals(units, actionLog.getUnits());
    }
}