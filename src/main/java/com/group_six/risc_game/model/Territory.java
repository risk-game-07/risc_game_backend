package com.group_six.risc_game.model;

import java.util.List;

public interface Territory {
    public void setOwner(Player owner);

    public String getTerritoryName();

    //getOwner()
    public String getOwner();

    public void setNeighbors(GameRoom gameRoom);

    // set soliders
    public void setSoliders(int units);

    List<Territory> getNeighbors();

    public void addAttacker(Player attacker, List<Soldier> soldiers);
    public void addDenfder(List<Soldier> soldiers);
    public void addOneDenfder(Soldier soldier);
    public List<Soldier> moveDenfder(int units);
    // compute results
    public void combat();

    public int getSoliderNum();

    // for technology
    public void setMaxTechnology(int v);
    public int getMaxTechnology();
    public void setTechnology(int v);
    public int getTechnology();
    public int getFood();
    public void setFood(int v);
    public void upgradeLevel(int original, int target, int num);
    public List<Integer> getSolidierLevel();
}
