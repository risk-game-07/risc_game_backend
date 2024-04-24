package com.group_six.risc_game.domain.vo.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WorldMapDTOTest {
    @Test
    void testWorldMapDTOConstructor() {
        WorldMapDTO worldMapDTO = new WorldMapDTO();
    }

    @Test
    void testWorldMapDTOGettersAndSetters() {
        WorldMapDTO worldMapDTO = new WorldMapDTO();
        List<String> playersName = List.of("player1", "player2");
        List<PlayerStateDTO> playersState = new ArrayList<>();
        playersState.add(new PlayerStateDTO());
        playersState.add(new PlayerStateDTO());
        worldMapDTO.setPlayersName(playersName);
        worldMapDTO.setPlayersState(playersState);
        assertEquals(playersName, worldMapDTO.getPlayersName());
        assertEquals(playersState, worldMapDTO.getPlayersState());
    }

}