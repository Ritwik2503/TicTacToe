package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7,btn8, btn9,restart;
    TextView textView;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    int flag=0;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Tic Tac Toe");
        inIt();
        textView= findViewById(R.id.textView);
        restart= findViewById(R.id.button);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartActivity();
            }
        });

    }
    private void inIt(){// initialization method
        btn1= findViewById(R.id.btn1);
        btn2= findViewById(R.id.btn2);
        btn3= findViewById(R.id.btn3);
        btn4= findViewById(R.id.btn4);
        btn5= findViewById(R.id.btn5);
        btn6= findViewById(R.id.btn6);
        btn7= findViewById(R.id.btn7);
        btn8= findViewById(R.id.btn8);
        btn9= findViewById(R.id.btn9);
    }
    public void restartActivity(){
        Intent intent= new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void check(View view) {// to check the sign of what the user has entered
        Button btnCurr = (Button) view;// making the run time data type of view as button
        if (btnCurr.getText().toString().equals("")) {
            count++;
            if (flag % 2 == 0) {
                btnCurr.setText("X");
            } else {
                btnCurr.setText("o");
            }
            flag++;

            if (count > 4) {// getting values of all buttons when 5 chances are played

                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();

                if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b1);
                    restartActivity();
                } else if (b4.equals(b5) && b5.equals(b6) && !b6.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b4);
                    restartActivity();
                } else if (b7.equals(b8) && b8.equals(b9) && !b8.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b7);
                    restartActivity();
                } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b1);
                    restartActivity();
                } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b2);
                    restartActivity();

                } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b3);
                    restartActivity();

                } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b1);
                    restartActivity();

                } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")) {
                    textView.setText(getText((R.string.winner_is)) + b3);
                    restartActivity();
                } else if (count == 9) {
                    textView.setText("All the moves have been played and no winner is found");
                }
            }
        }
    }
}