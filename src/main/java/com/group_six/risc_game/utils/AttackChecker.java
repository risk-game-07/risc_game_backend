package com.group_six.risc_game.utils;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Territory;

import java.util.HashSet;
import java.util.List;

public class AttackChecker extends AbstractChecker{
    protected AttackChecker(AbstractChecker next) {
        super(next);
    }

    @Override
    protected boolean checkMyRule(Territory from, Territory to, Player player) {
        HashSet<Territory> territories = player.getTerritories();
        for (Territory t : territories) {
            List<Territory> neighbors = t.getNeighbors();
            for (Territory nei : neighbors) {
                if (to.equals(nei)) return true;
            }
        }
        return false;
    }
}
