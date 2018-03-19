package com.example.valindelsignore.guessinggame;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.VISIBLE;

public class ResultActivity extends AppCompatActivity {


    private Button playAgain;
    private TextView correctNumber;
    private TextView resultsTextview;
    private ImageView resultImageview;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        playAgain = findViewById(R.id.restart_button);
        correctNumber = findViewById(R.id.winning_Number);
        resultsTextview = findViewById(R.id.results_Textview);
        resultImageview = findViewById(R.id.results_imageView);


        setListener();


        intent = getIntent();
        if (intent.hasExtra("Winning_Number")) {
            setLosingData();
        }


    }

    private void setLosingData() {
        int winningNumber = intent.getIntExtra("Winning_Number", 0);
        resultsTextview.setText(R.string.you_lost);
        correctNumber.setText(getString(R.string.winning_number, winningNumber));
        correctNumber.setVisibility(VISIBLE);
        resultImageview.setImageDrawable(getDrawable(R.drawable.losingsadface));

    }

    private void setListener() {
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
