package com.java.springboot.consentApi.utils;

import org.springframework.http.HttpHeaders;

import com.java.springboot.consentApi.constants.AppConstants;

public class Utility {
    public static HttpHeaders createHeaders(String authorization) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(AppConstants.AUTHORIZATION_HEADER, authorization);
        headers.set(AppConstants.CONTENT_TYPE_HEADER, AppConstants.CONTENT_TYPE_JSON);
        return headers;
    }
}
