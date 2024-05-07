package com.group_six.risc_game.domain.vo.response;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EachTerrInfoRespTest {
    @Test
    void testEachTerrInfoRespConstructor() {
        String owner = "owner";
        List<Integer> level = new ArrayList<>(Arrays.asList(1, 2));
        int technology = 10;
        int food = 20;
        int maxTechnologyLevel = 5;
        EachTerrInfoResp resp = new EachTerrInfoResp();
    }

    @Test
    void testEachTerrInfoRespGettersAndSetters() {
        EachTerrInfoResp resp = new EachTerrInfoResp();
        String owner = "different_owner";
        List<Integer> level = new ArrayList<>(Arrays.asList(2, 3));
        int technology = 20;
        int food = 30;
        int maxTechnologyLevel = 6;

        resp.setOwner(owner);
        resp.setLevel(level);
        resp.setTechnology(technology);
        resp.setFood(food);
        resp.setMaxTechnologyLevel(maxTechnologyLevel);

        assertEquals(owner, resp.getOwner());
        assertEquals(level, resp.getLevel());
        assertEquals(technology, resp.getTechnology());
        assertEquals(food, resp.getFood());
        assertEquals(maxTechnologyLevel, resp.getMaxTechnologyLevel());
    }
}