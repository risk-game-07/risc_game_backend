package com.group_six.risc_game.controller;

import com.group_six.risc_game.domain.vo.domain.UserActionDTO;
import com.group_six.risc_game.domain.vo.response.ApiResult;
import com.group_six.risc_game.domain.vo.response.UserActionResp;
import com.group_six.risc_game.service.PlayerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/game/player")
@Api(tags = "Receive the action of players")
@Slf4j
public class PlayerController {
    @Autowired
    PlayerService playerService;
    @GetMapping("/action")
    @ApiOperation("the action per round")
    public ApiResult<UserActionResp> receiveAction(@Valid UserActionDTO action) {
        // TODO arguments?
        return ApiResult.success(playerService.executeActions());
    }
}
