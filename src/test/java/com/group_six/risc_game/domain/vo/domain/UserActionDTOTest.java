package com.group_six.risc_game.domain.vo.domain;

import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserActionDTOTest {

    @Test
    void testUserActionDTOConstructor() {
        String playerId = "player1";
        ActionTypeEnum type = ActionTypeEnum.ATTACK;
        String from = "territory1";
        String to = "territory2";
        int units = 10;
        UserActionDTO userActionDTO = new UserActionDTO();
    }

    @Test
    void testUserActionDTOGettersAndSetters() {
        UserActionDTO userActionDTO = new UserActionDTO();
        String playerId = "player2";
        ActionTypeEnum type = ActionTypeEnum.MOVE;
        String from = "territory3";
        String to = "territory4";
        int units = 20;
        userActionDTO.setPlayerId(playerId);
        userActionDTO.setType(type);
        userActionDTO.setFrom(from);
        userActionDTO.setTo(to);
        userActionDTO.setUnits(units);
        assertEquals(playerId, userActionDTO.getPlayerId());
        assertEquals(type, userActionDTO.getType());
        assertEquals(from, userActionDTO.getFrom());
        assertEquals(to, userActionDTO.getTo());
        assertEquals(units, userActionDTO.getUnits());
    }

}