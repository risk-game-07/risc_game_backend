package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.ActionLog;
import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.*;

public class TextPlayer implements Player {
    private String playerId;
    List<Territory> territories;
    Map<String, Territory> territorNameCache;
    List<ActionLog> attackLogs;
    List<ActionLog> defendenceLogs;

    public TextPlayer(String str){
        // init player id
        playerId = str;
        territories = new ArrayList<>();
        territorNameCache = new HashMap<>();
        attackLogs = new ArrayList<>();
        defendenceLogs = new ArrayList<>();
    }


    @Override
    public boolean isMyTerritory(String territoryName){
        return territorNameCache.get(territoryName) != null;
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
        // set owner for the territory
        territory.setOwner(this);
        territorNameCache.put(territory.getTerritoryName(), territory);
    }

    @Override
    public HashSet<Territory> getTerritories() {
        return null;
    }
    @Override
    public void storeAttack(ActionLog actionLog) {
        attackLogs.add(actionLog);
    }

    @Override
    public void storeMove(ActionLog actionLog){
        defendenceLogs.add(actionLog);
    }

}
