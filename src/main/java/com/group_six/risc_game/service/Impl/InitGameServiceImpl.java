package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.service.InitGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InitGameServiceImpl implements InitGameService {

    AddGameResp addGame(int playerId){
        // find avaliable game
    }
}
