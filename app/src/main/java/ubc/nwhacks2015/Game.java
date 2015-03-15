package ubc.nwhacks2015;

/*
 * This is the Game class, which is created on the hosts' app, and coordinates the game.
 * Tentative.
 */

import com.firebase.client.*;

import java.io.Serializable;

public class Game {
  private String name;
  public Game(String name) {
      this.name = name;

      Firebase myFirebaseRef = new Firebase("https://cahtest.firebaseio.com/");

      String gameName = "Game Name";

      String player1 = "Joey Li";
      String player2 = "Tim Branch";

      myFirebaseRef.child(gameName).child(player1).child("Cards").push();

      myFirebaseRef.child(gameName).child(player2).child("saturday").addValueEventListener(new ValueEventListener() {

          @Override
          public void onDataChange(DataSnapshot snapshot) {
              System.out.println(snapshot.getValue());  //prints "Do you have data? You'll love Firebase."
          }

          @Override public void onCancelled(FirebaseError error) { }

      });
  }
}
