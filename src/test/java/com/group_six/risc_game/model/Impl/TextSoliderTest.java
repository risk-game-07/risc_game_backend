package com.group_six.risc_game.model.Impl;

import com.group_six.risc_game.model.Soldier;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TextSoliderTest {

    @Test
    void testAttack_Win() {
        // Given
        Soldier attacker = new TextSolider();
        Soldier defender = new TextSolider() {
            @Override
            public int getFightValue() {
                return 1; // Defender always loses
            }
        };

        // When
        attacker.attack(defender);

        // Then
    }

    @Test
    void testAttack_Lose() {
        // Given
        Soldier attacker = new TextSolider() {
            @Override
            public int getFightValue() {
                return 1; // Attacker always loses
            }
        };
        Soldier defender = new TextSolider();

        // When
        attacker.attack(defender);

    }

    @Test
    void testAttack_Draw() {
        // Given
        Soldier attacker = new TextSolider() {
            @Override
            public int getFightValue() {
                return 0; // Always draw
            }
        };
        Soldier defender = new TextSolider();

        // When
        attacker.attack(defender);

    }

    @Test
    void testIsDie() {
        // Given
        Soldier soldier = new TextSolider();

        // When
        boolean initialIsDie = soldier.isDie();
        soldier.decreaseOneHp();
        boolean afterDecreaseIsDie = soldier.isDie();

        // Then
        assertFalse(initialIsDie);
        assertTrue(afterDecreaseIsDie);
    }
}
