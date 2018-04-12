package com.ul.ulife;

import android.os.Bundle;
import android.support.v7.app.ActionBar;

/**
 * Created by Brian on 3/1/18.
 */

abstract class CategoryActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }
}
