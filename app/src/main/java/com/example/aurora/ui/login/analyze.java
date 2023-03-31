package com.example.aurora.ui.login;

import static com.example.aurora.ui.login.StandaardValues.cus_toolbar;
import static com.example.aurora.ui.login.StandaardValues.getinfo;
import static com.example.aurora.ui.login.StandaardValues.high;
import static com.example.aurora.ui.login.StandaardValues.low;
import static com.example.aurora.ui.login.StandaardValues.normal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aurora.R;

public class analyze extends AppCompatActivity {

    private int redcount = 0;
    private int bluecount = 0;
    private int greencount = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.analyze);
        cus_toolbar(this);

        LinearLayout doc_lin = findViewById(R.id.doc_lin);
        TextView redf = findViewById(R.id.red_count);
        TextView grf = findViewById(R.id.green_count);
        TextView blf = findViewById(R.id.blue_count);

        TextView hemo_val = findViewById(R.id.hemo_val);
        TextView chole_val = findViewById(R.id.chole_val);
        TextView red_val = findViewById(R.id.red_val);
        TextView white_val = findViewById(R.id.white_val);
        TextView hema_val = findViewById(R.id.hema_val);
        TextView serun_val = findViewById(R.id.serun_val);
        TextView vit_val = findViewById(R.id.vit_val);
        TextView glu_val = findViewById(R.id.glu_val);

        Context c = getApplicationContext();
        final String hema = getinfo(c, StandaardValues.hema);
        final String chole = getinfo(c, StandaardValues.chole);
        final String red = getinfo(c, StandaardValues.red);
        final String white = getinfo(c, StandaardValues.white);
        final String hemo = getinfo(c, StandaardValues.hemo);
        final String serun = getinfo(c, StandaardValues.serun);
        final String vitb = getinfo(c, StandaardValues.vitb);
        final String glu = getinfo(c, StandaardValues.glu);

        hemo_val.setText(hemo);
        hema_val.setText(hema);
        chole_val.setText(chole);
        red_val.setText(red);
        white_val.setText(white);
        serun_val.setText(serun);
        vit_val.setText(vitb);
        glu_val.setText(glu);


        TextView txt1 = findViewById(R.id.hemo_risk);
        TextView txt2 = findViewById(R.id.chole_risk);
        TextView txt3 = findViewById(R.id.red_risk);
        TextView txt4 = findViewById(R.id.white_risk);
        TextView txt5 = findViewById(R.id.hema_risk);
        TextView txt6 = findViewById(R.id.serun_risk);
        TextView txt7 = findViewById(R.id.vit_risk);
        TextView txt8 = findViewById(R.id.glu_risk);


        int ihemo = StandaardValues.hemo(hemo);
        swi(ihemo, txt1);

        int ichole = StandaardValues.chole(chole);
        swi(ichole, txt2);

        int ired = StandaardValues.redblood(red);
        swi(ired, txt3);

        int iwhite = StandaardValues.whiteblood(white);
        swi(iwhite, txt4);

        int ihema = StandaardValues.hematocrit(hema);
        swi(ihema, txt5);

        int iserun = StandaardValues.serun(serun);
        swi(iserun, txt6);

        int ivit = StandaardValues.vitaminb(vitb);
        swi(ivit, txt7);

        int iglu = StandaardValues.glucose(glu);
        swi(iglu, txt8);

        String re = redcount + " " + getApplicationContext().getResources().getString(R.string.red_flag);
        String gre = greencount + " " + getApplicationContext().getResources().getString(R.string.normal_flag);
        String ble = bluecount + " " + getApplicationContext().getResources().getString(R.string.blue_flag);

        redf.setText(re);
        grf.setText(gre);
        blf.setText(ble);


        if (redcount > 2 || bluecount > 2) {
            doc_lin.setVisibility(View.VISIBLE);
        }

        Button doc_but = findViewById(R.id.doc_but);
        doc_but.setOnClickListener(view -> {
            Intent k = new Intent();
            k.setClass(analyze.this, DocsActivity.class);
            startActivity(k);
        });


    }

    private void swi(int kk, TextView v) {
        switch (kk) {
            case normal:
                v.setText(R.string.normal_rate);
                v.setTextColor(getResources().getColor(R.color.green, null));
                greencount++;
                break;
            case high:
                v.setText(R.string.high_rate);
                v.setTextColor(getResources().getColor(R.color.red, null));
                redcount++;
                break;
            case low:
                v.setText(R.string.low_rate);
                v.setTextColor(getResources().getColor(R.color.blue, null));
                bluecount++;
                break;
        }
    }

}
