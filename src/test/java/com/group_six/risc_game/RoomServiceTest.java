package com.group_six.risc_game;

import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.service.InitGameService;
import com.group_six.risc_game.service.RoomService;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
public class RoomServiceTest{

    /*
    * test add game request
     */
    @Autowired
    RoomService roomService;
    @Autowired
    RedisUtils redisUtils;
    @Test
    public void testAddRoomWaitList(){
        // pass test
        roomService.addToRoomWaitList("test_1", 2);
        String playerId = redisUtils.getFromListHead("2");
        assertEquals(playerId, "test_1");
        assertEquals(0, redisUtils.getListLength("2"));
    }

    @Test
    public void testGetCurNum(){
        // pass test
        roomService.addToRoomWaitList("test_1", 3);
        long num = roomService.getCurPlayerNum(3);
        assertEquals(1, num);
        roomService.addToRoomWaitList("test_2", 3);
        num = roomService.getCurPlayerNum(3);
        assertEquals(2, num);
        roomService.addToRoomWaitList("test_3", 3);
        num = roomService.getCurPlayerNum(3);
        assertEquals(3, num);
        for (int i = 0; i < 3; i++)
            redisUtils.getFromListHead("3");
        assertEquals(0, redisUtils.getListLength("3"));
    }

    @Test
    void testGetRoomId() throws InterruptedException {
        roomService.addToRoomWaitList("test_1", 2);
        roomService.addToRoomWaitList("test_2", 2);
        System.out.println(roomService.getRoomId("test_1"));
        assertEquals(0, redisUtils.getListLength("2"));
    }
}


