package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.domain.vo.request.AssignUnitsReq;
import com.group_six.risc_game.domain.vo.request.EndPhaseReq;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.domain.vo.request.GetTerritoryReq;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.EndPhaseResp;
import com.group_six.risc_game.domain.vo.response.GameActionResp;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class GameControllerTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private GameController gameController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAssignUnit() throws Exception {
        AssignUnitsReq request = new AssignUnitsReq();
        when(playerService.assignUnit(any(), any(), any())).thenReturn(new AssignUnitResp());
        gameController.assignUnit(request);
    }

    @Test
    void testGetWorldMap() throws Exception {
        GetTerritoryReq request = new GetTerritoryReq();
        when(playerService.getWorldMap(any())).thenReturn(new WorldMapDTO());
        gameController.getWorldMap(request);

    }

    @Test
    void testSendOrder() throws Exception {
        GameActionReq request = new GameActionReq();
        when(playerService.receiveAction(any())).thenReturn(new GameActionResp());

        gameController.sendOrder(request);

        // 可以添加更多的断言以验证方法的其他方面
    }

    @Test
    void testEndPhase() throws Exception {
        EndPhaseReq request = new EndPhaseReq();
        when(playerService.isEndPhase(anyString(), anyInt())).thenReturn(new EndPhaseResp());

        gameController.isEndPhase(request);
    }
}
