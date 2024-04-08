package com.group_six.risc_game.model.Impl;


import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Soldier;
import com.group_six.risc_game.model.Territory;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TextTerritory implements Territory {
    // owner -> player id
    Player owner;
    // all soldier
    List<Soldier> soldiers;

    // terriotoryName
    String territoryName;

    // neighbors
    List<Territory> neighbors;

    // store attacker during the game
    List<Soldier> attackers;

    // store defendence during the defendence
    List<Soldier> denfendence;

    public TextTerritory(String name){
        territoryName = name;
        neighbors = new ArrayList<>();
        attackers = new ArrayList<>();
        denfendence = new ArrayList<>();
        soldiers = new ArrayList<>();
        owner = null;
    }
    @Override
    public void setSoliders(int units){
        for(int i = 0; i < units; i++){
            soldiers.add(new TextSolider());
        }
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }






}
