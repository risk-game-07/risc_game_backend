package com.group_six.risc_game.domain.vo.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStateDTOTest {

    @Test
    void testPlayerStateDTOConstructor() {
        List<String> territoriesName = new ArrayList<>(Arrays.asList("territory1"));
        List<Integer> terrTechnology = new ArrayList<>(Arrays.asList(10));
        List<Integer> terrFood = new ArrayList<>(Arrays.asList(20));
        int units = 50;

        PlayerStateDTO playerStateDTO = new PlayerStateDTO();
    }

    @Test
    void testPlayerStateDTOGettersAndSetters() {
        PlayerStateDTO playerStateDTO = new PlayerStateDTO();
        List<String> territoriesName = new ArrayList<>(Arrays.asList("territory2"));
        List<Integer> terrTechnology = new ArrayList<>(Arrays.asList(20));
        List<Integer> terrFood = new ArrayList<>(Arrays.asList(30));
        int units = 100;

        playerStateDTO.setTerritoiesName(territoriesName);
        playerStateDTO.setTerrTechnology(terrTechnology);
        playerStateDTO.setTerrFood(terrFood);
        playerStateDTO.setUnits(units);

        assertEquals(territoriesName, playerStateDTO.getTerritoiesName());
        assertEquals(terrTechnology, playerStateDTO.getTerrTechnology());
        assertEquals(terrFood, playerStateDTO.getTerrFood());
        assertEquals(units, playerStateDTO.getUnits());
    }

}