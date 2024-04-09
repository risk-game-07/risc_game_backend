package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;
import com.group_six.risc_game.domain.vo.domain.UserActionDTO;
import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.GameActionResp;
import com.group_six.risc_game.model.GameRoom;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    RedisUtils redisUtils;
    @Autowired
    GameRooms gameRooms;

    public AssignUnitResp assignUnit(Map<String, Integer> assignPattern, String playerId, String roomId) {
        GameRoom gameRoom= gameRooms.getGameRoom(roomId);
        Player player = gameRoom.getPlayer(roomId);
        // TODO: check whether it is work
        assignPattern.forEach((key, value) ->
                                gameRoom.getTerritory(key).setSoliders(value));
        return new AssignUnitResp(playerId);
    }

    @Override
    public GameActionResp receiveAction(GameActionReq gameActionReq){
        GameRoom gameRoom = gameRooms.getGameRoom(gameActionReq.getRoomId());
        GameActionResp gameActionResp = new GameActionResp();
        gameActionResp.setErrMess(
                gameRoom.receiveOrder(gameActionReq)
        );
        gameActionResp.setCurPhase(
                gameRoom.getGamePhase()
        );
        return gameActionResp;
    }
}
