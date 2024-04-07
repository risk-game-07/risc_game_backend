package com.group_six.risc_game.model;

import java.util.List;

public interface Territory {
    public void setOwner(String owner);

    List<Territory> getNeighbors();
}
