package com.example.aurora.ui.login;

import static com.example.aurora.ui.login.StandaardValues.cus_toolbar;
import static com.example.aurora.ui.login.StandaardValues.savelogin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aurora.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText usernameEditText = findViewById(R.id.username);
        final Button loginButton = findViewById(R.id.login);
        TextView err = findViewById(R.id.err);
        TextView txt = findViewById(R.id.nodev);
        cus_toolbar(this);
        androidx.constraintlayout.widget.ConstraintLayout mm = findViewById(R.id.container);

        txt.setOnClickListener(view -> {

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mm.getWindowToken(), 0);
            savelogin(LoginActivity.this);
            Intent k = new Intent();
            k.setClass(LoginActivity.this, DataUI.class);
            k.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(k);
            finish();

        });


        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginButton.setEnabled(s.length() != 0);
                err.setVisibility(View.GONE);
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);

        loginButton.setOnClickListener(v -> {
            if (usernameEditText.getText().toString().equals("Aurora")) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mm.getWindowToken(), 0);
                savelogin(LoginActivity.this);
                Intent k = new Intent();
                k.setClass(LoginActivity.this, DataUI.class);
                k.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(k);
                finish();
            } else {
                err.setVisibility(View.VISIBLE);
            }
        });
    }

}