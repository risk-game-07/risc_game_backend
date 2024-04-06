package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.model.WorldMap;

import java.util.Map;

public class BasicWorldMap implements WorldMap{
    // key: playId, value: Territory
    Map<String, Territory> terrtories;
    void BasicWorldMap(Map<String, Territory> terrtories){
        this.terrtories = terrtories;
    }

}
