package ubc.nwhacks2015;

/*
 * This class is for cards that the player play.
 */

public class CardWhite {

    private int myID;
    private String myVal;
    private String mySet;

    //Constructed in the Game class
    public CardWhite(int id, String val, String set){
        this.myID = id;
        this.myVal = val;
        this.mySet = set;
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
}
