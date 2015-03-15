package ubc.nwhacks2015;

/*
 * This is the Game class, which is created on the hosts' app, and coordinates the game.
 * Tentative.
 */

import java.util.ArrayList;

public class Game {
  private String name;
  private ArrayList<Player> players = new ArrayList<Player>();
  //deck??

  public Game(String name) {
    this.name = name;
  }

  public void addPlayer(Player p) {
    players.add(p);
  }

}
