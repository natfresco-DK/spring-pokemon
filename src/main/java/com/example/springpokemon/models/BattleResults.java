package com.example.springpokemon.models;

public class BattleResults {
    protected Pokemon battler1;
    protected Pokemon battler2;
    protected int stat1;
    protected int stat2;
    protected Pokemon winner;


    public BattleResults(){}

    public BattleResults(Pokemon battler1, Pokemon battler2) {
        this.battler1 = battler1;
        this.battler2 = battler2;
        this.stat1 = battler1.getCombinedStats();
        this.stat2 = battler2.getCombinedStats();
        if(stat1 > stat2){
            this.winner = battler1;
        } else if (stat1 < stat2) {
            this.winner = battler2;
        } else {
            this.winner = null;
        }
    }

    public Pokemon getBattler1() {
        return battler1;
    }

    public void setBattler1(Pokemon battler1) {
        this.battler1 = battler1;
    }

    public Pokemon getBattler2() {
        return battler2;
    }

    public void setBattler2(Pokemon battler2) {
        this.battler2 = battler2;
    }

    public int getStat1() {
        return stat1;
    }

    public void setStat1(int stat1) {
        this.stat1 = stat1;
    }

    public int getStat2() {
        return stat2;
    }

    public void setStat2(int stat2) {
        this.stat2 = stat2;
    }

    public Pokemon getWinner() {
        return winner;
    }

    public void setWinner(Pokemon winner) {
        this.winner = winner;
    }
}
