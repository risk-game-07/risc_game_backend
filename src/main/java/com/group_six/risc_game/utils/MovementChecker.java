package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.HashSet;
import java.util.Set;

public class MovementChecker extends AbstractChecker{

    public MovementChecker(AbstractChecker next) {
        super(next);
    }

    @Override
    protected boolean checkMyRule(Territory from, Territory to, Player player) {
        Set<Territory> visited = new HashSet<>();
        return dfs(from, to, player, visited);
    }

    private boolean dfs (Territory current, Territory to, Player player, Set<Territory> visited) {
        if (!current.getOwner().equals(player.getPlayerId()) || visited.contains(current)) return false;

        visited.add(current);
        if (current.equals(to)) return true;

        for (Territory t : current.getNeighbor()) {
            if (dfs(t, to, player, visited)) return true;
        }
        return false;
    }
}
