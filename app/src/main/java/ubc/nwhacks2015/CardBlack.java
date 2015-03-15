package ubc.nwhacks2015;

/*
 * The question card.
 */

public class CardBlack {
    private String text;
    private int blanks;

    public CardBlack(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
    public int getBlanks(){
        return blanks;
    }
}
