package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AbstractCheckerTest {

    @Test
    void testCheckAction_WhenNextIsNull_ReturnsCheckMyRuleResult() {
        // 准备测试数据
        Territory from = mock(Territory.class);
        Territory to = mock(Territory.class);
        Player player = mock(Player.class);

        // 创建 Mock 对象，并模拟 checkMyRule 方法返回值
        AbstractChecker checker = mock(AbstractChecker.class);
        when(checker.checkMyRule(from, to, player)).thenReturn(true);

        // 创建被测对象
        AbstractChecker abstractChecker = new AbstractChecker(checker) {
            @Override
            protected boolean checkMyRule(Territory from, Territory to, Player player) {
                return true;
            }
        };

        boolean result = abstractChecker.checkAction(from, to, player);
    }

    @Test
    void testCheckAction_WhenNextIsNotNull_ReturnsNextCheckActionResult() {
        // 准备测试数据
        Territory from = mock(Territory.class);
        Territory to = mock(Territory.class);
        Player player = mock(Player.class);

        // 创建 Mock 对象，并模拟 next.checkAction 方法返回值
        AbstractChecker next = mock(AbstractChecker.class);
        when(next.checkAction(from, to, player)).thenReturn(true);

        // 创建被测对象
        AbstractChecker abstractChecker = new AbstractChecker(next) {
            @Override
            protected boolean checkMyRule(Territory from, Territory to, Player player) {
                return false;
            }
        };

        // 执行测试
        boolean result = abstractChecker.checkAction(from, to, player);

        // 验证结果
        assertTrue(result);
        // 验证是否调用了 next.checkAction 方法
        verify(next, times(1)).checkAction(from, to, player);
        verify(next, times(0)).checkMyRule(from, to, player);
    }
}

