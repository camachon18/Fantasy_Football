package com.example.administrator.fantasyfootball;

import java.io.Serializable;

/**
 * Created by nathancamacho on 9/28/15.
 */
public class Player implements Serializable {

    private String name;
    private String position;
    private int number;
    private int goals;
    private int assists;
    private int saves;
    private int yellowCards;
    private int redCards;
    private int fouls;

    public Player(String newName, String newPosition, int newNumber, int newGoals, int newAssists, int newSaves,int newYellowCards,int newRedCards,int newFouls){

        this.name = newName;
        this.position = newPosition;
        this.number = newNumber;
        this.goals = newGoals;
        this.assists = newAssists;
        this.saves = newSaves;
        this.yellowCards = newYellowCards;
        this.redCards = newRedCards;
        this.fouls = newFouls;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getFouls() {
        return fouls;
    }

    public void setFouls(int fouls) {
        this.fouls = fouls;
    }
}
