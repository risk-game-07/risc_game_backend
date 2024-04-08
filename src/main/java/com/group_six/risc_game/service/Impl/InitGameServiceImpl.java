package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.AddGameResp;
import com.group_six.risc_game.model.Impl.TextWorldMap;
import com.group_six.risc_game.model.WorldMap;
import com.group_six.risc_game.service.InitGameService;
import com.group_six.risc_game.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class InitGameServiceImpl implements InitGameService {
    @Autowired
    RoomService roomService;

    @Autowired
    TextWorldMap textWorldMap;

    public AddGameResp addGame(String playerId, int roomSize){
        // find avaliable game
        roomService.addToRoomWaitList(playerId, roomSize);
        // add to the room
        return new AddGameResp(roomService.getCurPlayerNum(roomSize));
    }

    public AssignUnitResp assignUnit(Map<String, Integer> assignPattern, String playerId) {
        textWorldMap.assignOwner(assignPattern, playerId);
        return new AssignUnitResp(playerId);
    }
}
