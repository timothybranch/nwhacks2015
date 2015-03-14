package ubc.nwhacks2015;

import java.util.ArrayList;

/*
 * This file is for each player in the game.
 * Stores data such as hand, whether they are the czar or not, and score.
 */

public class Player {

    private int myID;
    private String myName;
    private boolean isCzar = false;
    private ArrayList<CardWhite> myHand;
    private ArrayList<CardWhite> mySelection;
    private CardWhite myChoice;
    private int myScore = 0;

    public Player(int id, String name, ArrayList<CardWhite> startingHand){
        this.myID = id;
        this.myName = name;
        this.myHand = startingHand;
    }

    public int getID(){
        return myID;
    }

    public String getName(){
        return myName;
    }

    public boolean getCzar(){
        return isCzar;
    }

    public ArrayList<CardWhite> getHand(){
        return myHand;
    }

    public ArrayList<CardWhite> getSelection(){
        return mySelection;
    }

    public int getScore(){
        return myScore;
    }

    public void addPoint(){
        ++myScore;
    }

    public void setName(String name){
        myName = name;
    }

    public void addCard(CardWhite add){
        myHand.add(add);
    }

    public void addSelection(CardWhite add){
        mySelection.add(add);
    }

    public void setCzar(boolean bool){
        isCzar = bool;
    }

    public CardWhite getChoice(){
        return myChoice;
    }



}
