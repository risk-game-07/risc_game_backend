package com.group_six.risc_game.domain.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddGameReq {
    @NotNull
    String playerId;
    @NotNull
    int roomSize;
}
