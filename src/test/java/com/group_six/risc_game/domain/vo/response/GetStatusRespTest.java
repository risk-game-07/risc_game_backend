package com.group_six.risc_game.domain.vo.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetStatusRespTest {
    @Test
    void testConstructor() {
        // Given
        Boolean status = true;

        // When
        GetStatusResp getStatusResp = new GetStatusResp(status);

        // Then
        assertEquals(status, getStatusResp.getStatus());
    }

}