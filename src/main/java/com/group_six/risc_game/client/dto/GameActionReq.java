package com.group_six.risc_game.client.dto;


public class GameActionReq {

    public String getRoomId() {
        return roomId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getType() {
        return type;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getUnits() {
        return units;
    }

    String roomId;
    String playerId;

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    String type;
    String from;
    String to;
    int units;
}

