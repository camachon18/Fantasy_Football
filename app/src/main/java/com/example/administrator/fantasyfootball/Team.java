package com.example.administrator.fantasyfootball;

import java.io.Serializable;

/**
 * Nathan Camacho
 * 9/27/15
 * Class for Team objects. Each team object has a name, wins, draws, and losses attributes.
 *
 */
public class Team implements Serializable {

    private String name;
    private String wins;
    private String draws;
    private String losses;

    public Team(String newName,String newWins,String newDraws,String newLosses){

        this.name = newName;
        this.wins = newWins;
        this.draws = newDraws;
        this.losses = newLosses;

    }//ctor

    //Setters and getters for all variables of this class
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getDraws() {
        return draws;
    }

    public void setDraws(String draws) {
        this.draws = draws;
    }

    public String getLosses() {
        return losses;
    }

    public void setLosses(String losses) {
        this.losses = losses;
    }
}
