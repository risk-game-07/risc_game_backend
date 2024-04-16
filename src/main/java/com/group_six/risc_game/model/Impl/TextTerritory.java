package com.group_six.risc_game.model.Impl;


import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Soldier;
import com.group_six.risc_game.model.Territory;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TextTerritory implements Territory {
    // owner -> player id
    Player owner;
    Player newOwner;
    // all soldier
    List<Soldier> soldiers;

    // terriotoryName
    String territoryName;

    // neighbors
    List<Territory> neighbors;

    // store attacker during the game
    Map<Player,List<Soldier>> attackers;

    public void setNeighbors() {
        if (territoryName.equals("Arcadia")) {
            neighbors.add(new TextTerritory("Belmont"));
            neighbors.add(new TextTerritory("Citadel"));
        } else if (territoryName.equals("Belmont")) {
            neighbors.add(new TextTerritory("Arcadia"));
            neighbors.add(new TextTerritory("Duskwood"));
            neighbors.add(new TextTerritory("Ironforge"));
        } else if (territoryName.equals("Ironforge")) {
            neighbors.add(new TextTerritory("Belmont"));
            neighbors.add(new TextTerritory("Kaldoria"));
        } else if (territoryName.equals("Citadel")) {
            neighbors.add(new TextTerritory("Arcadia"));
            neighbors.add(new TextTerritory("Duskwood"));
            neighbors.add(new TextTerritory("Frostholm"));
        } else if (territoryName.equals("Duskwood")) {
            neighbors.add(new TextTerritory("Citadel"));
            neighbors.add(new TextTerritory("Belmont"));
            neighbors.add(new TextTerritory("Kaldoria"));
            neighbors.add(new TextTerritory("Lunar Crest"));
        } else if (territoryName.equals("Kaldoria")) {
            neighbors.add(new TextTerritory("Ironforge"));
            neighbors.add(new TextTerritory("Duskwood"));
            neighbors.add(new TextTerritory("Lunar Crest"));
        } else if (territoryName.equals("Frostholm")) {
            neighbors.add(new TextTerritory("Citadel"));
            neighbors.add(new TextTerritory("Everglade"));
            neighbors.add(new TextTerritory("Havenbrook"));
        } else if (territoryName.equals("Everglade")) {
            neighbors.add(new TextTerritory("Frostholm"));
            neighbors.add(new TextTerritory("Lunar Crest"));
        } else if (territoryName.equals("Lunar Crest")) {
            neighbors.add(new TextTerritory("Kaldoria"));
            neighbors.add(new TextTerritory("Duskwood"));
            neighbors.add(new TextTerritory("Everglade"));
            neighbors.add(new TextTerritory("Jade Falls"));
            neighbors.add(new TextTerritory("Glimmermere"));
        } else if (territoryName.equals("Havenbrook")) {
            neighbors.add(new TextTerritory("Frostholm"));
            neighbors.add(new TextTerritory("Jade Falls"));
        } else if (territoryName.equals("Jade Falls")) {
            neighbors.add(new TextTerritory("Havenbrook"));
            neighbors.add(new TextTerritory("Lunar Crest"));
            neighbors.add(new TextTerritory("Glimmermere"));
        } else if (territoryName.equals("Glimmermere")) {
            neighbors.add(new TextTerritory("Lunar Crest"));
            neighbors.add(new TextTerritory("Jade Falls"));
        }
    }

    @Override
    public int getSoliderNum(){
        return soldiers.size();
    }

    public TextTerritory(String name){
        territoryName = name;
        neighbors = new ArrayList<>();
        attackers = new HashMap<>();
        soldiers = new ArrayList<>();
        owner = null;
        newOwner = null;
    }
    @Override
    public void setSoliders(int units){
        for(int i = 0; i < units; i++){
            soldiers.add(new TextSolider());
        }
    }

    @Override
    public void setOwner(Player owner) {
        this.owner = owner;
    }
    @Override
    public String getOwner(){
        return owner.getPlayerId();
    }

    @Override
    public void addAttacker(Player attacker, List<Soldier> soldiers){
        attackers.put(attacker, soldiers);
    }

    @Override
    public void combat(){
        if(attackers.size() == 1){
            for (Map.Entry<Player, List<Soldier>> entry : attackers.entrySet()) {
                Player attPlayer = entry.getKey();
                List<Soldier> attackSoliders = entry.getValue();
                int result = oneAndOne(soldiers, attackSoliders);
                if(result == 1){
                    // attacker win the game, need to change the owner
                    owner.removeTerritory(this);
                    owner = attPlayer;
                    owner.assignTerritory(this);
                    //TODO: add new solider to the territory
                }
                // cleaar the map
                attackers.clear();
            }
        }
        //TODO: add mutiple attack function
    }
    // @return : 0 defender win || 1 attacker win
    //TODO: change return value to enum
    private int oneAndOne(List<Soldier> denfendence, List<Soldier> attackSoldier){
        Soldier attacker = null;
        Soldier defender = null;
        while (!denfendence.isEmpty() && !attackSoldier.isEmpty()){
            if (attacker == null)
                attacker = attackSoldier.remove(0);
            if (defender == null)
                defender = denfendence.remove(0);
            attacker.attack(defender);
            if(attacker.isDie())
                attacker = null;
            else if(defender.isDie())
                defender = null;
            else
                System.out.println("[ERROR] cannot reach this place");
        }
        if(denfendence.isEmpty()){
            attackSoldier.add(attacker);
            soldiers = attackSoldier;
        }
        return attackSoldier.isEmpty() ? 0 : 1;
    }

    @Override
    public void addDenfder(List<Soldier> newSoldiers){
        soldiers.addAll(newSoldiers);
    }

    @Override
    public List<Soldier> moveDenfder(int units){
        assert (units <= soldiers.size());
        List<Soldier> subSoldier = new ArrayList<>();
        for(int i = 0; i < units; i++) {
            subSoldier.add(soldiers.remove(0));
        }
        return subSoldier;
    }
}
