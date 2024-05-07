package com.group_six.risc_game.service;

public interface ChatService {
    public void sendMessage(String fromUser, String targetUser, String mes);
    public String getNewMessage(String userName);
}
