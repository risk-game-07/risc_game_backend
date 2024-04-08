package com.group_six.risc_game.domain.vo.response;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GameActionResp {
    @NotNull
    String errMess;
}
