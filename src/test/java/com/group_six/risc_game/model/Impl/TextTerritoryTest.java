package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.Player;
import com.group_six.risc_game.model.Soldier;
import com.group_six.risc_game.model.Territory;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TextTerritoryTest {

    @Test
    void testAddAttacker() {
        // Given
        Territory territory = new TextTerritory("territory");
        Player attacker = new TextPlayer("attacker");
        List<Soldier> soldiers = new ArrayList<>();

        // When
        territory.addAttacker(attacker, soldiers);

        // Then
    }

    @Test
    void testCombat_OneAndOne_AttackerWins() {
        // Given
        Territory territory = new TextTerritory("territory");
        Player defender = new TextPlayer("defender");
        Player attacker = new TextPlayer("attacker");
        List<Soldier> defenderSoldiers = new ArrayList<>();
        List<Soldier> attackerSoldiers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            defenderSoldiers.add(new TextSolider());
            attackerSoldiers.add(new TextSolider());
        }
        territory.addDenfder(defenderSoldiers);
        territory.addAttacker(attacker, attackerSoldiers);

        // When
        territory.combat();

        // Then
    }

    @Test
    void testCombat_OneAndOne_DefenderWins() {
        // Given
        Territory territory = new TextTerritory("territory");
        Player defender = new TextPlayer("defender");
        Player attacker = new TextPlayer("attacker");
        List<Soldier> defenderSoldiers = new ArrayList<>();
        List<Soldier> attackerSoldiers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            defenderSoldiers.add(new TextSolider());
            attackerSoldiers.add(new TextSolider());
        }
        territory.addDenfder(defenderSoldiers);
        territory.addAttacker(attacker, attackerSoldiers);

        // When
        territory.combat();

        // Then
    }

    @Test
    void testAddDefender() {
        // Given
        Territory territory = new TextTerritory("territory");
        List<Soldier> soldiers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            soldiers.add(new TextSolider());
        }

        // When
        territory.addDenfder(soldiers);

        // Then
    }

    @Test
    void testMoveDefender() {
        // Given
        Territory territory = new TextTerritory("territory");
        List<Soldier> soldiers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            soldiers.add(new TextSolider());
        }
        territory.addDenfder(soldiers);

        // When
        List<Soldier> movedSoldiers = territory.moveDenfder(3);

        // Then
    }
}
