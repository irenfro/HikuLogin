package com.shireapps.ian.hikulogin;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

import android.annotation.TargetApi;

import android.content.Intent;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity {

    private List[] l;
    private HashMap<String, List> names;
    private View mProgressView;


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

        getSupportActionBar().setTitle("Shopping List");
        mProgressView = findViewById(R.id.login_progress);
        showProgress(true);
        new UserGetListTask().execute();
    }

    public class UserGetListTask extends AsyncTask<Object, Void, HikuList> {

        @Override
        protected HikuList doInBackground(Object... unused) {
            HikuList list = new HikuList();
            list.getList();
            return list;
        }

        @Override
        protected void onPostExecute(HikuList response) {
            showProgress(false);

            if(!response.success()) {
                Toast.makeText(getApplicationContext(),
                        response.getErrorMessage(), Toast.LENGTH_SHORT).show();
            } else {
                l = response.getData().getList();
                names = response.getMappedList();
                populateListView();
            }
        }

    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }




    private void populateListView() {
        ListView listView = (ListView) findViewById(R.id.list);
        ListItemArrayAdapter adapter = new ListItemArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                String s = tv.getText().toString();
                List item = names.get(s);
                openDetailView(item);
            }
        });
    }

    public void openDetailView(List item) {
        Intent intent = new Intent(this, DetailView.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

}
