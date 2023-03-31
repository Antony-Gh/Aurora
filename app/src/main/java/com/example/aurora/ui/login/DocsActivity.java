package com.example.aurora.ui.login;

import static com.example.aurora.ui.login.StandaardValues.cus_toolbar;
import static com.example.aurora.ui.login.StandaardValues.getinfo;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aurora.R;

import java.util.Locale;

@SuppressWarnings("ALL")
public class DocsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docs);
        cus_toolbar(this);

        Context c = getApplicationContext();

        LinearLayout early_dia_lin = findViewById(R.id.early_dia_lin);
        LinearLayout dia_lin = findViewById(R.id.dia_lin);
        LinearLayout hypo_lin = findViewById(R.id.hypo_lin);
        LinearLayout anem_lin = findViewById(R.id.anemia_lin);
        LinearLayout dehy_lin = findViewById(R.id.dehy_lin);
        LinearLayout aids_lin = findViewById(R.id.aids_lin);

        early_dia_lin.setVisibility(View.GONE);
        dia_lin.setVisibility(View.GONE);
        hypo_lin.setVisibility(View.GONE);
        anem_lin.setVisibility(View.GONE);
        dehy_lin.setVisibility(View.GONE);
        aids_lin.setVisibility(View.GONE);

        TextView early = findViewById(R.id.early_dia);
        TextView dia = findViewById(R.id.dia);
        TextView hypo = findViewById(R.id.hypo);
        TextView anem = findViewById(R.id.anemia);
        TextView dehy = findViewById(R.id.dehy);
        TextView aids = findViewById(R.id.aids);

        if (Locale.getDefault().getLanguage().equals("en")) {
            early.setText(Html.fromHtml(getString(R.string.eaarly_diabetes)));
            dia.setText(Html.fromHtml(getString(R.string.diabetes_des)));
            hypo.setText(Html.fromHtml(getString(R.string.hypoglycemia_des)));
            anem.setText(Html.fromHtml(getString(R.string.anemia_des)));
            dehy.setText(Html.fromHtml(getString(R.string.dehy_des)));
            aids.setText(Html.fromHtml(getString(R.string.aids_des)));


            TextView[] kk = {early, dia, hypo, anem, dehy, aids};

            for (TextView uu : kk) {
                uu.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }

        final String glu = getinfo(c, StandaardValues.glu);
        final String hema = getinfo(c, StandaardValues.hema);
        final String wbc = getinfo(c, StandaardValues.white);

        if (Double.parseDouble(glu) > 105 && Double.parseDouble(glu) < 126) {
            early_dia_lin.setVisibility(View.VISIBLE);
        } else {
            if (Double.parseDouble(glu) >= 126) {
                dia_lin.setVisibility(View.VISIBLE);
            } else {
                if (Double.parseDouble(glu) < 70) {
                    hypo_lin.setVisibility(View.VISIBLE);
                }
            }
        }

        if (Double.parseDouble(hema) < 36) {
            anem_lin.setVisibility(View.VISIBLE);
        } else {
            if (Double.parseDouble(hema) > 45) {
                dehy_lin.setVisibility(View.VISIBLE);
            }
        }

        if (Double.parseDouble(wbc) < 4500) {
            aids_lin.setVisibility(View.VISIBLE);
        }


    }


}
