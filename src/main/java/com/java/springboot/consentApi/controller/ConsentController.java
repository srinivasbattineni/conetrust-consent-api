package com.java.springboot.consentApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.springboot.consentApi.dto.ConsentRequest;
import com.java.springboot.consentApi.service.ConsentService;

@RestController
@RequestMapping("/api/consent")
public class ConsentController {

    private final ConsentService consentService;

    public ConsentController(ConsentService consentService) {
        this.consentService = consentService;
    }

    @PostMapping("/update-profile")
    public ResponseEntity<?> updateProfile(@RequestHeader("Authorization") String authorization, 
                                           @RequestBody ConsentRequest request) {
        return consentService.updateProfile(authorization, request);
    }
}
