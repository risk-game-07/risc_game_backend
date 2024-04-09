package com.group_six.risc_game.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ActionLog {
    String from;
    String to;
    int units;
}
