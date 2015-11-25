package com.shireapps.ian.hikulogin;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ian on 11/25/15.
 */
public class ListItemArrayAdapter extends BaseAdapter {
    private Activity activity;
    private static LayoutInflater inflater = null;
    private HashMap<String, List> items;
    private String[] keys;
    private int listViewId;
    private int textViewId;


    public ListItemArrayAdapter(Activity a, int listViewId, int textViewId, HashMap<String, List> items) {
        try {
            this.activity = a;
            this.items = items;
            this.listViewId = listViewId;
            this.textViewId = textViewId;
            this.keys = items.keySet().toArray(new String[items.size()]);

            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public List getItem(int position) {
        return items.get(keys[position]);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        final ViewHolder holder;
        try {
            if (convertView == null) {
                vi = inflater.inflate(android.R.layout.simple_list_item_1, null);
                holder = new ViewHolder();

                holder.name = (TextView) vi.findViewById(android.R.id.text1);

                vi.setTag(holder);
            } else {
                holder = (ViewHolder) vi.getTag();
            }

            holder.name.setText(getItem(position).getName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vi;
    }
}
