package com.group_six.risc_game.user.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class loginDTO {
    @NotNull
    String username;
    @NotNull
    String password;
}
