package com.example.android.csfinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class test extends AppCompatActivity {

    int setNum1;
    int setNum2;
    int sum = 0;
    int difference = 0;
    int product = 0;
    int quotient = 0;
    int numTried;
    int numCorrect;
    boolean correct = false;
    boolean one = false;
    int multiplier;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        if (getIntent().getExtras() != null) {
            numTried = getIntent().getExtras().getInt("numTried");
            numCorrect = getIntent().getExtras().getInt("numCorrect");
            multiplier = getIntent().getExtras().getInt("userInput");
        }

        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        setNum1 = (int) (Math.random() * multiplier);
        setNum2 = (int) (Math.random() * multiplier);
        num1.setText(Integer.toString(setNum1));
        num2.setText(Integer.toString(setNum2));


    }

    public void setNums(View v) {
        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);

        setNum1 = (int) (Math.random() * multiplier);
        setNum2 = (int) (Math.random() * multiplier);
        num1.setText(Integer.toString(setNum1));
        num2.setText(Integer.toString(setNum2));

    }


    /*
    find the sum of the random integers
     */
    public void sum(View v) {


        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);
        String temp1 = num1.getText().toString();
        String temp2 = num2.getText().toString();
        int a = Integer.parseInt(temp1);
        int b = Integer.parseInt(temp2);
        sum = a + b;

    }

    /*
    finds the difference of the random integers
     */
    public void difference(View v) {


        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);
        String temp1 = num1.getText().toString();
        String temp2 = num2.getText().toString();
        int a = Integer.parseInt(temp1);
        int b = Integer.parseInt(temp2);
        difference = a - b;


    }

    /*
   finds the product of the random integers
    */
    public void product(View v) {

        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);
        String temp1 = num1.getText().toString();
        String temp2 = num2.getText().toString();
        int a = Integer.parseInt(temp1);
        int b = Integer.parseInt(temp2);
        product = a * b;


    }

    /*
    finds the quotient of the random integers
     */
    public void quotient(View v) {

        TextView num1 = (TextView) findViewById(R.id.num1);
        TextView num2 = (TextView) findViewById(R.id.num2);
        String temp1 = num1.getText().toString();
        String temp2 = num2.getText().toString();
        int a = Integer.parseInt(temp1);
        int b = Integer.parseInt(temp2);
        if (b != 0) {
            quotient = a / b;
        } else
            Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();


    }


    /*
    tells the user if his answer is correct
     */
    CheckBox added;
    CheckBox subtracted;
    CheckBox multiplied;
    CheckBox divided;
    String answer1;


    public void answer() {
        added = (CheckBox) findViewById((R.id.button1));
        subtracted = (CheckBox) findViewById((R.id.button2));
        multiplied = (CheckBox) findViewById((R.id.button3));
        divided = (CheckBox) findViewById((R.id.button4));
        TextView check = (TextView) findViewById((R.id.check));

        EditText answer = (EditText) findViewById((R.id.user_input));
        answer1 = answer.getText().toString();

        if (!answer1.equals("")) { //if there is an user-inputted answer
            int answer2 = Integer.parseInt(answer1);

            if (added.isChecked() && !subtracted.isChecked() && !multiplied.isChecked()
                    && !divided.isChecked()) { //only sum is checked
                if (sum == answer2) {
                    correct = true;
                    numCorrect++;

                } else
                    correct = false;


            } else if (!added.isChecked() && subtracted.isChecked() && !multiplied.isChecked()
                    && !divided.isChecked()) { //only difference is checked
                if (difference == answer2) {
                    correct = true;
                    numCorrect++;

                } else
                    correct = false;

            } else if (!added.isChecked() && !subtracted.isChecked() && multiplied.isChecked()
                    && !divided.isChecked()) { //only product is checked
                if (product == answer2) {
                    correct = true;
                    numCorrect++;

                } else
                    correct = false;

            } else if (!added.isChecked() && !subtracted.isChecked() && !multiplied.isChecked()
                    && divided.isChecked()) { //only quotient is checked
                if (quotient == answer2) {
                    correct = true;
                    numCorrect++;

                } else
                    correct = false;


            }
        }


    }


    /*
    sends app to correct/incorrect screen
     */
    public void sendToScreen(View v) {
        answer();
        added = (CheckBox) findViewById((R.id.button1));
        subtracted = (CheckBox) findViewById((R.id.button2));
        multiplied = (CheckBox) findViewById((R.id.button3));
        divided = (CheckBox) findViewById((R.id.button4));

        //if there is no answer
        if (answer1.equals("")) {
            Toast.makeText(this, "Please enter an answer", Toast.LENGTH_SHORT).show();
        }
        //if more than one box is checked
        else if (!((added.isChecked() && !subtracted.isChecked() && !multiplied.isChecked()
                && !divided.isChecked()) || (!added.isChecked() && subtracted.isChecked() && !multiplied.isChecked()
                && !divided.isChecked()) || (!added.isChecked() && !subtracted.isChecked() && multiplied.isChecked()
                && !divided.isChecked()) || (!added.isChecked() && !subtracted.isChecked() && !multiplied.isChecked()
                && divided.isChecked())))

            Toast.makeText(this, "Please select one operation", Toast.LENGTH_SHORT).show();

        else {
            numTried++;
            Intent intent = new Intent(this, Check.class);
            intent.putExtra("correct", correct);
            intent.putExtra("numTried", numTried);
            intent.putExtra("numCorrect", numCorrect);
            intent.putExtra("multiplier", multiplier);
            startActivity(intent); //go to next screen
        }


    }


}
