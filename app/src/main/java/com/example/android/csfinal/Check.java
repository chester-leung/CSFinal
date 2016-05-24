package com.example.android.csfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Check extends AppCompatActivity {
    boolean correct;
    int numTried;
    int numCorrect;
    int multiplier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        //get arguments passed from previous activity
        correct = getIntent().getExtras().getBoolean("correct");
        numTried = getIntent().getExtras().getInt("numTried");
        numCorrect = getIntent().getExtras().getInt("numCorrect");
        multiplier = getIntent().getExtras().getInt("multiplier");
        checkMyAnswer();
        setString();
    }

    /*
    tells the user if he is correct or incorrect
     */
    public void checkMyAnswer() {
        //MainActivity main = new MainActivity();
        TextView check = (TextView) findViewById((R.id.correction));
        if (correct == true) {
            check.setText("Correct!");
        } else
            check.setText("Wrong");
    }

    /*
    tells the user how many he has gotten correct and how many he has attempted
     */
    public void setString()
    {
        //MainActivity main = new MainActivity();
        String str = "You have gotten " + numCorrect + " out of " + numTried +
                " correct.";
        TextView counter = (TextView) findViewById(R.id.counter);
        counter.setText(str);
    }

    /*
    pressing back button will send app back to number screen
     */
    public void sendBack(View v)
    {
        Intent intent = new Intent(this, test.class);
        intent.putExtra("numTried", numTried);
        intent.putExtra("numCorrect", numCorrect);
        intent.putExtra("userInput", multiplier);
        startActivity(intent);
    }
}

