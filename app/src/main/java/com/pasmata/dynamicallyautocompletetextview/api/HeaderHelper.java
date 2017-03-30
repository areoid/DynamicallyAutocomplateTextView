package com.pasmata.dynamicallyautocompletetextview.api;

/**
 * Created by jhon on 29/03/17.
 */

public class HeaderHelper {
    private String headerName;
    private String headerValue;

    public HeaderHelper(){}

    public HeaderHelper(String name, String value) {
        this.headerName = name;
        this.headerValue = value;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    public  String getHeaderName() {
        return this.headerName;
    }

    public String getHeaderValue() {
        return this.headerValue;
    }
}