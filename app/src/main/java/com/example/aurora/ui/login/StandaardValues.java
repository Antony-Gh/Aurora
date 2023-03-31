package com.example.aurora.ui.login;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.aurora.R;

public class StandaardValues {

    public final static String hemo = "hemo";
    public final static String chole = "chole";
    public final static String red = "red";
    public final static String white = "white";
    public final static String hema = "hema";
    public final static String serun = "serun";
    public final static String vitb = "vitb";
    public final static String glu = "glu";
    final static double hemolow = 11.5;
    final static double hemohigh = 15.5;//gm/DeciL
    final static double redbloodlow = 4; //MillionRBCs/MicroL
    final static double redbloodhigh = 5.2;
    final static double whitebloodlow = 4500; //WBCs/MicroL
    final static double whitebloodhigh = 11000;
    final static double hematocritlow = 36; //Percent
    final static double hematocrithigh = 45;
    final static double serunlow = 60; //mcg/DeciL
    final static double serunhigh = 170;
    final static double vitaminblow = 160; //pg/mL
    final static double vitaminbhigh = 950;
    final static double glucoselow = 70; //mg/deciL
    final static double glucosehigh = 105;
    final static int normal = 0;
    final static int high = 1;
    final static int low = 2;

    public static int hemo(String val) {
        if (Double.parseDouble(val) > hemohigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < hemolow) {
                return low;
            } else {
                return normal;
            }
        }
    }


    public static int hematocrit(String val) {
        if (Double.parseDouble(val) > hematocrithigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < hematocritlow) {
                return low;
            } else {
                return normal;
            }
        }
    }

    public static int chole(String val) {
        if (Double.parseDouble(val) > 210) {
            return high;
        } else {
            if (Double.parseDouble(val) < 190) {
                return low;
            } else {
                return normal;
            }
        }
    }

    public static int redblood(String val) {
        if (Double.parseDouble(val) > redbloodhigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < redbloodlow) {
                return low;
            } else {
                return normal;
            }
        }
    }


    public static int whiteblood(String val) {
        if (Double.parseDouble(val) > whitebloodhigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < whitebloodlow) {
                return low;
            } else {
                return normal;
            }
        }
    }

    public static int serun(String val) {
        if (Double.parseDouble(val) > serunhigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < serunlow) {
                return low;
            } else {
                return normal;
            }
        }
    }

    public static int vitaminb(String val) {
        if (Double.parseDouble(val) > vitaminbhigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < vitaminblow) {
                return low;
            } else {
                return normal;
            }
        }
    }

    public static int glucose(String val) {
        if (Double.parseDouble(val) > glucosehigh) {
            return high;
        } else {
            if (Double.parseDouble(val) < glucoselow) {
                return low;
            } else {
                return normal;
            }
        }
    }

    public static void savelogin(Context c) {
        SharedPreferences sp = c.getSharedPreferences("sp", MODE_PRIVATE);
        sp.edit().putBoolean("login", true).apply();
    }

    public static boolean getlogin(Context c) {
        SharedPreferences sp = c.getSharedPreferences("sp", MODE_PRIVATE);
        return sp.getBoolean("login", false);
    }

    public static void saveinfo(Context c, String i, String type) {
        SharedPreferences sp = c.getSharedPreferences("tests", MODE_PRIVATE);
        sp.edit().putString(type, i).apply();
    }

    public static String getinfo(Context c, String type) {
        SharedPreferences sp = c.getSharedPreferences("tests", MODE_PRIVATE);
        return sp.getString(type, "");
    }

    public static void cus_toolbar(androidx.appcompat.app.AppCompatActivity a) {
        androidx.appcompat.app.ActionBar q = a.getSupportActionBar();
        q.setDisplayShowCustomEnabled(true);
        q.setDisplayShowTitleEnabled(false);
        LayoutInflater inflator = LayoutInflater.from(a);
        View v = inflator.inflate(R.layout.toolbar, null);
        ((TextView) v.findViewById(R.id.textView1)).setText(a.getTitle());
        v.setBackgroundColor(a.getResources().getColor(R.color.colorPrimaryDark, null));
        v.setForegroundGravity(Gravity.CENTER);
        v.setEnabled(false);
        q.setCustomView(v);
        q.setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(a, R.color.colorPrimaryDark)));
    }


}
