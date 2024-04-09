package com.group_six.risc_game;

import com.group_six.risc_game.model.GameRooms;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
public class GameRoomTest {
    GameRooms gameRooms;
    @Test
    void createRoomTest(){
        List<String> players = new ArrayList<>();
        players.add("test_01");
        players.add("test_02");
        players.add("test_03");
        
    }
}
