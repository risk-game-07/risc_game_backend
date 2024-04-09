package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.domain.vo.response.WaitOthersResp;
import com.group_six.risc_game.service.RoomService;
import com.group_six.risc_game.task.CreateRoomTask;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private CreateRoomTask createRoomTask;

    @Override
    public void addToRoomWaitList(String playerId, int roomSize){
        redisUtils.addToListTail(Integer.toString(roomSize), playerId);

        if(redisUtils.getListLength(Integer.toString(roomSize)) >= roomSize){
            createRoomTask.create();
        }
    }

    @Override
    // get the number of player in the room
    public long getCurPlayerNum(int roomSize){
        long curNum = redisUtils.getListLength(Integer.toString(roomSize)) % roomSize;
        return curNum == 0 ? roomSize : curNum;
    }

    @Override
    // @return "0" means that still cannot add to the game
    public WaitOthersResp getRoomId(String playerId) {
        Object status = (redisUtils.get(playerId));
        WaitOthersResp waitOthersResp = new WaitOthersResp();
        if(status == null){
            waitOthersResp.setRoomId("0");
        } else{
            waitOthersResp.setRoomId((String)status);
        }
        return waitOthersResp;
    }


}
