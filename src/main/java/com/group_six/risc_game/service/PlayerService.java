package com.group_six.risc_game.service;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;

public  interface PlayerService {

    /**
     * @param roomId
     * @param playerId
     * @param from
     * @param to
     * @param num
     */
    String attack(String roomId, String playerId, String from, String to, int num);
    String move(String roomId, String playerld, String from, String to, int num);
    boolean onePlayerEnd();
    void computerResult();
    void isRoundOver();
    GameResultDTO getResult(int gameRound);
}

