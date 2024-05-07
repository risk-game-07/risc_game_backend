package com.group_six.risc_game.service.Impl;


import com.group_six.risc_game.service.ChatService;
import com.group_six.risc_game.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    RedisUtils redisUtils;
    @Override
    public void sendMessage(String fromUser, String targetUser, String mes){
        redisUtils.addToListTail("chat_" + targetUser, fromUser + "_" + mes);
    }

    @Override
    public String getNewMessage(String userName){
        String mes = redisUtils.getFromListHead("chat_" + userName);
        return Objects.requireNonNullElse(mes, "");
    }
}
