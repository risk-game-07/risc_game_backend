package com.group_six.risc_game.model;

import java.util.List;
import java.util.Map;

public interface WorldMap {
    public int getTerrtoryNum();
    void assignOwner(Map<String, Integer> assignPattern, String playerId);
    void makeAttack(int playerId, int from, int to ,int num);
    void makeMove(int playerId, int from, int to, int num);
    void tryMakeAttack(int playerId, int from, int to ,int num);
    void tryMakeMove(int playerId, int from, int to, int num);
    List<Territory> getResult();
}
