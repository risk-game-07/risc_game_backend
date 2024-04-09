package com.group_six.risc_game.model;

import lombok.Data;

import java.security.PublicKey;
import java.util.HashSet;


public interface Player{
    public int getTerritoryNum();
    public String getPlayerId();
    public boolean isMyTerritory(String territoryName);
    public HashSet<Territory> getTerritories();
    public void storeAttack(ActionLog actionLog);
    public void storeMove(ActionLog actionLog);
    public void removeTerritory(Territory territory);
    public void assignTerritory(Territory territory);

}
