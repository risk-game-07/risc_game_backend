package com.group_six.risc_game.domain.vo.response;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class EachTerrInfoResp {
    String owner;
    List<Integer> level;
    int technology;
    int food;
    int maxTechnologyLevel;
}
