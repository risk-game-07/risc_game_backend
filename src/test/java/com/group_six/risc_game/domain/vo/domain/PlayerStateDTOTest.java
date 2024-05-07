package com.group_six.risc_game.domain.vo.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStateDTOTest {

    @Test
    void testPlayerStateDTOConstructor() {
        List<String> territoriesName = new ArrayList<>();
        territoriesName.add("territory1");
        List<Integer> terrUnit = new ArrayList<>();
        terrUnit.add(10);
        int units = 50;
        PlayerStateDTO playerStateDTO = new PlayerStateDTO();
    }

    @Test
    void testPlayerStateDTOGettersAndSetters() {
        PlayerStateDTO playerStateDTO = new PlayerStateDTO();
        List<String> territoriesName = new ArrayList<>();
        territoriesName.add("territory2");
        List<Integer> terrUnit = new ArrayList<>();
        terrUnit.add(20);
        int units = 100;
        playerStateDTO.setTerritoiesName(territoriesName);
        playerStateDTO.setUnits(units);
    }

}