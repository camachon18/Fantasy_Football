package com.example.administrator.fantasyfootball;

import java.io.Serializable;

/**
 * Created by nathancamacho on 9/28/15.
 */
public class Team implements Serializable {

    private String name;
    private int wins;
    private int draws;
    private int losses;

    public Team(String newName,int newWins,int newDraws,int newLosses){

        this.name = newName;
        this.wins = newWins;
        this.draws = newDraws;
        this.losses = newLosses;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
