package com.example.lessonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private View finishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.secondTitle);
        finishBtn = findViewById(R.id.finish_activity_btn);
        textView.setText(getIntent().getStringExtra("result"));
        finishBtn.setOnClickListener(v -> {
            finishAffinity();
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("JOMA ", "onStop SECOND ACTIVITY");
    }
}