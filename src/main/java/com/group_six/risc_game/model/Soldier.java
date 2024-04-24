package com.group_six.risc_game.model;

public interface Soldier {
    public void attack(Soldier defendence);
    public void decreaseOneHp();
    public boolean isDie();
    public int getFightValue();
    public void addLevel();
    public int getLevel();
    public void setLevel(int level);
}
