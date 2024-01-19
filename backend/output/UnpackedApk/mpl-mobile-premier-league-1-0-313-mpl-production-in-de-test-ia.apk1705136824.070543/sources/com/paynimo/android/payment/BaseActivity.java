package com.paynimo.android.payment;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setIcon(getResources().getIdentifier("ic_launcher", "drawable", getApplicationContext().getPackageName()));
            supportActionBar.setDisplayShowHomeEnabled(true);
            supportActionBar.show();
        }
    }
}
