package com.mubashar.urlshortner.urlController;

import com.mubashar.urlshortner.DTO.ShortenUrlRequest;
import com.mubashar.urlshortner.DTO.ShortenUrlResponse;
import com.mubashar.urlshortner.urlShortnerService.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/urls")
public class UrlController {
    private final UrlService urlService;


    @PostMapping
    public ResponseEntity<ShortenUrlResponse> sendOriginalUrl(@RequestBody ShortenUrlRequest shortener){

        return ResponseEntity.ok(urlService.sendUrl(shortener));
    }


}