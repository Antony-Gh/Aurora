package com.example.aurora.ui.login;

import static com.example.aurora.ui.login.StandaardValues.chole;
import static com.example.aurora.ui.login.StandaardValues.cus_toolbar;
import static com.example.aurora.ui.login.StandaardValues.glu;
import static com.example.aurora.ui.login.StandaardValues.hema;
import static com.example.aurora.ui.login.StandaardValues.hemo;
import static com.example.aurora.ui.login.StandaardValues.red;
import static com.example.aurora.ui.login.StandaardValues.saveinfo;
import static com.example.aurora.ui.login.StandaardValues.serun;
import static com.example.aurora.ui.login.StandaardValues.vitb;
import static com.example.aurora.ui.login.StandaardValues.white;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aurora.R;

public class DataUI extends AppCompatActivity {

    private int pk = 0;
    private LinearLayout prog;

    private LinearLayout data;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.dataui);
        cus_toolbar(this);
        prog = findViewById(R.id.prog_lay);

        Button but = findViewById(R.id.but_analyze);

        ScrollView mm = findViewById(R.id.main);

        EditText ed1 = findViewById(R.id.edit1); // hemo
        EditText ed2 = findViewById(R.id.edit2); //chole
        EditText ed3 = findViewById(R.id.edit3); //red
        EditText ed4 = findViewById(R.id.edit4); //white
        EditText ed5 = findViewById(R.id.edit5); //hema
        EditText ed6 = findViewById(R.id.edit6); //serun
        EditText ed7 = findViewById(R.id.edit7); //vitb
        EditText ed8 = findViewById(R.id.edit8); //glucose

        EditText[] qq = {ed1, ed2, ed3, ed4, ed5, ed6, ed7, ed8};

        ed1.requestFocus();


        data = findViewById(R.id.data_lay);

        ed8.setOnEditorActionListener(
                (v, actionId, event) -> {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH ||
                            actionId == EditorInfo.IME_ACTION_DONE ||
                            event != null &&
                                    event.getAction() == KeyEvent.ACTION_DOWN &&
                                    event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                        if (event == null || !event.isShiftPressed()) {
                            but.performClick();
                            return true;
                        }
                    }
                    return false;
                }
        );

        but.setOnClickListener(view -> {

            for (EditText e : qq) {
                if (checkfored(e)) {
                    e.setError("Fill in this text box");
                    return;
                }
            }


            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(mm.getWindowToken(), 0);
            prog.setVisibility(View.VISIBLE);
            data.setVisibility(View.GONE);
            Context c = getApplicationContext();

            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            Intent k = new Intent();
                            k.setClass(DataUI.this, analyze.class);
                            saveinfo(c, ed1.getText().toString(), hemo);
                            saveinfo(c, ed2.getText().toString(), chole);
                            saveinfo(c, ed3.getText().toString(), red);
                            saveinfo(c, ed4.getText().toString(), white);
                            saveinfo(c, ed5.getText().toString(), hema);
                            saveinfo(c, ed6.getText().toString(), serun);
                            saveinfo(c, ed7.getText().toString(), vitb);
                            saveinfo(c, ed8.getText().toString(), glu);
                            startActivity(k);
                            pk = 1;
                        }
                    },
                    3000);

        });

    }

    private boolean checkfored(EditText ed) {
        return ed.getText().toString().length() == 0;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (pk == 1) {
            pk = 0;
            prog.setVisibility(View.GONE);
            data.setVisibility(View.VISIBLE);
        }
    }
}
