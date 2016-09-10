package com.simonwebtech.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNum;

    public void checkGuess(View view) {

        String message = "";

        //See if the input is empty
        boolean isEmpty = false;

        //See if the it is a number entered, not a blank space
        try {
            EditText guessedNumber = (EditText) findViewById(R.id.guessedNumber);
            String guessedNumberString = guessedNumber.getText().toString();;
            int guessedNumberInt = Integer.parseInt(guessedNumberString);


            if (guessedNumberInt > randomNum) {
                message = "Too high!";
            } else if (guessedNumberInt < randomNum) {
                message = "Too low!";
            } else {
                message = "Correct! It was " + randomNum + "!";
            }
        }

        catch (NumberFormatException e) {

            Toast.makeText(getApplicationContext(), "Please enter a number!", Toast.LENGTH_LONG).show();
            isEmpty = true;

        }

        //If number was not correct, keep going. If yes, generate new number
        if (message.equals("Correct! It was " + randomNum + "!")){

            Toast.makeText(getApplicationContext(), message + " Another random number was created.", Toast.LENGTH_LONG).show();
            Random randomGenerator = new Random();
            randomNum = randomGenerator.nextInt(21);
        }
        else {

            if(isEmpty == false) {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
            //If number was empty, the exception message would print but also
            //the "message" string would also print with a blank message
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random randomGenerator = new Random();
        randomNum = randomGenerator.nextInt(21);

    }
}
