package com.example.valindelsignore.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGame();

    }



    private void startMenu(){
        Intent playGame = new Intent(this,class);

    }
}


