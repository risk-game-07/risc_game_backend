package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttackChecker extends AbstractChecker{
    // change it to public
    public AttackChecker(AbstractChecker next) {
        super(next);
    }

    @Override
    protected boolean checkMyRule(Territory from, Territory to, Player player) {
        List<Territory> territories = player.getTerritories();
        for (Territory t : territories) {
            List<Territory> neighbors = t.getNeighbors();
            for (Territory nei : neighbors) {
                if (to.equals(nei)) return true;
            }
        }
        return false;
    }

//    private boolean dfs(Territory current, Territory to, Player player, Set<Territory> visited) {
//        if (visited.contains(current)) return  false;
//        visited.add(current);
//        if (current.equals(to)) return true;
//        if (!current.getOwner().equals(player.getPlayerId())) return false;
//
//        for (Territory t : current.getNeighbors()) {
//            if (dfs(t, to, player, visited)) return true;
//        }
//
//        return false;
//    }
}
