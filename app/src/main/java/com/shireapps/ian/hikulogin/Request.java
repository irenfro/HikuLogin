package com.shireapps.ian.hikulogin;

import java.io.Serializable;

public class Request {
	private Response response;

    public Response getResponse ()
    {
        return response;
    }

    public void setResponse (Response response)
    {
        this.response = response;
    }

    @Override
    public String toString() {
        return "[response = "+response+"]";
    }
}
