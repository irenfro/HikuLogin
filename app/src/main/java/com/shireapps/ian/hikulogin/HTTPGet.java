package com.shireapps.ian.hikulogin;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by Ian on 11/24/15.
 */
public class HTTPGet extends HTTP {
    @Override
    protected String getMethod() {
        return "GET";
    }

    protected String getCompleteURL(String requestURL, HashMap<String, String> postDataParams) throws UnsupportedEncodingException {
        return requestURL += "?" + getPostData(postDataParams);

    }
}
