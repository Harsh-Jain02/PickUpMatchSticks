package com.example.pickupmatchsticks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PlayActivity extends AppCompatActivity {
    private static final String TAG = "PlayActivity";
    public int matchsticks = 0;
    public int picks=0;
    public String msg1 = "You picked ";
    public String msg2 = "I picked ";
    public String msg = "\nRemaining: ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_layout);

        Log.d(TAG, "onCreate: Play page created");

        Intent intent = getIntent();
        matchsticks = intent.getIntExtra("MatchSticks",0);
        Log.d(TAG, "onCreate: "+matchsticks);

        TextView txt = findViewById(R.id.play_text);
        if(matchsticks%5>1){
            picks = (matchsticks%5)-1;
            matchsticks-=picks;
            txt.setText(msg2+picks+msg+matchsticks);
        }else if(matchsticks%5==0){
            picks = 4;
            matchsticks-=picks;
            txt.setText(msg2+picks+msg+matchsticks);
        }
        else{
            txt.setText("Your turn");
            try {
                Thread.sleep(750);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Button b1 = findViewById(R.id.button_one);
        Button b2 = findViewById(R.id.button_two);
        Button b3 = findViewById(R.id.button_three);
        Button b4 = findViewById(R.id.button_four);
        b1.setSoundEffectsEnabled(false);
        b2.setSoundEffectsEnabled(false);
        b3.setSoundEffectsEnabled(false);
        b4.setSoundEffectsEnabled(false);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(matchsticks==0){
                    txt.setText("Game Over!\nYou Lost");
                    return;
                }
                txt.setText(msg1+1+msg+(matchsticks-1));

                if(matchsticks==1){
                    txt.setText("You Lose");
                    matchsticks=0;
                    return;
                }
                txt.setText(msg1+1+msg+(matchsticks-1)+"\n"+msg2+4+msg+(matchsticks-5));
                matchsticks-=5;
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(matchsticks==0){
                    txt.setText("Game Over!\nYou Lost");
                    return;
                }
                if(matchsticks==1){
                    txt.setText("You can't pick 2, there is only 1 left");
                    return;
                }
                txt.setText(msg1+2+msg+(matchsticks-2)+"\n"+msg2+3+msg+(matchsticks-5));
                matchsticks-=5;


            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(matchsticks==0){
                    txt.setText("Game Over!\nYou Lost");
                    return;
                }
                if(matchsticks==1){
                    txt.setText("You can't pick 3, there is only 1 left");
                    return;
                }
                txt.setText(msg1+3+msg+(matchsticks-3)+"\n"+msg2+2+msg+(matchsticks-5));
                matchsticks-=5;
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(matchsticks==0){
                    txt.setText("Game Over!\nYou Lost");
                    return;
                }
                if(matchsticks==1){
                    txt.setText("You can't pick 4, there is only 1 left");
                    return;
                }
                txt.setText(msg1+4+msg+(matchsticks-4)+"\n"+msg2+1+msg+(matchsticks-5));
                matchsticks-=5;
            }
        });
    }
}
