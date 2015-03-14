package ubc.nwhacks2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPlayer extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);
        Button create = (Button) findViewById(R.id.buttonCreatePlayer);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // Player initialized here
                EditText nameOfPlayer = (EditText) findViewById(R.id.nameOfPlayer);
                String name = nameOfPlayer.getText().toString();
                Intent newPlayer = new Intent(view.getContext(), SelectGame.class);
                newPlayer.putExtra("String", name);
                startActivityForResult(newPlayer, 0);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_player, menu);
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
