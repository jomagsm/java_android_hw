package com.example.lessonapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Integer firstNumber, secondNumber;
    private Boolean isOperationClick;

    private View operationBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                changeTextView("1");
                break;
            case R.id.btn_two:
                changeTextView("2");
                break;
            case R.id.btn_three:
                changeTextView("3");
                break;
            case R.id.btn_four:
                changeTextView("4");
                break;
            case R.id.btn_five:
                changeTextView("5");
                break;
            case R.id.btn_six:
                changeTextView("6");
                break;
            case R.id.btn_seven:
                changeTextView("7");
                break;
            case R.id.btn_eight:
                changeTextView("8");
                break;
            case R.id.btn_nine:
                changeTextView("9");
                break;
            case R.id.btn_zero:
                changeTextView("0");
                break;
            case R.id.btn_dot:
//                changeTextView(".");
                break;
            case R.id.btn_ac:
                textView.setText("0");
                firstNumber = null;
                secondNumber = null;
                break;
        }
        isOperationClick = false;
    }

    private void changeTextView(String value) {
        if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(value);
        } else {
            textView.append(value);
        }
    }

    public void onOperationClick(View view) {
        if (view.getId() != R.id.btn_equal) {
            if (firstNumber == null) {
                firstNumber = Integer.valueOf(textView.getText().toString());
                isOperationClick = true;
                operationBtn = view;
                return;
            }
            if (secondNumber == null) {
                System.out.println("FIRST " + firstNumber);
                secondNumber = Integer.valueOf(textView.getText().toString());
                Integer temp = getResult(firstNumber, secondNumber, operationBtn);
                operationBtn = view;

                if (temp != null) {
                    firstNumber = temp;
                    textView.setText(firstNumber.toString());
                } else {
                    textView.setText("ERROR");
                }
                System.out.println("FIRST " + firstNumber);

            } else {
                secondNumber = Integer.valueOf(textView.getText().toString());
                Integer temp = getResult(firstNumber, secondNumber, operationBtn);
                operationBtn = view;
                if (temp != null) {
                    firstNumber = temp;
                    textView.setText(firstNumber.toString());
                    ;
                } else {
                    textView.setText("ERROR");
                }
            }
        } else {
            if (secondNumber == null) {
                secondNumber = Integer.valueOf(textView.getText().toString());
                Integer result = getResult(firstNumber, secondNumber, operationBtn);
                if (result != null) {
                    textView.setText(result.toString());
                } else {
                    textView.setText("ERROR");
                }
            } else {
                Integer temp = Integer.valueOf(textView.getText().toString());
                Integer result = getResult(firstNumber, temp, operationBtn);
                if (result != null) {
                    textView.setText(result.toString());
                } else {
                    textView.setText("ERROR");
                }
            }

        }
        isOperationClick = true;
    }

    private Integer getResult(Integer a, Integer b, View operation) {
        Integer result = null;
        switch (operation.getId()) {
            case R.id.btn_plus:
                result = a + b;
                break;
            case R.id.btn_minus:
                result = a - b;
                break;
            case R.id.btn_multiply:
                result = a * b;
                break;
            case R.id.btn_division:
                if (secondNumber != 0) {
                    result = a / b;
                }
                break;
        }
        return result;
    }

}