package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetStatusReqTest {
    @Test
    void testGetStatusReqConstructor() {
        int roomSize = 5;

        GetStatusReq getStatusReq = new GetStatusReq();
    }

    @Test
    void testGetStatusReqGettersAndSetters() {
        GetStatusReq getStatusReq = new GetStatusReq();
        int roomSize = 10;

        getStatusReq.setRoomSize(roomSize);

        assertEquals(roomSize, getStatusReq.getRoomSize());
    }
}