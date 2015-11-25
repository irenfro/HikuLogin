package com.shireapps.ian.hikulogin;

import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Ian on 11/24/15.
 */
public abstract class HTTP {
    protected String doRequest(String requestURL, HashMap<String, String> postDataParams) {
        URL url;
        String response = "";
        try {
            url = new URL(getCompleteURL(requestURL, postDataParams));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod(getMethod());
            conn.setDoInput(true);

            writeBody(conn, postDataParams);

            int responseCode=conn.getResponseCode();

            System.out.println(responseCode);

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                response = IOUtils.toString(conn.getInputStream(), "UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    protected String getPostData(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    protected String getCompleteURL(String requestURL, HashMap<String, String> postDataParams) throws UnsupportedEncodingException {
        return requestURL;
    }

    protected void writeBody(HttpURLConnection conn, HashMap<String, String> postDataParams) throws UnsupportedEncodingException, IOException {

    }

    protected abstract String getMethod();

}