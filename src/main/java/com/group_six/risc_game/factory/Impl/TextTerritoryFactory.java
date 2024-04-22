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
    public Territory makeTerritory(int index) {
        List<Territory> territories = new ArrayList<>();
        String[] nameList = {"Arcadia","Belmont", "Citadel","Duskwood",
                "Everglade", "Frostholm","Glimmermere","Havenbrook",
                "Ironforge","Jade Falls", "Kaldoria", "Lunar Crest"};
        Territory territory =  new TextTerritory(nameList[index]);
        territory.setTechnology(100);
        territory.setFood(100);
        return territory;
    }

}
