    package ubc.nwhacks2015;


import java.util.ArrayList;

/*
 * This file is for each player in the game.
 * Stores data such as hand, whether they are the czar or not, and score.
 */

public class Player { // needed to pass objects from one activity to another

    private String name;
    private int points;
    private ArrayList<CardWhite> hand;  //set 0
    private boolean isCzar;
    private ArrayList<CardWhite> deck;  //set 1

    public Player(){
        points = 0;
    }
    public Player(String name){
        super();
        this.name = name;
    }

    public int getPoints(){
        return points;
    }
    public void setPoints(int points){
        this.points = points;
    }
    public String getName(){
        return name;
    }
    public void destroyCard(int index, int set){
        if (set==0)
            hand.remove(index);
        else if (set==1)
            deck.remove(index);
    }
    public boolean getCzar(){
        return isCzar;
    }
    public ArrayList<CardWhite> getHand(){
        return Hand;
    }
    public ArrayList<CardWhite> getDeck(){
        return deck;
    }
    public void addCard(CardWhite card){
        myHand.add(card);
    }
    public void setCzar(boolean b){
        isCzar = b;
    }
}
