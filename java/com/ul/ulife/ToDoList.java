package com.ul.ulife;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoList extends Activity {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView show_items;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        show_items = (ListView) findViewById(R.id.show_items);
        items = new ArrayList<String>();
        readItems();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        show_items.setAdapter(itemsAdapter);
        setupListViewListener();
    }

    private void setupListViewListener() {
        show_items.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        Context context = getApplicationContext();
                        CharSequence text = "Item Removed.";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);


                        // Remove the item within array at position
                        items.remove(pos);
                        toast.show();
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        writeItems();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();

        if(!( itemText.equals(""))) {
            itemsAdapter.add(itemText);
            etNewItem.setText("");
            writeItems();
        }
        else{
            Context context = getApplicationContext();
            CharSequence text = "Can't add nothing!";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }


    }

    private void readItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}