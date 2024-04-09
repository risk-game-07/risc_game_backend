package com.group_six.risc_game.model.Impl;

import cn.hutool.core.util.RandomUtil;
import com.group_six.risc_game.model.Soldier;

import static cn.hutool.core.util.RandomUtil.randomInt;

public class TextSolider implements Soldier {
    private int hp;
    public TextSolider(){
        hp = 1;
    }

    @Override
    public void attack(Soldier defendence) {
        if(getFightValue() > defendence.getFightValue())
            defendence.decreaseOneHp();
        else
            decreaseOneHp();
    }

    @Override
    public int getFightValue(){
       return RandomUtil.randomInt(0, 7);
    }

    @Override
    public void decreaseOneHp() {
        hp--;
    }

    @Override
    public boolean isDie() {
        return hp == 0;
    }
}
