package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.domain.vo.request.*;
import com.group_six.risc_game.domain.vo.response.*;
import com.group_six.risc_game.service.ChatService;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class gameControllerTest {
    @Mock
    private RoomService roomService;

    @Mock
    private PlayerService playerService;

    @Mock
    private ChatService chatService;

    @InjectMocks
    private gameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAssignUnit() {
        AssignUnitsReq request = new AssignUnitsReq();
        when(playerService.assignUnit(request.getAssignPattern(), request.getPlayerId(), request.getRoomId())).thenReturn(new AssignUnitResp());

        ApiResult<AssignUnitResp> result = gameController.assignUnit(request);
    }

    @Test
    void testGetWorldMap() {
        GetTerritoryReq request = new GetTerritoryReq();
        when(playerService.getWorldMap("room1")).thenReturn(new WorldMapDTO());

        ApiResult<WorldMapDTO> result = gameController.getWorldMap(request);
    }

    @Test
    void testSendOrder() {
        GameActionReq request = new GameActionReq();
        GameActionResp expectedResponse = new GameActionResp();

        when(playerService.receiveAction(request)).thenReturn(expectedResponse);

        ApiResult<GameActionResp> result = gameController.sendOrder(request);
    }

    @Test
    void testIsEndPhase() {
        EndPhaseReq request = new EndPhaseReq();
        request.setPlayerId("player1");
        request.setRoomId("room1");
        request.setNumPhase(1);
        EndPhaseResp expectedResponse = new EndPhaseResp();

        when(playerService.isEndPhase("player1", "room1", 1)).thenReturn(expectedResponse);

        ApiResult<EndPhaseResp> result = gameController.isEndPhase(request);

        assertEquals(ApiResult.success(expectedResponse), result);
    }

    @Test
    void testGetEachTerritory() {
        EachTerrInfo request = new EachTerrInfo();
        request.setRoomId("room1");
        request.setPlayerId("player1");
        request.setName("territory1");
        EachTerrInfoResp expectedResponse = new EachTerrInfoResp();
        when(playerService.getEachTerritoryInfo("room1", "player1", "territory1")).thenReturn(expectedResponse);

        ApiResult<EachTerrInfoResp> result = gameController.getEachTerritory(request);

        assertEquals(ApiResult.success(expectedResponse), result);
    }

    @Test
    void testSendMessage() {
        // 准备测试数据
        SendMesReq request = new SendMesReq();
        request.setFromUSer("user1");
        request.setTargetUser("user2");
        request.setMessage("Hello");

        // 调用待测方法
        gameController.sendMessage(request);

        // 验证方法是否按预期调用
        verify(chatService).sendMessage("user1", "user2", "Hello");
    }

    @Test
    void testGetMessage() {
        // 准备测试数据
        SendMesReq request = new SendMesReq();
        request.setFromUSer("user1");
        when(chatService.getNewMessage("user1")).thenReturn("New message");

        // 调用待测方法
        ApiResult<String> result = gameController.getMessage(request);

        // 验证结果
        assertEquals(ApiResult.success("New message"), result);
    }

    @Test
    void testGetPlayersName() {
        // 准备测试数据
        GetPlayersNameReq request = new GetPlayersNameReq();
        request.setRoomId("room1");
        List<String> expectedPlayers = new ArrayList<>();
        expectedPlayers.add("player1");
        expectedPlayers.add("player2");
        when(roomService.getPlayersName("room1")).thenReturn(expectedPlayers);

        // 调用待测方法
        ApiResult<List<String>> result = gameController.getPlayersName(request);

        // 验证结果
        assertEquals(ApiResult.success(expectedPlayers), result);
    }
}