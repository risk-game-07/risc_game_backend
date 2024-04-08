package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TextPlayer implements Player {
    private String playerId;
    List<Territory> territories;

    public TextPlayer(String str){
        // init player id
        playerId = str;
        territories = new ArrayList<>();
    }

    @Override
    public String getPlayerId(){
        return playerId;
    }

    @Override
    public int getTerritoryNum(){
        return territories.size();
    }

    @Override
    public void assignTerritory(Territory territory){
        territories.add(territory);
    }

    @Override
    public HashSet<Territory> getTerritories() {
        return null;
    }
}
