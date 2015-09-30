package com.example.administrator.fantasyfootball;

import android.widget.ImageView;

import java.io.Serializable;

/**
 *Nathan Camacho
 * 9/26/15
 * Player class.
 * Each player object has stats, a name, and more.
 *
 */
public class Player implements Serializable {

    private String name;
    private String position;
    private String number;
    private String goals;
    private String assists;
    private String saves;
    private String yellowCards;
    private String redCards;
    private String fouls;
    private ImageView picture;//not implemented

    public Player(String newName, String newPosition, String newNumber, String newGoals, String newAssists, String newSaves,String newYellowCards,String newRedCards,String newFouls){

        this.name = newName;
        this.position = newPosition;
        this.number = newNumber;
        this.goals = newGoals;
        this.assists = newAssists;
        this.saves = newSaves;
        this.yellowCards = newYellowCards;
        this.redCards = newRedCards;
        this.fouls = newFouls;

    }//ctor


    //Setters and getters for variables
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getAssists() {
        return assists;
    }

    public void setAssists(String assists) {
        this.assists = assists;
    }

    public String getSaves() {
        return saves;
    }

    public void setSaves(String saves) {
        this.saves = saves;
    }

    public String getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(String yellowCards) {
        this.yellowCards = yellowCards;
    }

    public String getRedCards() {
        return redCards;
    }

    public void setRedCards(String redCards) {
        this.redCards = redCards;
    }

    public String getFouls() {
        return fouls;
    }

    public void setFouls(String fouls) {
        this.fouls = fouls;
    }
}
