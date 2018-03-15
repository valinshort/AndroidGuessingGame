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
    private int numberOfguesses = 0;
    private final int Max_GUESS_COUNT = 4;


    @Override
    protected void onStart() {
        super.onStart();
        generatedNumber = (int) Math.ceil(Math.random() * 100);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        clueTextView = findViewById(R.id.clue_textview);
        guessButton = findViewById(R.id.submit_guess_button);

        setListener();
    }









    private void setListener() {

        guessButton.setOnClickListener(new View.OnClickListener())
        @Override
        public void onClick(View v){
            int userGuess = Integer.parseInt(guess.getText().toString();
           if (userGuess > 100){
               clueTextView.setText(R.string.invalid_number_error_message);
               clueTextView.setVisibility(View.VISIBLE);
               guess.setText("");
        } else{
               checkGuess(userGuess);
           }

        }
    }


    private void checkGuess(int userGuess) {
        if (userGuess == generatedNumber) {
           // System.out.println("That was the correct number do you want to play again?");
            // TODO - create Intent to go to winning activity- handle winning

        } else if (numberOfguesses == 3 && userGuess < generatedNumber) {
            //System.out.println("Your number is too low and It's your last guess, good luck!");
            // TODO - create Intent to go to winning activity- handle out of chances
        } else if (numberOfguesses == 3 && userGuess > generatedNumber) {
            //System.out.println("Your number is too high and It's your last guess good luck!");
            clueTextView.setText(R.string.higher);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
        } else if (numberOfguesses == 4) {
            //System.out.println("your out of guesses the answer was " + generatedNumber + " would you like to try again? yes//no ?" +
                   // "");
            clueTextView.setText(R.string.higher);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
        } else if (userGuess > generatedNumber && numberOfguesses != 3 && numberOfguesses != 4) {
            clueTextView.setText(R.string.lower);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");
        } else if (userGuess < generatedNumber && numberOfguesses != 3 && numberOfguesses != 4) {
            System.out.println("your number is too low,try again ! ");
            clueTextView.setText(R.string.lower);
            clueTextView.setVisibility(View.VISIBLE);
            guess.setText("");

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

//private void startGame({
    //Intent playGame = new Intent()
}



