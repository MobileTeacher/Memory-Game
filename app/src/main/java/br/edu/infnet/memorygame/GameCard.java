package br.edu.infnet.memorygame;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;

public class GameCard extends CardView {

    private ImageView memoryImage;
    private boolean faceUp = false;
    private int frontImage;
    private int backImage;

    public GameCard(@NonNull Context context) {
        super(context);
        init();
    }

    public GameCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(), R.layout.game_card_layout, this);
        memoryImage = findViewById(R.id.game_image);
        frontImage = R.drawable.ic_lua;
        backImage = R.drawable.ic_android;
        syncFace();
        //memoryImage.setImageResource(R.drawable.ic_android);
    }

    private void syncFace(){
        if (faceUp){
            memoryImage.setImageResource(frontImage);
        }
        else{
            memoryImage.setImageResource(backImage);
        }
        invalidate();
        requestLayout();
    }
    public boolean flip(){
        faceUp = !faceUp;
        syncFace();
        return faceUp;
    }
}
