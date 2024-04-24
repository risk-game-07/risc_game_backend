package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class AttackCheckerTest {

    @Test
    void testCheckAction_ReturnsTrueWhenToIsNeighborOfFrom() {
        // 准备测试数据
        Territory from = mock(Territory.class);
        Territory to = mock(Territory.class);
        Player player = mock(Player.class);
        when(from.getOwner()).thenReturn("playerId");
        when(to.getOwner()).thenReturn("playerId");
        when(player.getPlayerId()).thenReturn("playerId");
        when(from.getNeighbors()).thenReturn(List.of(to));

        // 创建被测对象
        AttackChecker attackChecker = new AttackChecker(null);
        boolean result = attackChecker.checkAction(from, to, player);
    }

    @Test
    void testCheckAction_ReturnsFalseWhenToIsNotNeighborOfFrom() {
        // 准备测试数据
        Territory from = mock(Territory.class);
        Territory to = mock(Territory.class);
        Player player = mock(Player.class);
        when(from.getOwner()).thenReturn("playerId");
        when(to.getOwner()).thenReturn("playerId");
        when(player.getPlayerId()).thenReturn("playerId");
        when(from.getNeighbors()).thenReturn(List.of(mock(Territory.class)));

        // 创建被测对象
        AttackChecker attackChecker = new AttackChecker(null);

        // 执行测试
        boolean result = attackChecker.checkAction(from, to, player);

        // 验证结果
        assertFalse(result);
    }
}
