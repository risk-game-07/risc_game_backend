package com.group_six.risc_game;

import com.group_six.risc_game.domain.vo.response.EachTerrInfoResp;
import com.group_six.risc_game.domain.vo.response.WaitOthersResp;
import com.group_six.risc_game.service.PlayerService;
import com.group_six.risc_game.service.RoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class PlayerServiceTest{
    @Autowired
    PlayerService playerService;
    @Autowired
    RoomService roomService;
    @Test
    void testGetEachTerritory() throws InterruptedException{
        roomService.addToRoomWaitList("test_1", 2);
        roomService.addToRoomWaitList("test_2", 2);
        WaitOthersResp resp = roomService.getRoomId("test_1");
        Map<String ,Integer> map = new HashMap<>();
        map.put("Arcadia", 4);
        playerService.assignUnit(map,"test_1", resp.getRoomId());
        EachTerrInfoResp eachTerrInfoResp = playerService.getEachTerritoryInfo(resp.getRoomId(),"test_1","Arcadia");
        System.out.println(eachTerrInfoResp.getOwner());
        System.out.println(eachTerrInfoResp.getFood());
        System.out.println(eachTerrInfoResp.getTechnology());
        System.out.println(eachTerrInfoResp.getLevel());
        System.out.println(eachTerrInfoResp.getMaxTechnologyLevel());
    }
}
