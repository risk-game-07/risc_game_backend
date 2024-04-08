package com.group_six.risc_game.factory;

import com.group_six.risc_game.model.Territory;

import java.util.List;
import java.util.Map;

public interface TerritoryFactory {
    // owner -> player id
    // List<Solider>
    Map<String, Territory> makeAllTerritories();
}
