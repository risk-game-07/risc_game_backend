package com.group_six.risc_game.model;

import java.util.List;

public interface Territory {
    public void setOwner(Player owner);

    public String getTerritoryName();
    //getOwner()
    public String getOwner();


    List<Territory> getNeighbors();
}
