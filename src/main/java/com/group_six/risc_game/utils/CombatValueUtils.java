package com.group_six.risc_game.utils;
import java.util.Random;
public class CombatValueUtils {
    // return combat vlaue from 0 to 6
    static int getValue(){
        return new Random().nextInt(7);
    }
}
