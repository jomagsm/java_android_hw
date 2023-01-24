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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String loginAndPassword = "admin";
        TextView authAppBarTitle = findViewById(R.id.auth_app_bar_title);
        EditText email = findViewById(R.id.auth_email);
        EditText password = findViewById(R.id.auth_password);
        Button button = findViewById(R.id.main_button);
        TextView authDescription = findViewById(R.id.auth_description);
        LinearLayout forgetPass = findViewById(R.id.forget_pass_text);
        Drawable buttonDrawable = button.getBackground();
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    DrawableCompat.setTint(buttonDrawable, Color.rgb(248, 116, 0));
                } else {
                    DrawableCompat.setTint(buttonDrawable, Color.rgb(121, 121, 121));
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "Неправильный логин и пароль";
                String emailTxt = email.getText().toString();
                System.out.println(emailTxt);
                System.out.println("admin");
                System.out.println(emailTxt.equals(loginAndPassword));
                System.out.println(password.getText().toString());
                if (email.getText().toString().equals(loginAndPassword) &&
                        password.getText().toString().equals(loginAndPassword)) {
                    result = "Добро пожаловать";
                    authAppBarTitle.setVisibility(View.GONE);
                    email.setVisibility(View.GONE);
                    password.setVisibility(View.GONE);
                    authDescription.setVisibility(View.GONE);
                    button.setVisibility(View.GONE);
                    forgetPass.setVisibility(View.GONE);
                }
                Toast.makeText(MainActivity.this,
                        result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}