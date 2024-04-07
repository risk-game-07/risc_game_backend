package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    RedisUtils redisUtils;
    @Override
    public String attack(String roomId, String playerId, String from, String to, int num) {
        // try attack

        // add to the redis
        // 1234_tom_from_to_12
        redisUtils.set(roomId + "_" + playerId, from + "_" + to + "_" + Integer.toString(num));

    }

    @Override
    public String move(String roomId, String playerld, String from, String to, int num) {
        return;
    }

    @Override
    public boolean onePlayerEnd() {
        return false;
    }

    @Override
    public void computerResult() {

    }

    @Override
    public void isRoundOver() {

    }

    @Override
    public GameResultDTO getResult(int gameRound) {
        return null;
    }
}
