package com.group_six.risc_game.domain.vo.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class PlayerStateDTO {
    List<String> territoiesName;
    List<Integer> terrTechnology;
    List<Integer> terrFood;
    int units;

}
