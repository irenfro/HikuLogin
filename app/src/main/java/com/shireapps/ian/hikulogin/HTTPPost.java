package com.shireapps.ian.hikulogin;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.util.HashMap;

/**
 * Created by Ian on 11/24/15.
 */
public class HTTPPost extends HTTP {
    @Override
    protected String getMethod() {
        return "POST";
    }

    @Override
    protected void writeBody(HttpURLConnection conn, HashMap<String, String> postDataParams) throws UnsupportedEncodingException, IOException{
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, "UTF-8"));
        writer.write(getPostData(postDataParams));

        writer.flush();
        writer.close();
        os.close();
    }
}
