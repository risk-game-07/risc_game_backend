package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.request.AddGameReq;
import com.group_six.risc_game.domain.vo.request.GetTerritoryReq;
import com.group_six.risc_game.domain.vo.request.WaitAddGameReq;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.domain.vo.response.ApiResult;
import com.group_six.risc_game.domain.vo.response.WaitOthersResp;
import com.group_six.risc_game.service.InitGameService;
import com.group_six.risc_game.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class InitControllerTest {

    @Mock
    private InitGameService initGameService;

    @Mock
    private RoomService roomService;

    @InjectMocks
    private InitController initController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddGame() {
        AddGameReq request = new AddGameReq();
        when(initGameService.addGame(any(String.class), any(Integer.class))).thenReturn(new AddGameResp());

        ApiResult<AddGameResp> result = initController.addGame(request);
    }

    @Test
    void testWaitOther() {
        WaitAddGameReq request = new WaitAddGameReq();
        when(roomService.getRoomId(any(String.class))).thenReturn(new WaitOthersResp());

        ApiResult<WaitOthersResp> result = initController.waitOther(request);
    }

    @Test
    void testGetTerritory() {
        GetTerritoryReq request = new GetTerritoryReq();
        when(roomService.getTerritory(any(GetTerritoryReq.class))).thenReturn(new PlayerStateDTO());

        ApiResult<PlayerStateDTO> result = initController.getTerritory(request);
    }
}
