package br.edu.infnet.memorygame;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        initializeCards();
    }


    private void initializeCards(){
        TableLayout gameArea = findViewById(R.id.gameArea);
        for (int i = 0; i < gameArea.getChildCount(); i++){
            TableRow row = (TableRow) gameArea.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++){
                View card = row.getChildAt(j);
                card.setClickable(true);
                card.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onClick(View v) {
        GameCard card = (GameCard) v;
        card.flip();
        //String teste = Integer.toString(iv.getPaddingTop());
        //Toast.makeText(this, teste, Toast.LENGTH_SHORT).show();
    }
}
