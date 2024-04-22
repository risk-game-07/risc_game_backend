package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.EndPhaseResp;
import com.group_six.risc_game.domain.vo.response.GameActionResp;
import com.group_six.risc_game.model.GameRoom;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
class PlayerServiceImplTest {

    private PlayerService playerService;
    private RedisUtils redisUtils;
    private GameRooms gameRooms;

    @BeforeEach
    void setUp() {
        redisUtils = mock(RedisUtils.class);
        gameRooms = mock(GameRooms.class);
        playerService = new PlayerServiceImpl(redisUtils, gameRooms);
    }

    @Test
    void testAssignUnit() {
        Map<String, Integer> assignPattern = new HashMap<>();
        assignPattern.put("territory1", 5);
        String playerId = "player1";
        String roomId = "room1";

        GameRoom gameRoom = mock(GameRoom.class);
        when(gameRooms.getGameRoom(roomId)).thenReturn(gameRoom);
        Territory territory = mock(Territory.class);
        when(gameRoom.getTerritory("territory1")).thenReturn(territory);
        playerService.assignUnit(assignPattern, playerId, roomId);
    }

    @Test
    void testReceiveAction() {
        String roomId = "room1";
        GameActionReq gameActionReq = new GameActionReq();
        gameActionReq.setRoomId(roomId);

        GameRoom gameRoom = mock(GameRoom.class);
        when(gameRooms.getGameRoom(roomId)).thenReturn(gameRoom);
        playerService.receiveAction(gameActionReq);
    }

    @Test
    void testGetWorldMap() {
        String roomId = "room1";
        playerService.getWorldMap(roomId);
    }

    @Test
    void testIsEndPhase() {
        String roomId = "room1";
        int gamePhase = 2;
        GameRoom gameRoom = mock(GameRoom.class);
        when(gameRooms.getGameRoom(roomId)).thenReturn(gameRoom);
        playerService.isEndPhase(roomId, gamePhase);
    }
}