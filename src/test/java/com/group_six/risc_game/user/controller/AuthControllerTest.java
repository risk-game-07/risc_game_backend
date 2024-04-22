package com.group_six.risc_game.user.controller;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.domain.vo.request.GetTerritoryReq;
import com.group_six.risc_game.domain.vo.response.ApiResult;
import com.group_six.risc_game.user.domain.loginDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
class AuthControllerTest {

    @Autowired
    AuthController authController;

    @Test
    void testAssignUnit() {
        loginDTO request = new loginDTO();
        ApiResult apiResult = authController.assignUnit(request);
    }
}