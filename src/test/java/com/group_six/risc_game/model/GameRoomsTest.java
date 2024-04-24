package com.group_six.risc_game.model;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.model.GameRoom;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.model.Impl.TextPlayer;
import com.group_six.risc_game.model.Impl.TextTerritory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
public class GameRoomsTest {
    @Autowired
    GameRooms gameRooms;
    @Test
    void createRoomTest(){
        List<String> players = new ArrayList<>();
        players.add("test_01");
        players.add("test_02");
        players.add("test_03");
        assert gameRooms.getGameRoom(gameRooms.createRoom(3, players)) != null;
    }

    @Test
    void testGetResult() {
        // Given
        GameRoom gameRoom = new GameRoom(2, Arrays.asList("player1", "player2"), "room1");
        Player player = new TextPlayer("player1");
        player.assignTerritory(new TextTerritory("territory1"));
        player.setAvaliableUnits(20);

        // When
        PlayerStateDTO result = null;

    }

    @Test
    void testGetWorldMap() {
        // Given
        GameRoom gameRoom = new GameRoom(2, Arrays.asList("player1", "player2"), "room1");
        Player player1 = new TextPlayer("player1");
        player1.assignTerritory(new TextTerritory("territory1"));
        player1.setAvaliableUnits(20);
        Player player2 = new TextPlayer("player2");
        player2.assignTerritory(new TextTerritory("territory2"));
        player2.setAvaliableUnits(25);

        // When
        WorldMapDTO result = null;

        // Then
    }


}
