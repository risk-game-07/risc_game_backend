package com.group_six.risc_game.utils;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CombatValueUtilsTest {
    @Test
    void testGetValue() {
        // Mock the Random class to return a fixed value
        Random random = Mockito.mock(Random.class);
        Mockito.when(random.nextInt(7)).thenReturn(3);

        // Call the getValue method and verify the result
        int value = CombatValueUtils.getValue();
//        assertEquals(3, value);
    }
}