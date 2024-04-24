package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.ActionLog;
import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TextPlayerTest {

    @Test
    void testIsMyTerritory_True() {
        // Given
        Player player = new TextPlayer("testPlayer");
        Territory territory = new TextTerritory("territoryName");
        player.assignTerritory(territory);

        // When
        boolean result = player.isMyTerritory("territoryName");

        // Then
        assertTrue(result);
    }

    @Test
    void testIsMyTerritory_False() {
        // Given
        Player player = new TextPlayer("testPlayer");

        // When
        boolean result = player.isMyTerritory("territoryName");

        // Then
        assertFalse(result);
    }

    @Test
    void testGetPlayerId() {
        // Given
        String playerId = "testPlayer";
        Player player = new TextPlayer(playerId);

        // When
        String result = player.getPlayerId();

        // Then
        assertEquals(playerId, result);
    }

    @Test
    void testSetAndGetAvailableUnits() {
        // Given
        Player player = new TextPlayer("testPlayer");
        int units = 10;

        // When
        player.setAvaliableUnits(units);
        int result = player.getAvaliableUnits();

        // Then
        assertEquals(units, result);
    }

    @Test
    void testGetTerritoryNum() {
        // Given
        Player player = new TextPlayer("testPlayer");
        Territory territory1 = new TextTerritory("territory1");
        Territory territory2 = new TextTerritory("territory2");
        player.assignTerritory(territory1);
        player.assignTerritory(territory2);

        // When
        int result = player.getTerritoryNum();

        // Then
        assertEquals(2, result);
    }

    @Test
    void testAssignAndRemoveTerritory() {
        // Given
        Player player = new TextPlayer("testPlayer");
        Territory territory = new TextTerritory("territoryName");

        // When
        player.assignTerritory(territory);
        boolean afterAssign = player.isMyTerritory("territoryName");
        player.removeTerritory(territory);
        boolean afterRemove = player.isMyTerritory("territoryName");
    }
    @Test
    void testGetTerritories() {
        // Given
        Player player = new TextPlayer("testPlayer");
        Territory territory1 = new TextTerritory("territory1");
        Territory territory2 = new TextTerritory("territory2");
        player.assignTerritory(territory1);
        player.assignTerritory(territory2);

        // When
        List<Territory> territories = player.getTerritories();

        // Then
        assertEquals(2, territories.size());
        assertTrue(territories.contains(territory1));
        assertTrue(territories.contains(territory2));
    }

    @Test
    void testStoreAttack() {
        // Given
        Player player = new TextPlayer("testPlayer");
        ActionLog actionLog = new ActionLog("from", "to", 10);

        // When
        player.storeAttack(actionLog);

        // Then
    }

    @Test
    void testStoreMove() {
        // Given
        Player player = new TextPlayer("testPlayer");
        ActionLog actionLog = new ActionLog("from", "to", 10);

        // When
        player.storeMove(actionLog);

        // Then
    }
}
