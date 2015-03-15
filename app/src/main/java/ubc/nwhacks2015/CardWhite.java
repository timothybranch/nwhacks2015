package ubc.nwhacks2015;

/*
 * The answer card.
 */

public class CardWhite {
    private String text;
    private String owner;

    public CardWhite(String text, String owner){
        this.text = text;
        this.owner = owner;
    }
    public String getText(){
        return text;
    }
    public String getOwner(){
        return owner;
    }
}
