package com.ul.ulife;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimerActivity extends CategoryActivity {
    TextView timeView ;

    Button start, pause, reset, lap ;

    long MillisecondTime, StartTime, TimeBuff, UpdateTime = 0L ;

    Handler handler;

    int Seconds, Minutes, MilliSeconds ;

    ListView listView ;

    String[] ListElements = new String[] {  };

    List<String> ListElementsArrayList ;

    ArrayAdapter<String> adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if(savedInstanceState != null){
//            StartTime =
//        }

        timeView = (TextView)findViewById(R.id.timeView);
        start = (Button)findViewById(R.id.button);
        pause = (Button)findViewById(R.id.button2);
        reset = (Button)findViewById(R.id.button3);
        lap = (Button)findViewById(R.id.button4);
        listView = (ListView)findViewById(R.id.listview1);

        handler = new Handler() ;

        ListElementsArrayList = new ArrayList<String>(Arrays.asList(ListElements));

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                ListElementsArrayList
        );

        listView.setAdapter(adapter);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StartTime = SystemClock.elapsedRealtime();
                handler.postDelayed(runnable, 0);

                reset.setEnabled(false);
                start.setEnabled(false);

            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimeBuff += MillisecondTime;

                handler.removeCallbacks(runnable);

                reset.setEnabled(true);
                start.setEnabled(true);

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MillisecondTime = 0L ;
                StartTime = 0L ;
                TimeBuff = 0L ;
                UpdateTime = 0L ;
                Seconds = 0 ;
                Minutes = 0 ;
                MilliSeconds = 0 ;

                timeView.setText("00:00:00");

                ListElementsArrayList.clear();

                adapter.notifyDataSetChanged();
            }
        });

        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ListElementsArrayList.add(timeView.getText().toString());

                adapter.notifyDataSetChanged();

            }
        });


        AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(TimerActivity.this, TimerRecordsActivity.class);
                intent.putExtra("com.kumballz.brian.EXTRA_TIME", ListElementsArrayList.get(position));
                startActivity(intent);
            }
        };
        listView.setOnItemClickListener(onItemClickListener);

    }

    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_timer);
    }

    public Runnable runnable = new Runnable() {

        public void run() {

            MillisecondTime = SystemClock.elapsedRealtime() - StartTime;

            UpdateTime = TimeBuff + MillisecondTime;

            Seconds = (int) (UpdateTime / 1000);

            Minutes = Seconds / 60;

            Seconds = Seconds % 60;

            MilliSeconds = (int) (UpdateTime % 1000);

            timeView.setText("" + Minutes + ":"
                    + String.format("%02d", Seconds) + ":"
                    + String.format("%03d", MilliSeconds));

            handler.postDelayed(this, 0);
        }

    };
}