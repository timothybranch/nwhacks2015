package ubc.nwhacks2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.ChildEventListener;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// gets all nearby games and joins one
public class SelectGame extends ActionBarActivity {
    Firebase fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);
        Button buttonJoin = (Button) findViewById(R.id.buttonJoin);
        buttonJoin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent joinGame = new Intent(view.getContext(), PlayerWaitingRoom.class);
                EditText name = (EditText) findViewById(R.id.name);
                String playerName = name.getText().toString();
                joinGame.putExtra("String", playerName);
                startActivityForResult(joinGame, 0);
            }
        });
        Firebase.setAndroidContext(this);
        fb = new Firebase("https://cardsagainsthumanity.firebaseio.com/");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_select_game, menu);
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

    public void joinGame(){
        final Firebase ref = new Firebase("https://cahtest.firebaseio.com/");

        EditText text = (EditText) findViewById(R.id.name);
        final String name = text.getText().toString();
        Player player = new Player(name);
        Map<String, Player> newPlayer = new HashMap<String, Player>();
        newPlayer.put(player.getName(), player);
        fb.setValue(newPlayer);
        EditText text2 = (EditText) findViewById(R.id.game);
        final String gameName = text2.getText().toString();

        Query queryRef = ref.equalTo(gameName);

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                System.out.println(snapshot.getKey());

                //Same thing as hosting a game, where we add a player to the list of Players\

                ref.child(gameName).child("Players").child(players.size()-1+"").setValue(host.getName());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}