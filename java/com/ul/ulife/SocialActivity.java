package com.ul.ulife;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SocialActivity extends CategoryActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_social);
    }
}
