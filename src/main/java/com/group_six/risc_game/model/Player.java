package com.group_six.risc_game.model;

import lombok.Data;

import java.util.HashSet;


public interface Player{

    String getPlayerId();

    HashSet<Territory> getTerritories();
}
