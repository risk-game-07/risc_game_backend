package com.group_six.risc_game.domain.vo.domain;

import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;

/*
* @descript: only two types: attack or defendence
 */
public class UserActionDTO {
    // attack or move
    ActionTypeEnum type;
    // from area
    String from;
    // destination area
    String to;
}
