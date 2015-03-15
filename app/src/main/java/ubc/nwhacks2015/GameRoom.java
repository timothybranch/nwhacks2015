package ubc.nwhacks2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;


public class GameRoom extends ActionBarActivity {
    private ArrayList<CardBlack> blackDeck = new ArrayList<CardBlack>();
    private Game myGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();
        myGame = (Game)i.getSerializableExtra("Game");
        Player me = (Player) i.getSerializableExtra("Player");
        if(me.getCzar()) {
            Intent czar = new Intent(this, CardCzar.class);
            startActivityForResult(czar, 0);
        }
        setContentView(R.layout.activity_game_room);



        TextView blackCard = (TextView) findViewById(R.id.blackCard);
        blackCard.setText(blackDeck.get(0).getText());
        final ListView listDeck = (ListView) findViewById(R.id.listDeck);
        ArrayList<String> cards = new ArrayList<String>();
        for(CardWhite c : me.getDeck()) {
            cards.add(c.getText());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, cards);
        listDeck.setAdapter(adapter);
        TextView textPoints = (TextView) findViewById(R.id.textPoints);
        textPoints.setText(me.getPoints());

        //String selectedCard;

        listDeck.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String selectedCard  = (String) listDeck.getItemAtPosition(position);
            }
        });
        // Send this string to the card czar lol have fun
    }


    public void makeBlackDeck()throws FileNotFoundException {
        Scanner sc = new Scanner(new File("black.txt"));

        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            if ((text.indexOf("<") != -1) || (text.indexOf("&") != -1)) {
                continue;
            }
            int i = text.indexOf(",");
            text = text.substring(i + 3);
            i = text.indexOf("\",");
            if (i < 0) {
                continue;
            }
            String data = text.substring(0, i);
            text = text.substring(i + 3);
            i = text.indexOf(",");
            int draw = Integer.parseInt(text.substring(0, i));
            text = text.substring(i + 2);
            i = text.indexOf(",");
            int play = Integer.parseInt(text.substring(0, i));
            text = text.substring(i + 4);
            i = text.indexOf("\"");
            String set = text.substring(0, i);

            blackDeck.add(new CardBlack(data));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_room, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void game(){
        //while no one has 10 points yet (look through array list.... FireBase data?
        //get black card from deck (import java.Random)
        //wait for everyone to submit a card to network, display card on Czar's screen
        // Czar chooses a card, the "owner" of that card is sent to FireBase, owner receives point
    }
}
