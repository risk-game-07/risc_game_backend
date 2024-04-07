package com.group_six.risc_game.model;

public interface Soldier {
    public void attack(Soldier defendence);
    public void decreaseOneHp();
    public boolean isDie();
}
