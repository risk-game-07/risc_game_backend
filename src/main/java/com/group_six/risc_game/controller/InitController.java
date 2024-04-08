package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.AssignUnitDTO;
import com.group_six.risc_game.domain.vo.request.AddGameReq;
import com.group_six.risc_game.domain.vo.request.WaitAddGameReq;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.domain.vo.response.ApiResult;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.service.InitGameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * The initialization of the game
 * </p>
 * @date 2024-04-05
 */
@RestController
@RequestMapping("/game/init")
@Api(tags = "The Init of the game")
@Slf4j
public class InitController {
    @Autowired
    InitGameService initGameService;

    @GetMapping("/addGame")
    @ApiOperation("add to the game")
    public ApiResult<AddGameResp> addGame(@Valid AddGameReq request) {
        return ApiResult.success(initGameService.addGame(request.getPlayerId(), request.getRoomSize()));
    }

    @PostMapping("/assignUnit")
    @ApiOperation("assign units of the territory")
    public ApiResult<AssignUnitResp> assignUnit(@Valid AssignUnitDTO unit) {
        return ApiResult.success(initGameService.assignUnit(unit.getAssignPattern(), unit.getPlayerId()));
    }

    @GetMapping("/waitOther")
    @ApiOperation("wait other players adding to the game")
    public ApiResult<AssignUnitResp> waitOther(@Valid WaitAddGameReq request) {
        return ApiResult.success();
    }
}
