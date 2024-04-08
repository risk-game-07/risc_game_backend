package com.group_six.risc_game.model;

import com.group_six.risc_game.domain.vo.domain.UserActionDTO;
import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
import lombok.Data;

import java.security.PublicKey;
import java.util.HashSet;


public interface Player{
    public int getTerritoryNum();
    public String getPlayerId();
    public void assignTerritory(Territory territory);
    public boolean isMyTerritory(String territoryName);
    public HashSet<Territory> getTerritories();
    public void storeAction(UserActionDTO userActionDTO);
}
