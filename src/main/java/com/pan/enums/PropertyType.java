package com.pan.enums;

public enum PropertyType {

    AMAZON_URL("amazon_url"),
    KSRTC_URL("ksrtc_url"),
    BROWSER("browser");

    private String value;

    PropertyType(String value)
    {
        this.value = value;
    }

    public String getValue()
    {
        return value;
    }
}
