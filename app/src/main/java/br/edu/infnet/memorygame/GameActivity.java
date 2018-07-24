package br.edu.infnet.memorygame;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    boolean[] faceUpTable;
    TableLayout gameArea;
    GridView gameGrid;
    int ncols = 4;
    int nrows = 4;
    int totalCards = 32;
    MediaPlayer bkplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamegrid);

        if (savedInstanceState != null){
            faceUpTable = savedInstanceState.getBooleanArray("faceUpState");
        } else{
            faceUpTable = new boolean[nrows*ncols];
        }

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        initializeCards();

        bkplayer = MediaPlayer.create(this, R.raw.water_world);
        bkplayer.setLooping(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        bkplayer.start();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bkplayer.pause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        /*Log.d("SAVE", "ONSAVEINSTACE");
        for (int i = 0; i < nrows; i++){
            TableRow row = (TableRow) gameArea.getChildAt(i);
            for (int j = 0; j < ncols; j++){
                faceUpTable[i*ncols + j] = ((GameCard)row.getChildAt(j)).isFaceUp();
            }
        }
        outState.putBooleanArray("faceUpState", faceUpTable);*/
        outState.putInt("musicPos", bkplayer.getCurrentPosition());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bkplayer.seekTo(savedInstanceState.getInt("musicPos"));
        Log.d("SAVE", "RESTORE INSTQCE");
        //faceUpTable = savedInstanceState.getBooleanArray("faceUpState");
    }

    /*private void initializeCards(){
        gameArea = findViewById(R.id.gameArea);
        for (int i = 0; i < gameArea.getChildCount(); i++){
            TableRow row = (TableRow) gameArea.getChildAt(i);
            for (int j = 0; j < row.getChildCount(); j++){
                GameCard card = (GameCard) row.getChildAt(j);
                if (faceUpTable[i*row.getChildCount() + j]){
                    card.flip();
                }
                card.setClickable(true);
                card.setOnClickListener(this);
            }
        }
    }*/

    private void initializeCards(){
        gameGrid = findViewById(R.id.gamegrid);
        List<Integer> cardsId = new ArrayList<>();
        for (int i = 0; i < totalCards; i++){
            cardsId.add(R.drawable.ic_lua);
        }
        CardAdapter adapter = new CardAdapter(this, cardsId);
        gameGrid.setAdapter(adapter);
        gameGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((GameCard) view).flip();
            }
        });
        //card.setClickable(true);
        //card.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        GameCard card = (GameCard) v;
        card.flip();
        //String teste = Integer.toString(iv.getPaddingTop());
        //Toast.makeText(this, teste, Toast.LENGTH_SHORT).show();
    }
}
