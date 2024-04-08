package com.group_six.risc_game.service;

import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.AddGameResp;

import java.util.Map;

public interface InitGameService {
    public AddGameResp addGame(String playerId, int roomSize);


}
