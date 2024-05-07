package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SendMesReqTest {
    @Test
    void testSendMesReqConstructor() {
        String message = "Hello";
        String targetUser = "user123";
        String fromUser = "user456";

        SendMesReq sendMesReq = new SendMesReq();
    }

    @Test
    void testSendMesReqGettersAndSetters() {
        SendMesReq sendMesReq = new SendMesReq();
        String message = "Hi";
        String targetUser = "user789";
        String fromUser = "user1011";

        sendMesReq.setMessage(message);
        sendMesReq.setTargetUser(targetUser);
        sendMesReq.setFromUSer(fromUser);

        assertEquals(message, sendMesReq.getMessage());
        assertEquals(targetUser, sendMesReq.getTargetUser());
        assertEquals(fromUser, sendMesReq.getFromUSer());
    }
}