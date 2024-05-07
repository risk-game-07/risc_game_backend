package com.group_six.risc_game.service.Impl;

import com.group_six.risc_game.utils.RedisUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class ChatServiceImplTest {
    @Test
    void testSendMessage() {
        // Mock RedisUtils
        RedisUtils redisUtils = mock(RedisUtils.class);

        // Create a ChatServiceImpl instance
        ChatServiceImpl chatService = new ChatServiceImpl();
        chatService.redisUtils = redisUtils;

        // Call sendMessage method
        String fromUser = "user1";
        String targetUser = "user2";
        String message = "Hello";
        chatService.sendMessage(fromUser, targetUser, message);

        // Verify that the addToListTail method of RedisUtils is called with the correct arguments
        verify(redisUtils).addToListTail(eq("chat_" + targetUser), eq(fromUser + "_" + message));
    }

    @Test
    void testGetNewMessage() {
        // Mock RedisUtils
        RedisUtils redisUtils = mock(RedisUtils.class);

        // Create a ChatServiceImpl instance
        ChatServiceImpl chatService = new ChatServiceImpl();
        chatService.redisUtils = redisUtils;

        // Stub the getFromListHead method of RedisUtils to return a message
        String userName = "user1";
        String message = "Hello";
        when(redisUtils.getFromListHead("chat_" + userName)).thenReturn(userName + "_" + message);

        // Call getNewMessage method
        String newMessage = chatService.getNewMessage(userName);

        // Verify that the getFromListHead method of RedisUtils is called with the correct argument
        verify(redisUtils).getFromListHead("chat_" + userName);

        // Verify that the returned message is correct
        assertEquals(userName + "_" + message, newMessage);
    }
}