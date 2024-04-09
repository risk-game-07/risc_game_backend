package com.group_six.risc_game.model;

import lombok.Data;

import java.security.PublicKey;
import java.util.HashSet;
import java.util.List;


public interface Player{
    public int getTerritoryNum();
    public void setAvaliableUnits(int num);
    public String getPlayerId();
    public boolean isMyTerritory(String territoryName);
    public List<Territory> getTerritories();
    public void storeAttack(ActionLog actionLog);
    public void storeMove(ActionLog actionLog);
    public void removeTerritory(Territory territory);
    public void assignTerritory(Territory territory);
    public int getAvaliableUnits();
}
