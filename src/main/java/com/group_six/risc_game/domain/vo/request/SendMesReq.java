package com.group_six.risc_game.domain.vo.request;

import lombok.Data;

@Data
public class SendMesReq {
    String message;
    String targetUser;
    String fromUSer;
}
