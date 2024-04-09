package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.AssignUnitDTO;
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
    /*
    @GetMapping("/waitOther")
    @ApiOperation("wait other players adding to the game")
    public ApiResult<WaitOthersResp> waitOther(@Valid WaitAddGameReq request) {
        return ApiResult.success(roomService.getRoomId(request.getPlayerId()));
    }
    */



    @PostMapping("/assignUnit")
    @ApiOperation("assign units of the territory")
    public ApiResult<AssignUnitResp> assignUnit(@Valid @RequestBody AssignUnitsReq request) {
        return ApiResult.success(playerService.assignUnit(request.getAssignPattern(),
                                                          request.getPlayerId(),
                                                          request.getRoomId()));
    }

    @GetMapping("/sendGameAction")
    @ApiOperation("send order to the game")
    public ApiResult<GameActionResp> sendOrder(@Valid GameActionReq request) {
        return ApiResult.success(playerService.receiveAction(request));
    }

    @GetMapping("/endPhase")
    @ApiOperation("end of one phase")
    public ApiResult<EndPhaseResp> isEndPhase(@Valid EndPhaseReq endPhaseReq) {
        return ApiResult.success(playerService.isEndPhase(endPhaseReq.getRoomId(), endPhaseReq.getNumPhase()));
    }

    
}
