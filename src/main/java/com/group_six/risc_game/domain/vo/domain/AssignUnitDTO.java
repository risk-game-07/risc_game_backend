package com.group_six.risc_game.domain.vo.domain;

import lombok.Data;
import java.util.Map;

@Data
public class AssignUnitDTO {
    String playerId;
    Map<String, Integer> assignPattern;
}
