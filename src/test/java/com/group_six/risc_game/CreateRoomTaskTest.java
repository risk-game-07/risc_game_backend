package com.group_six.risc_game;

import com.group_six.risc_game.service.RoomService;
import com.group_six.risc_game.task.CreateRoomTask;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
public class CreateRoomTaskTest {
    @Autowired
    CreateRoomTask createRoomTask;
    @Autowired
    RoomService roomService;
    @Autowired
    RedisUtils redisUtils;
    //TODO: in the end of the game, you should delete all the keys
    @Test
    void testCreateTwoPlayersRoom(){
        roomService.addToRoomWaitList("test_1", 2);
        roomService.addToRoomWaitList("test_2", 2);
        createRoomTask.create();
        // delete all user name
        redisUtils.del("test_1");
        redisUtils.del("test_2");

    }
    @Test
    void testCreateThreePlayersRoom(){
        roomService.addToRoomWaitList("test_1", 3);
        roomService.addToRoomWaitList("test_2", 3);
        roomService.addToRoomWaitList("test_3", 3);
        createRoomTask.create();
        assertEquals(0, redisUtils.getListLength("3"));
        assertEquals(
                roomService.getRoomId("test_1"),
                roomService.getRoomId("test_3"));
        // delete all user name
        redisUtils.del("test_1");
        redisUtils.del("test_2");
        redisUtils.del("test_3");

    }

    @Test
    void testCreateFourPlayersRoom(){
        roomService.addToRoomWaitList("test_1", 4);
        roomService.addToRoomWaitList("test_2", 4);
        roomService.addToRoomWaitList("test_3", 4);
        roomService.addToRoomWaitList("test_4", 4);
        createRoomTask.create();
        assertEquals(0, redisUtils.getListLength("4"));
        assertEquals(
                roomService.getRoomId("test_1"),
                roomService.getRoomId("test_4"));
        // delete all user name
        redisUtils.del("test_1");
        redisUtils.del("test_2");
        redisUtils.del("test_3");
        redisUtils.del("test_4");
    }


}
