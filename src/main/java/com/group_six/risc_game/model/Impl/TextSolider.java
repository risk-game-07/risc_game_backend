package com.group_six.risc_game.model.Impl;

import cn.hutool.core.util.RandomUtil;
import com.group_six.risc_game.model.Soldier;
import lombok.Getter;
import lombok.Setter;

import static cn.hutool.core.util.RandomUtil.randomInt;

public class TextSolider implements Soldier {
    private int hp;


    private int level;

    public void setLevel(int level){
        this.level = level;
    }
    public TextSolider(){
        hp = 1;
        level = 1;
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
       return RandomUtil.randomInt(0, 7) + level;
    }

    @Override
    public void decreaseOneHp() {
        hp--;
    }

    @Override
    public boolean isDie() {
        return hp == 0;
    }
    @Override
    public void addLevel(){
        level++;
    }
    @Override
    public int getLevel(){
        return level;
    }
}
