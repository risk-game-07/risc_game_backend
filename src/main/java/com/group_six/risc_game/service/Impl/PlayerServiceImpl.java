package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.domain.GameResultDTO;
import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.domain.UserActionDTO;
import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.domain.vo.enums.ActionTypeEnum;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.EachTerrInfoResp;
import com.group_six.risc_game.domain.vo.response.EndPhaseResp;
import com.group_six.risc_game.domain.vo.response.GameActionResp;
import com.group_six.risc_game.model.GameRoom;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public EachTerrInfoResp getEachTerritoryInfo(String roomId, String playerId, String terrName){
        GameRoom gameRoom= gameRooms.getGameRoom(roomId);
        Territory territory = gameRoom.getTerritory(terrName);
        EachTerrInfoResp eachTerrInfoResp = new EachTerrInfoResp();
        eachTerrInfoResp.setFood(territory.getFood());
        eachTerrInfoResp.setTechnology(territory.getTechnology());
        eachTerrInfoResp.setOwner(territory.getOwner());
        eachTerrInfoResp.setLevel(territory.getSolidierLevel());
        eachTerrInfoResp.setMaxTechnologyLevel(territory.getMaxTechnology());
        return eachTerrInfoResp;
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

    public WorldMapDTO getWorldMap(String roomId){
        return gameRooms.getWorldMap(roomId);
    }

    //override
    public EndPhaseResp isEndPhase(String playerId, String roomId, int gamePhase){
        EndPhaseResp endPhaseResp = new EndPhaseResp();
        GameRoom gameRoom = gameRooms.getGameRoom(roomId);
        endPhaseResp.setIsEndOfGame(0);
        if(gameRoom.canMoveNextPhase(gamePhase)){
            endPhaseResp.setEnd(true);
            // TODO: get game results
            List<Player> players =  gameRoom.getPlayers();
            List<PlayerStateDTO> list = new ArrayList<>();
            for(Player player : players) {
                PlayerStateDTO playerStateDTO = gameRooms.getResult(roomId,
                        player.getPlayerId());
                list.add(playerStateDTO);
            }
            endPhaseResp.setResult(list);
            for(Player player : players){
                if(player.getPlayerId().equals(playerId)){
                    if(player.getTerritories().size() == 24){
                        endPhaseResp.setIsEndOfGame(1);
                    }else if(player.getTerritories().isEmpty()){
                        endPhaseResp.setIsEndOfGame(2);
                    }else{
                        endPhaseResp.setIsEndOfGame(0);
                    }
                }
            }
            // endPhaseResp.setIsEndOfGame();
        }else{
            endPhaseResp.setEnd(false);
        }
        return endPhaseResp;
    }
}
