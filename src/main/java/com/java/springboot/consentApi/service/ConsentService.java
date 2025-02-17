package com.java.springboot.consentApi.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.java.springboot.consentApi.constants.AppConstants;
import com.java.springboot.consentApi.dto.ConsentRequest;
import com.java.springboot.consentApi.utils.Utility;

@Service
public class ConsentService {

    private final RestTemplate restTemplate;
    private final String consentApiUrl;

    public ConsentService(RestTemplate restTemplate, 
                          @Value("${consent.api.url}") String consentApiUrl) {
        this.restTemplate = restTemplate;
        this.consentApiUrl = consentApiUrl;
    }

    public ResponseEntity<?> updateProfile(String authorization, ConsentRequest request) {
        try {
            HttpHeaders headers = Utility.createHeaders(authorization);
            HttpEntity<ConsentRequest> entity = new HttpEntity<>(request, headers);
            ResponseEntity<String> response = restTemplate.exchange(consentApiUrl, HttpMethod.POST, entity, String.class);
            return ResponseEntity.ok(response.getBody());
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body("Error: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(AppConstants.INTERNAL_SERVER_ERROR + e.getMessage());
        }
    }
}
