package com.example.ttv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashScreenActivity extends AppCompatActivity {
    Button equationSolver, storyTelling, illustration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        equationSolver = findViewById(R.id.equationSolver);
        storyTelling = findViewById(R.id.storyTelling);
        illustration = findViewById(R.id.illustration);

        equationSolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSolve = new Intent(SplashScreenActivity.this, setURL.class);
                startActivity(intentSolve);
            }
        });

        storyTelling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVideo = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intentVideo);
            }
        });

        illustration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentVideo = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intentVideo);
            }
        });
    }
}