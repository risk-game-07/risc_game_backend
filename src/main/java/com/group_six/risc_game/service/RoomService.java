package com.group_six.risc_game.service;

import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.request.GetTerritoryReq;
import com.group_six.risc_game.domain.vo.response.WaitOthersResp;

import java.util.List;

public interface RoomService {
    /**
     *based on the roomsize, add to the waiting list of the room
     * **/
    public void addToRoomWaitList(String playerId, int roomSize);

    // get the current number of people in the room
    public long getCurPlayerNum(int roomSize);

    //
    public PlayerStateDTO getTerritory(GetTerritoryReq getTerritoryReq);

    // check whether player can play
    public WaitOthersResp getRoomId(String playerId);

    public List<String> getPlayersName(String roomId);
}
