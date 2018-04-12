package com.ul.ulife;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Brian on 3/1/18.
 */

abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUpContent();
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
    }

    protected abstract void setUpContent();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id) {
            case R.id.action_navigation:
                Intent intent_1 = new Intent(this, NavigationActivity.class);
                startActivity(intent_1);
                return true;
            case R.id.action_dining:
                Intent intent_2 = new Intent(this, DiningOptionActivity.class);
                startActivity(intent_2);
                return true;
            case R.id.action_ullifehacks:
                Intent intent_3 = new Intent(this, ULLifeHacksActivity.class);
                startActivity(intent_3);
                return true;
            case R.id.action_tools:
                Intent intent_4 = new Intent(this, ToolsActivity.class);
                startActivity(intent_4);
                return true;
            case R.id.action_social:
                Intent intent_5 = new Intent(this, SocialActivity.class);
                startActivity(intent_5);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
