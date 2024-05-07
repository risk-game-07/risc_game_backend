package com.group_six.risc_game.service;

import com.group_six.risc_game.RiscGameApplication;
import com.group_six.risc_game.domain.vo.domain.WorldMapDTO;
import com.group_six.risc_game.domain.vo.request.GameActionReq;
import com.group_six.risc_game.domain.vo.response.AssignUnitResp;
import com.group_six.risc_game.domain.vo.response.EndPhaseResp;
import com.group_six.risc_game.model.GameRoom;
import com.group_six.risc_game.model.GameRooms;
import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;
import com.group_six.risc_game.service.Impl.PlayerServiceImpl;
import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RiscGameApplication.class)
class PlayerServiceTest {

    @Mock
    private RedisUtils redisUtils;
    @Mock
    private GameRooms gameRooms;
    @Mock
    private GameRoom gameRoom;
    @Mock
    private Player player;
    @Mock
    private Territory territory;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAssignUnit() {
        String playerId = "player1";
        String roomId = "room1";
        Map<String, Integer> assignPattern = new HashMap<>();
        assignPattern.put("territory1", 10);
        assignPattern.put("territory2", 20);

        Territory territory1 = mock(Territory.class);
        Territory territory2 = mock(Territory.class);

        when(gameRooms.getGameRoom(roomId)).thenReturn(gameRoom);
        when(gameRoom.getPlayer(playerId)).thenReturn(player);
        when(gameRoom.getTerritory("territory1")).thenReturn(territory1);
        when(gameRoom.getTerritory("territory2")).thenReturn(territory2);

        AssignUnitResp response = playerService.assignUnit(assignPattern, playerId, roomId);
    }

    @Test
    public void testGetEachTerritoryInfo() {
        String roomId = "room1";
        String playerId = "player1";
        String terrName = "territory1";

        when(gameRooms.getGameRoom(roomId)).thenReturn(gameRoom);
        when(gameRoom.getTerritory(terrName)).thenReturn(territory);

        playerService.getEachTerritoryInfo(roomId, playerId, terrName);

    }

    @Test
    public void testReceiveAction() {
        GameActionReq gameActionReq = new GameActionReq();
        gameActionReq.setRoomId("room1");

        when(gameRooms.getGameRoom(gameActionReq.getRoomId())).thenReturn(gameRoom);

        playerService.receiveAction(gameActionReq);
    }

    @Test
    void testGetWorldMap() {
        // 创建一个模拟的WorldMapDTO对象
        WorldMapDTO expectedWorldMap = new WorldMapDTO();

        // 设置模拟对象的行为
        when(gameRooms.getWorldMap(anyString())).thenReturn(expectedWorldMap);

        // 调用被测试方法
        WorldMapDTO actualWorldMap = playerService.getWorldMap("roomId");

        // 验证行为是否符合预期
        assertEquals(expectedWorldMap, actualWorldMap);
    }

    @Test
    void testIsEndPhase() {
        // 创建一个模拟的EndPhaseResp对象
        EndPhaseResp expectedEndPhaseResp = new EndPhaseResp();

        // 设置模拟对象的行为
        when(gameRooms.getGameRoom(anyString())).thenReturn(Mockito.mock(GameRoom.class));
        when(gameRooms.getGameRoom("roomId").canMoveNextPhase(anyInt())).thenReturn(true);

        // 调用被测试方法
        EndPhaseResp actualEndPhaseResp = playerService.isEndPhase("playerId", "roomId", 1);

        // 验证行为是否符合预期
        assertEquals(expectedEndPhaseResp.getIsEndOfGame(), actualEndPhaseResp.getIsEndOfGame());
//        assertEquals(expectedEndPhaseResp.isEnd(), actualEndPhaseResp.isEnd());
    }
}