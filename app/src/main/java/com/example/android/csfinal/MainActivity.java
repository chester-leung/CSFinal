package com.example.android.csfinal;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /*
    send to math screen where user can do math
     */
    public void send(View v)
    {
        EditText answer = (EditText) findViewById((R.id.user_input));
        String answer1 = answer.getText().toString();
        int answer2 = Integer.parseInt(answer1); //captures user input for highest integer generated

        Intent intent = new Intent(MainActivity.this, test.class);
        intent.putExtra("userInput", answer2);
        MainActivity.this.startActivity(intent);
    }

}
