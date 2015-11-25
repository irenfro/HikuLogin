package com.shireapps.ian.hikulogin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    private List[] l;
    private ArrayList<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Parcelable[] p = getIntent().getParcelableArrayExtra("list");
        l = new List[p.length];

        for(int i = 0; i < p.length; i++) {
            l[i] = (List) p[i];
        }

        convertData();
        uploadData();
        getSupportActionBar().setTitle("Shopping List");

    }


    private void convertData() {
        names = new ArrayList<>();
        for(int i = 0; i < l.length; i++) {
            names.add(l[i].getName());
        }
    }


    private void uploadData() {
        ListView listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                String s = tv.getText().toString();
                List item = new List();
                for (int i = 0; i < l.length; i++) {
                    if (l[i].getName().equals(s)) {
                        item = l[i];
                    }
                }
                startNextClass(item);
            }
        });
    }

    public void startNextClass(List item) {
        Intent intent = new Intent(this, DetailView.class);
        intent.putExtra("item", item);
        Log.d("List", "before: " + item.getName());
        startActivity(intent);
    }

}
