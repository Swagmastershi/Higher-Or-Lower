package com.simonwebtech.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNum;

    public void checkGuess(View view) {

        EditText guessedNumber = (EditText) findViewById(R.id.guessedNumber);

        String guessedNumberString = guessedNumber.getText().toString();
        int guessedNumberInt = Integer.parseInt(guessedNumberString);

        String message = "";
        if(guessedNumberInt > randomNum) {
            message = "Too high!";
        }
        else if (guessedNumberInt < randomNum) {
            message = "Too low!";
        }
        else {
            message = "Correct! It was " + randomNum + "!";
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNum = randomGenerator.nextInt(21);

    }
}
