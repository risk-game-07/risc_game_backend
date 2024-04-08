package com.group_six.risc_game.factory;

import com.group_six.risc_game.model.Territory;

import java.util.List;

public interface TerritoryFactory {
    // owner -> player id
    // List<Solider>
    List<Territory> makeAllTerritories();
}
