package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.ActionLog;
import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.*;

public class TextPlayer implements Player {
    private final String playerId;
    private final List<Territory> territories;
    private final Map<String, Territory> territorNameCache;
    private final List<ActionLog> attackLogs;
    private final List<ActionLog> defendenceLogs;
    int avaliableUnits;

    public TextPlayer(String str){
        // init player id
        playerId = str;
        territories = new ArrayList<>();
        territorNameCache = new HashMap<>();
        attackLogs = new ArrayList<>();
        defendenceLogs = new ArrayList<>();
        avaliableUnits = 0;
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
    public void setAvaliableUnits(int num){
        this.avaliableUnits = num;
    }

    @Override
    public int getAvaliableUnits(){
        return this.avaliableUnits;
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
    public void removeTerritory(Territory territory){
        territories.remove(territory);
        territory.setOwner(null);
        territorNameCache.remove(territory.getTerritoryName());

    }


    @Override
    public List<Territory> getTerritories() {
        return territories;
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
