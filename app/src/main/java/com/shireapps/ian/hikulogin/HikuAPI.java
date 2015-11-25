package com.shireapps.ian.hikulogin;

import com.google.gson.Gson;

import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

/**
 * Created by Ian on 11/25/15.
 */
public abstract class HikuAPI {
    protected static String token;
    protected static String urlBase = "https://hiku-staging.herokuapp.com/api/v1/";
    private String appID = "e2a01662323845bf5b289b90f4c67dbae982d65247f235";
    private String secret = "18f9d67455211c636e";
    private boolean succeeded;
    private String errorMessage;

    protected Request sendRequest(HTTP request, HashMap<String, String> params) {
        addMandatoryParams(params);
        String response = request.doRequest(getAPIURL(), params);
        Gson gson = new Gson();
        Request r =  gson.fromJson(response, Request.class);
        if(r == null) {
            succeeded = false;
            errorMessage = "Please check you Network Settings.";
        } else {
            succeeded = r.getResponse().getStatus().equals("ok");
            if(!succeeded ) {
                errorMessage = r.getResponse().getErrMsg();
            }
        }
        return r;
    }

    public boolean success() {
      return succeeded;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    protected String getAPIURL() {
        return urlBase + getApiName();
    }

    protected abstract String getApiName();

    protected void addMandatoryParams(HashMap<String, String> map) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd H:mm:ss.SSSSSS");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        String utcTime = sdf.format(new Date());
        String s = appID + secret + utcTime;
        String hash = "";
        try {
            hash = getDigest("SHA-256", s, true);
        } catch (SignatureException e) {
            e.printStackTrace();
        }
        map.put("app_id", appID);
        map.put("time", utcTime);
        map.put("sig", hash);
    }

    private String getDigest(String algorithm, String data, boolean toLower)
            throws SignatureException {
        try {
            MessageDigest mac = MessageDigest.getInstance(algorithm);
            mac.update(data.getBytes("UTF-8"));
            return toLower ?
                    new String(toHex(mac.digest())).toLowerCase() : new String(toHex(mac.digest()));
        } catch (Exception e) {
            throw new SignatureException(e);
        }
    }

    private   String toHex(byte[] bytes) {
        BigInteger bi = new BigInteger(1, bytes);
        return String.format("%0" + (bytes.length << 1) + "X", bi);
    }
}
