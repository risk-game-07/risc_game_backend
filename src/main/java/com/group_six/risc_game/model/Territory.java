package com.group_six.risc_game.model;

import java.util.List;

public interface Territory {
    public void setOwner(Player owner);

    public String getTerritoryName();
    //getOwner()
    public String getOwner();

    // set soliders
    public void setSoliders(int units);

    List<Territory> getNeighbors();

    public void addAttacker(Player attacker, List<Soldier> soldiers);

    public void addDenfder(List<Soldier> soldiers);

    public List<Soldier> moveDenfder(int units);

    // compute results
    public void combat();
}
