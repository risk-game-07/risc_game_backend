package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.AssignUnitDTO;
import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.domain.vo.request.*;
import com.group_six.risc_game.domain.vo.response.*;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/game/start")
@Api(tags = "The Init of the game")
@Slf4j
public class gameController {

    @Autowired
    RoomService roomService;
    @Autowired
    PlayerService playerService;


    @PostMapping("/assignUnit")
    @ApiOperation("assign units of the territory")
    public ApiResult<AssignUnitResp> assignUnit(@Valid @RequestBody AssignUnitsReq request) {
        return ApiResult.success(playerService.assignUnit(request.getAssignPattern(),
                                                          request.getPlayerId(),
                                                          request.getRoomId()));
    }

    @PostMapping("/getWorldMap")
    @ApiOperation("assign units of the territory")
    public ApiResult<WorldMapDTO> getWorldMap(@Valid @RequestBody GetTerritoryReq request) {
        return ApiResult.success(playerService.getWorldMap(request.getRoomId()));
    }


    @PostMapping("/sendGameAction")
    @ApiOperation("send order to the game")
    public ApiResult<GameActionResp> sendOrder(@Valid @RequestBody GameActionReq request) {
        return ApiResult.success(playerService.receiveAction(request));
    }

    @PostMapping("/endPhase")
    @ApiOperation("end of one phase")
    public ApiResult<EndPhaseResp> isEndPhase(@Valid @RequestBody EndPhaseReq endPhaseReq) {
        return ApiResult.success(playerService.isEndPhase(endPhaseReq.getRoomId(), endPhaseReq.getNumPhase()));
    }

    @PostMapping("/getEachTerritoryInfo")
    @ApiOperation("end of one phase")
    public ApiResult<EndPhaseResp> getEachTerritory(@Valid @RequestBody EndPhaseReq endPhaseReq) {
        return ApiResult.success(playerService.isEndPhase(endPhaseReq.getRoomId(), endPhaseReq.getNumPhase()));
    }

}
