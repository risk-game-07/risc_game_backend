package com.group_six.risc_game.model;

import com.group_six.risc_game.domain.vo.domain.PlayerStateDTO;
import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import org.springframework.stereotype.Component;
import cn.hutool.core.util.RandomUtil;

import java.util.*;

@Component
public class GameRooms {
    private final Map<String,GameRoom> rooms;

    public GameRooms(){
        rooms = new HashMap<>();
    }
    // @return: new room id
    public String createRoom(int roomSize, List<String> playersId){
        // create room ID
        String roomId = RandomUtil.randomNumbers(6);
        while (rooms.containsKey(roomId))
            roomId = RandomUtil.randomNumbers(6);
        // create new room
        GameRoom gameRoom = new GameRoom(roomSize,playersId, roomId);
        rooms.put(roomId, gameRoom);
        return roomId;
    }
    //@decript: if do not have, return null
    public GameRoom getGameRoom(String roomId){
        return rooms.get(roomId);
    }

    public PlayerStateDTO getResult(String roomId, String playerId){
        GameRoom gameRoom = rooms.get(roomId);
        Player player = gameRoom.getPlayer(playerId);
        List<Territory> territories = player.getTerritories();
        List<String> names = new ArrayList<>();

        List<Integer> terrsFood = new ArrayList<>();
        List<Integer> terrsTech = new ArrayList<>();
        for(Territory territory : territories) {
            names.add(territory.getTerritoryName());
            terrsFood.add(territory.getFood());
            terrsTech.add(territory.getTechnology());
        }
        // set state
        PlayerStateDTO playerStateDTO = new PlayerStateDTO();
        playerStateDTO.setTerritoiesName(names);
        playerStateDTO.setTerrFood(terrsFood);
        playerStateDTO.setTerrTechnology(terrsTech);
        playerStateDTO.setUnits(player.getAvaliableUnits());
        return playerStateDTO;
    }

    public WorldMapDTO getWorldMap(String roomId){
        GameRoom gameRoom = rooms.get(roomId);
        List<Player> players = gameRoom.getPlayers();
        List<PlayerStateDTO> playerStateDTOs = new ArrayList<>();
        List<String> playersName = new ArrayList<>();
        for(Player player : players) {
            playerStateDTOs.add(
                getResult(roomId, player.getPlayerId())
            );
            playersName.add(player.getPlayerId());
        }
        WorldMapDTO worldMapDTO =  new WorldMapDTO();
        worldMapDTO.setPlayersName(playersName);
        worldMapDTO.setPlayersState(playerStateDTOs);
        return worldMapDTO;
    }

}
