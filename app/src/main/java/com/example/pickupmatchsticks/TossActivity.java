package com.example.pickupmatchsticks;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TossActivity extends AppCompatActivity {
    private static final String TAG = "TossActivity";
    public boolean clicked = false;
    public int matchsticks = 0;
    public String message = "Total matchsticks: ";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toss_layout);
        Log.d(TAG, "onCreate: toss page created");

        TextView txt = findViewById(R.id.toss_text);
        Button btn =  findViewById(R.id.toss_button);
        btn.setSoundEffectsEnabled(false);
        int mn = 12;
        int mx = 60;
        matchsticks = (int)(Math.random()*(mx-mn+1)+mn);
        message+=matchsticks;
        txt.setText(message);

        
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(!clicked){
                    Log.d(TAG, "onClick: clicked first time");
                    btn.setText("Start");
                    if(matchsticks%5==1){
                        message+="\nYou Won\nYou play first";
                    }else{
                        message+="\nI Won\nI play first";
                    }
                    txt.setText(message);
                    clicked=true;
                }else{
                    Log.d(TAG, "onClick: clicked second time");
                    Intent intent = new Intent(TossActivity.this,PlayActivity.class);
                    intent.putExtra("MatchSticks",matchsticks);
                    startActivity(intent);
                }
            }
        });
    }
}
