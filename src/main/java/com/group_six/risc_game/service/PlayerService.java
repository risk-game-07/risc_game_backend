package com.group_six.risc_game.service;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;

public  interface PlayerService {
    public void executeActions();
    public void addPlayer();
    public boolean attack(int playerId, String from, String to, int num);
    public boolean move(int playerld, String from, String to, int num);
    public void onePlayerEnd();
    public void computerResult();
    public boolean isRoundOver();
}

