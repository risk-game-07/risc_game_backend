package com.group_six.risc_game.domain.vo.domain;

import lombok.Data;

import java.util.List;

@Data
public class WorldMapDTO {
    List<String> playersName;
    List<PlayerStateDTO> playersState;
}
