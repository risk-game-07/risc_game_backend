package com.group_six.risc_game.client;

import lombok.Data;

import java.util.List;
@Data
public class ClientPlayer {
    List<String> territoryName;
    List<Integer> territoryNum;
    int units;

    public ClientPlayer( List<String> territoryName, int units, List<Integer> territoryNum){
        this.territoryName = territoryName;
        this.units = units;
        this.territoryNum = territoryNum;
    }
}
