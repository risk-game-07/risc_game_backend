package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.Map;

public abstract class AbstractChecker {
    private final AbstractChecker next;

    protected AbstractChecker(AbstractChecker next) {
        this.next = next;
    }

    protected abstract boolean checkMyRule (Territory from, Territory to, Player player);

    public boolean checkAction (Territory from, Territory to, Player player) {
        if (next != null) {
            return next.checkAction(from, to, player);
        }

        return checkMyRule(from, to, player);
    }
}