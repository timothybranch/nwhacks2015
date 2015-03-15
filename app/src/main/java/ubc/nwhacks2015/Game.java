package ubc.nwhacks2015;

/*
 * This is the Game class, which is created on the hosts' app, and coordinates the game.
 * Tentative.
 */

import com.firebase.client.*;
import java.util.ArrayList;

import java.io.Serializable;

public class Game implements Serializable{
    private String name;
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game(String gameName, Player host) {
        this.name = gameName;

        players.add(host);

        Firebase ref = new Firebase("https://cahtest.firebaseio.com/");

        ref.child(name).child("Players").child(players.size()-1+"").setValue(host.getName());
//        for (int i = 0; i < players.get(0).getHand().size(); ++i){
//            ref.child(name).child(players.get(0).getName()).child("Cards").child(""+i).setValue(host.getHand().get(i).getText());
//        }

    }

    public void addPlayer(Player newPlayer){
        players.add(newPlayer);

        Firebase ref = new Firebase("https://cahtest.firebaseio.com/");

        ref.child(name).child("Players").child(players.size()-1+"").setValue(newPlayer.getName());
    }

}
