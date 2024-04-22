package com.group_six.risc_game.client;

public class RoomDetails {
    private String[] territories;
    private int totalUnits;
    private String playerID;
    public RoomDetails(String[] territories, int totalUnits, String playerID) {
        this.territories = territories;
        this.totalUnits = totalUnits;
        this.playerID = playerID;
    }

    public String[] getTerritories() {
        return territories;
    }

    public int getTotalUnits() {
        return totalUnits;
    }
    public String getPlayerID() {
        return playerID;
    }
}

