package com.group_six.risc_game.domain.vo.request;

import javax.validation.constraints.NotNull;

public class WaitAddGameReq {
    @NotNull
    String playerId;
}
