package com.group_six.risc_game.domain.vo.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetPlayersNameReqTest {
    @Test
    void testGetPlayersNameReqConstructor() {
        String roomId = "room123";

        GetPlayersNameReq getPlayersNameReq = new GetPlayersNameReq();
    }

    @Test
    void testGetPlayersNameReqGettersAndSetters() {
        GetPlayersNameReq getPlayersNameReq = new GetPlayersNameReq();
        String roomId = "room456";

        getPlayersNameReq.setRoomId(roomId);

        assertEquals(roomId, getPlayersNameReq.getRoomId());
    }
}