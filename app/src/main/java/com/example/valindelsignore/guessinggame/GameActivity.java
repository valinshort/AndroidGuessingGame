package com.example.valindelsignore.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    private TextView clueTextView;
    private Button guessButton;
    private EditText guess;
    private int generatedNumber;
    private int numberOfGuesses = 0;
    private final int MAX_GUESS_COUNT = 4;


    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) Math.ceil(Math.random() * 100);
        numberOfGuesses = 0;
        clueTextView.setVisibility(View.INVISIBLE);
        guess.setText("");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextView = findViewById(R.id.aski_number);
        guessButton = findViewById(R.id.button2);
        guess = findViewById(R.id.editText);
        setListener();
    }


    private void setListener() {

//        guessButton.setOnClickListener(new View.OnClickListener())
//        @Override
//        public void onClick(View v){
        guessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int userGuess = Integer.parseInt(guess.getText().toString());
                if (userGuess > 100) {
                    clueTextView.setText(R.string.invalid_number_error_message);
                    clueTextView.setVisibility(View.VISIBLE);
                    guess.setText("");
                } else {
                    checkGuess(userGuess);
                }

                // }
                // guessButton.setOnClickListener(new View.OnClickListener() {
                // @Override
                //public void onClick(View v) {

            }
        });



        }

    private void checkGuess(int userGuess) {
        if (userGuess == generatedNumber) {
            //TODO - Create intent to go to winning activity - handle winning
            Intent winner = new Intent(this, ResultActivity.class);
            startActivity(winner);
        } else if (numberOfGuesses == MAX_GUESS_COUNT) {
            //TODO - create intent to go to winning activity - handle out of chances
            Intent loser = new Intent(this, ResultActivity.class);
            loser.putExtra("Winning_Number", generatedNumber);
            startActivity(loser);
        } else if (userGuess < generatedNumber) {
            clueTextView.setText(R.string.higher);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        } else if (userGuess > generatedNumber) {
            clueTextView.setText(R.string.lower);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
            numberOfGuesses++;
        }


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

//private void startGame({
    //Intent playGame = new Intent()
}



