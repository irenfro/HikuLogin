package com.shireapps.ian.hikulogin;

import java.util.HashMap;

/**
 * Created by Ian on 11/25/15.
 */
public class HikuList extends HikuAPI {

    private Request r;

    protected boolean getList() {
        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        r = sendRequest(new HTTPGet(), map);
        return success();
    }

    protected Data getData() {
        return r.getResponse().getData();
    }

    @Override
    protected String getApiName() {
        return "list";
    }

    protected HashMap<String, List> getMappedList() {
        List[] l = getData().getList();
        HashMap<String, List> names = new HashMap<>();
        for(int i = 0; i < l.length; i++) {
            names.put(l[i].getName(), l[i]);
        }
        return names;
    }
}
