package com.group_six.risc_game.model;

import com.group_six.risc_game.model.GameRooms;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class GameRoomTest {

    @Test
    void testConstructor() {
        // Given
        int roomSize = 2;
        List<String> playersId = Arrays.asList("player1", "player2");
        String roomId = "room1";

        // When
        GameRoom gameRoom = new GameRoom(roomSize, playersId, roomId);

        // Then
    }

    @Test
    void testTryAttack_PlayerNotFound() {
        // Given
        GameRoom gameRoom = new GameRoom(2, Arrays.asList("player1", "player2"), "room1");
        String playerId = "player3";
        String from = "A";
        String to = "B";
        int units = 5;

        // When
        String result = gameRoom.tryAttack(playerId, from, to, units);

        // Then
    }

    @Test
    void testTryAttack_NotEnoughUnits() {
        // Given
        GameRoom gameRoom = new GameRoom(2, Arrays.asList("player1", "player2"), "room1");
        String playerId = "player1";
        String from = "A";
        String to = "B";
        int units = 5;

        // When
        String result = gameRoom.tryAttack(playerId, from, to, units);

        // Then
    }

    @Test
    void testTryAttack_SourceTerritoryDoesNotBelongToPlayer() {
        // Given
        GameRoom gameRoom = new GameRoom(2, Arrays.asList("player1", "player2"), "room1");
        String playerId = "player1";
        String from = "A";
        String to = "B";
        int units = 5;

        // When
        String result = gameRoom.tryAttack(playerId, from, to, units);

        // Then
    }

}
