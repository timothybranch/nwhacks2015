package ubc.nwhacks2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;

import java.util.Map;

// needs to display list of players
public class WaitingRoom extends ActionBarActivity {

    private Game thisGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting_room);
        Button buttonStart = (Button) findViewById(R.id.buttonStart);

        Intent i = getIntent();
        final Game myGame = (Game)i.getSerializableExtra("Game");

        Firebase ref = new Firebase("https://cahtest.firebaseio.com/");

        ref.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to Firebase
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {

            }
        });

        buttonStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent startGame = new Intent(view.getContext(), GameRoom.class);
                startGame.putExtra("Game", myGame);
                startActivityForResult(startGame, 0);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_waiting_room, menu);
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
}
