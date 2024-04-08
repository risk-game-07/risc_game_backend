package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.model.WorldMap;

import java.util.List;
import java.util.Map;

public class TextWorldMap implements WorldMap{
    // key: playId, value: Territory
    Map<String, Territory> terrtories;

    public TextWorldMap(Map<String, Territory> terrtories){
        this.terrtories = terrtories;
    }

    @Override
    public int getTerrtoryNum(){
        return terrtories.size();
    }

    @Override
    public void assignOwner(Map<String, Integer> assignPattern, String playerId) {

    }

    @Override
    public void makeAttack(int playerId, int from, int to, int num) {

    }

    @Override
    public void makeMove(int playerId, int from, int to, int num) {

    }

    @Override
    public void tryMakeAttack(int playerId, int from, int to, int num) {

    }

    @Override
    public void tryMakeMove(int playerId, int from, int to, int num) {

    }

    @Override
    public List<Territory> getResult() {
        return List.of();
    }
}
