package com.group_six.risc_game;

import com.group_six.risc_game.model.GameRooms;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
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


}
