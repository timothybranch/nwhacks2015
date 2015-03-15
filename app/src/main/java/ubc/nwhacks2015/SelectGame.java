package ubc.nwhacks2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

import java.util.HashMap;
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
        EditText text = (EditText) findViewById(R.id.name);
        String name = text.getText().toString();
        Player player = new Player(name);
        Map<String, Player> newplayer = new HashMap<String, Player>();
        newplayer.put(player.getName(),player);
        fb.setValue(newplayer);
    }
}
