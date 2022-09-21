package com.example.pickupmatchsticks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Base Page Created");

        Button play = findViewById(R.id.play_button);
        Button help = findViewById(R.id.help_button);
        play.setSoundEffectsEnabled(false);
        help.setSoundEffectsEnabled(false);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: play pressed");
                Intent intent = new Intent(MainActivity.this, TossActivity.class);
                startActivity(intent);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: help pressed");
                Intent intent = new Intent(MainActivity.this,help_activity.class);
                startActivity(intent);
            }
        });
    }

}