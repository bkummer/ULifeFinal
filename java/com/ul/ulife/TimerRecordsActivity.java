package com.ul.ulife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TimerRecordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_records);
        String time = (String) getIntent().getExtras().get("com.kumballz.brian.EXTRA_TIME");

        TextView textView = (TextView) findViewById(R.id.textViewTime);
        textView.setText(time);

    }
}
