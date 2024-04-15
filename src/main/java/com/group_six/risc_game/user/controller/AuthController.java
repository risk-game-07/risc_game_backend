package com.group_six.risc_game.user.controller;


import com.group_six.risc_game.domain.vo.request.AssignUnitsReq;
import com.group_six.risc_game.domain.vo.response.ApiResult;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.user.domain.loginDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/game/user/auth")
@Api(tags = "The Init of the game")
@Slf4j
public class AuthController{
    @PostMapping("/login")
    @ApiOperation("assign units of the territory")
    public ApiResult assignUnit(@Valid @RequestBody loginDTO request) {
        System.out.println(request.getPassword());
        System.out.println(request.getUsername());
        return ApiResult.success();
    }

}
