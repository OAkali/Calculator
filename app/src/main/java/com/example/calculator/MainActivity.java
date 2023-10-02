package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView viewText;
    private Integer first, second, sum,result;
    private Boolean isOperationClick;
    private String operation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewText = findViewById(R.id.tv_1);
    }

    public void onNumberClick(View view) {
        if (view.getId() == R.id.mb_AC) {
            viewText.setText("0");
        } else {
            String textMB = ((Button) view).getText().toString();
            if (viewText.getText().toString().equals("0") || isOperationClick) {
                viewText.setText(textMB);
            } else {
                viewText.append(textMB);
            }
        }
        isOperationClick = false;


    }

    public void onOperationClick(View view) {


        if (view.getId() == R.id.mb_plus) {
            first = Integer.valueOf(viewText.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.mb_x) {
            first = Integer.valueOf(viewText.getText().toString());
            operation = "*";
        } else if (view.getId() == R.id.mb_dil) {
            first = Integer.valueOf(viewText.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.mb_mn1) {
            first = Integer.valueOf(viewText.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.mb_mn) {
            second = Integer.valueOf(viewText.getText().toString());
            switch (operation) {
                case "+":
                    sum = first += second;
                    viewText.setText(sum.toString());
                    break;
                case "*":
                    result = first * second;
                    viewText.setText(result.toString());
                    break;
                case "-":
                    sum = first -= second;
                    viewText.setText(sum.toString());
                    break;
                case "/":
                    result=first/second;
                    viewText.setText(result.toString());
                    break;
            }
        }


        isOperationClick = true;

    }
}