package com.example.pickupmatchsticks;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class help_activity extends AppCompatActivity {
    private static final String TAG = "help_activity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_layout);
        Log.d(TAG, "onCreate: Help page opened");

        TextView help = findViewById(R.id.help_text);
        String message = "Hi,\nYou will be given a random number of matchsticks in the starting of " +
                "the game. There will be a toss to decide if you can play first. When you turn comes" +
                " you can pick either 1, 2, 3 or 4 matchsticks. Player who picks the last matchstick" +
                " loses.";
        help.setText(message);
    }
}
