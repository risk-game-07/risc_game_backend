package com.group_six.risc_game.domain.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class EachTerrInfo {
    @NotNull
    String roomId;
    @NotNull
    String playerId;
    @NotNull
    String name;
}

