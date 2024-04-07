package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;
import com.group_six.risc_game.model.GameRoom;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    GameRooms gameRooms;


}
