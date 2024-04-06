package com.group_six.risc_game.service;

public interface RoomService {
    /**
     *based on the roomsize, add to the waiting list of the room
     * **/
    public void addToRoomWaitList(int playerId, int roomSize);

    // get the current number of people in the room
    public long getCurPlayerNum(int roomSize);

}
