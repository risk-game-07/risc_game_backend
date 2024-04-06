package com.group_six.risc_game.service;

import com.group_six.risc_game.domain.vo.request.AddGameReq;
import com.group_six.risc_game.domain.vo.response.AddGameResp;

public interface InitGameService {
    public AddGameResp addGame(String playerId, int roomSize);
}
