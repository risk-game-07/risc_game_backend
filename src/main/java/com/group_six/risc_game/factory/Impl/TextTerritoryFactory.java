package com.group_six.risc_game.factory.Impl;

import com.group_six.risc_game.factory.TerritoryFactory;
import com.group_six.risc_game.model.Impl.TextTerritory;
import com.group_six.risc_game.model.Territory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextTerritoryFactory implements TerritoryFactory {
    @Override
    public Map<String, Territory> makeAllTerritories() {
        Map<String, Territory> territories = new HashMap<>();
        String[] nameList = {
                "Avalon", "Bristol", "Cypress", "Denver",
                "Everest", "Florence", "Gibraltar", "Haven",
                 "Ivy", "Jasper", "Kensington", "Luna"
        };
        // for text terriotory you will get 12 Territories
        // TODO: change the hard code of 12
        for(int i = 0; i < 12; i++){
            territories.put(nameList[i],new TextTerritory(nameList[i]));
        }
        return territories;
    }
}
