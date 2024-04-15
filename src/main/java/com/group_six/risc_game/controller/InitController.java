package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.AssignUnitDTO;
import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.request.AddGameReq;
import com.group_six.risc_game.domain.vo.request.GetTerritoryReq;
import com.group_six.risc_game.domain.vo.request.WaitAddGameReq;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.domain.vo.response.ApiResult;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.WaitOthersResp;
import com.group_six.risc_game.service.InitGameService;
import com.group_six.risc_game.service.RoomService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    RoomService roomService;
    @PostMapping("/addGame")
    @ApiOperation("add to the game")
    public ApiResult<AddGameResp> addGame(@Valid @RequestBody AddGameReq request) {
        return ApiResult.success(initGameService.addGame(request.getPlayerId(), request.getRoomSize()));
    }

    @PostMapping("/waitOther")
    @ApiOperation("wait other players adding to the game")
    public ApiResult<WaitOthersResp> waitOther(@Valid  @RequestBody WaitAddGameReq request) {
        return ApiResult.success(roomService.getRoomId(request.getPlayerId()));
    }

    @PostMapping("/getTerritory")
    @ApiOperation("get the state of random assign")
    public ApiResult<PlayerStateDTO> getTerritory(@Valid @RequestBody GetTerritoryReq request) {
        return ApiResult.success(roomService.getTerritory(request));
    }

}
