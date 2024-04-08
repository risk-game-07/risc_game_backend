package com.group_six.risc_game.model;

import java.util.List;

public interface Territory {
    public void setOwner(String owner);
    public String getTerritoryName();
    List<Territory> getNeighbors();
}
