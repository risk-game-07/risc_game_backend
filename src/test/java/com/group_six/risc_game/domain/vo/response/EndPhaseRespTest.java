package com.group_six.risc_game.domain.vo.response;

import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import lombok.Data;
import org.junit.jupiter.api.Test;

import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EndPhaseRespTest {
    @Test
    void testConstructor() {
        // Given
        boolean isEnd = true;
        List<PlayerStateDTO> result = new ArrayList<>();
        int isEndOfGame = 1;

        // When
        EndPhaseResp endPhaseResp = new EndPhaseResp();

        // Then
    }

}