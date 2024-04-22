package com.group_six.risc_game.factory.Impl;

import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class TerritoryFactoryTest {

    @Mock
    private RedisUtils redisUtils;

    @InjectMocks
    private TextTerritoryFactory territoryFactory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testMakeTerritory() {
        int index = 1;
        Territory territory = territoryFactory.makeTerritory(index);
        assertNotNull(territory);
    }
}