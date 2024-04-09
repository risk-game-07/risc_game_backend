package com.group_six.risc_game.domain.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class GameActionReq {
    @NotNull
    String roomId;
    @NotNull
    String playerId;
    @NotNull
    String type;
    String from;
    String to;
    int units;
}
