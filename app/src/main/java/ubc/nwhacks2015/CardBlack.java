package ubc.nwhacks2015;

/*
 * This class is for cards that the player plan on, i.e. the "question" card.
 */

public class CardBlack {

    private int myID;
    private String myVal;
    private String mySet;
    private int myNum;

    //Constructed in the Game class
    public CardBlack(int id, String val, String set, int num){
        this.myID = id;
        this.myVal = val;
        this.mySet = set;
        this.myNum = num;
    }

    public int getId(){
        return myID;
    }

    public String getVal(){
        return myVal;
    }

    public String getSet(){
        return mySet;
    }

    public int getNum(){
        return myNum;
    }
}
