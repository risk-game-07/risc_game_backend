package com.group_six.risc_game.domain.vo.domain;

import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
import lombok.Data;

/*
* @descript: only two types: attack or defendence
 */
@Data
public class UserActionDTO {
    // the name of player
    String playerId;
    // attack or move
    ActionTypeEnum type;
    // from area
    String from;
    // destination area
    String to;
}
