package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.HashSet;

public class TextPlayer implements Player {
    private String playerId;

    public TextPlayer(String str){
        // init player id
        playerId = str;
    }
    public String getPlayerId(){
        return playerId;
    }

    @Override
    public HashSet<Territory> getTerritories() {
        return null;
    }
}
