package com.ul.ulife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void setUpContent() {
        setContentView(R.layout.activity_main);
    }


    public void onClickTimetableActivity(View view){
        Intent LaunchIntent;
        if(getPackageManager().getLaunchIntentForPackage("ie.gavin.ulstudenttimetable") != null) {
            LaunchIntent  = getPackageManager().getLaunchIntentForPackage("ie.gavin.ulstudenttimetable");
            startActivity(LaunchIntent);
        }
        else{
            LaunchIntent = new Intent(android.content.Intent.ACTION_VIEW);
            LaunchIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=ie.gavin.ulstudenttimetable"));
            startActivity(LaunchIntent);
        }

    }

    public void onClickNavigationActivity(View view) {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    public void onClickDiningActivity(View view) {
        Intent intent = new Intent(this, DiningOptionActivity.class);
        startActivity(intent);
    }
    public void onClickULLifeHacksActivity(View view) {
        Intent intent = new Intent(this, ULLifeHacksActivity.class);
        startActivity(intent);
    }
    public void onClickToolsActivity(View view) {
        Intent intent = new Intent(this, ToolsActivity.class);
        startActivity(intent);
    }
    public void onClickSocialActivity(View view) {
        Intent intent = new Intent(this, SocialActivity.class);
        startActivity(intent);
    }
}