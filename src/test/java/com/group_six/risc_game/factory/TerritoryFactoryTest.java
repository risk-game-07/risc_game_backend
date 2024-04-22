package com.group_six.risc_game.factory;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.factory.Impl.TextTerritoryFactory;
import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
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