package com.group_six.risc_game.domain.vo.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class AssignUnitsReq {
    @NotNull
    Map<String, Integer> assignPattern;
    @NotNull
    String playerId;
    @NotNull
    String roomId;
}
