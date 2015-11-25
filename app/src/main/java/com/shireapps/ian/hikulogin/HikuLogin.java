package com.shireapps.ian.hikulogin;

import java.net.HttpURLConnection;
import java.util.HashMap;

/**
 * Created by Ian on 11/25/15.
 */
public class HikuLogin extends HikuAPI {

    private Request r;

    protected boolean login(String email, String password) {
        HashMap<String, String> map = new HashMap<>();
        map.put("email", email);
        map.put("password", password);
        HTTPPost request = new HTTPPost();
        r = sendRequest(request, map);
        if(success()) {
            token = r.getResponse().getData().getToken();
            return true;
        }
        return false;
    }


    protected String getApiName() {
        return "login";
    }
}