package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovementCheckerTest {

    @Test
    void testCheckAction_ReturnsTrueWhenToIsReachableFromFrom() {
        // 准备测试数据
        Territory from = mock(Territory.class);
        Territory to = mock(Territory.class);
        Player player = mock(Player.class);
        when(from.getOwner()).thenReturn("playerId");
        when(to.getOwner()).thenReturn("playerId");
        when(player.getPlayerId()).thenReturn("playerId");
        when(from.getNeighbors()).thenReturn(List.of(to));

        // 创建被测对象
        MovementChecker movementChecker = new MovementChecker(null);

        // 执行测试
        boolean result = movementChecker.checkAction(from, to, player);

        // 验证结果
        assertTrue(result);
    }

    @Test
    void testCheckAction_ReturnsFalseWhenToIsNotReachableFromFrom() {
        // Prepare test data
        Territory from = mock(Territory.class);
        Territory to = mock(Territory.class);
        Territory neighbor = mock(Territory.class); // A mock neighbor territory
        Player player = mock(Player.class);
        String playerId = "playerId";

        when(from.getOwner()).thenReturn(playerId);
        when(to.getOwner()).thenReturn(playerId);
        when(neighbor.getOwner()).thenReturn(playerId); // Make sure to stub getOwner for the neighbor
        when(player.getPlayerId()).thenReturn(playerId);

        // Ensure 'to' is not in the list of neighbors returned by 'from.getNeighbors()'

        // Create the object under test
        MovementChecker movementChecker = new MovementChecker(null);

        // Execute the test
        boolean result = movementChecker.checkAction(from, to, player);
    }
}
