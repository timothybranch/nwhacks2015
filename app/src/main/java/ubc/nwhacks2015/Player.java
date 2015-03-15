    package ubc.nwhacks2015;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
 * This file is for each player in the game.
 * Stores data such as hand, whether they are the czar or not, and score.
 */

public class Player { // needed to pass objects from one activity to another

    Random R = new Random();

    private String name;
    private int points;
    private ArrayList<CardWhite> hand = new ArrayList<CardWhite>();
    private boolean isCzar;
    private ArrayList<CardWhite> deck = new ArrayList<CardWhite>();

    public Player() throws FileNotFoundException {
        points = 0;
        loadDeck();
        createHand(7);
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
    public void destroyCard(int index){
        hand.remove(index);
    }
    public void addCard(){

    }
    public boolean getCzar(){
        return isCzar;
    }
    public ArrayList<CardWhite> getHand(){
        return hand;
    }
    public ArrayList<CardWhite> getDeck(){
        return deck;
    }
    public void addCard(CardWhite card){
        hand.add(card);
    }
    public void setCzar(boolean b){
        isCzar = b;
    }

    public void createHand(int size){
        for (int i = 0; i < size; i++)
            hand.add(deck.get(R.nextInt(deck.size())));
    }

    public void loadDeck()throws FileNotFoundException {
        Scanner sc = new Scanner(new File("white.txt"));

        while (sc.hasNextLine()){
            String text = sc.nextLine();
            if((text.indexOf("<")!=-1)||(text.indexOf("&")!=-1)){
                continue;
            }
            int i = text.indexOf(",");
            text = text.substring(i+3);
            i = text.indexOf("\", ");
            String data = text.substring(0,i);
            text = text.substring(i+4);
            i = text.indexOf("\"");
            String set = text.substring(0,i);

            deck.add(new CardWhite(data,name));
        }
    }
}
