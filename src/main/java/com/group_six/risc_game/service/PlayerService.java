package com.group_six.risc_game.service;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.EndPhaseResp;
import com.group_six.risc_game.domain.vo.response.GameActionResp;

import java.util.Map;

public  interface PlayerService {
    public AssignUnitResp assignUnit(Map<String, Integer> assignPattern, String playerId, String roomId);
    public GameActionResp receiveAction(GameActionReq gameActionReq);
    public EndPhaseResp isEndPhase(String roomId, int gamePhase);
}

