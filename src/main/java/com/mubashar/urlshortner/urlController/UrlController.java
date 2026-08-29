package com.mubashar.urlshortner.urlController;

import com.mubashar.urlshortner.DTO.ShortenUrlRequest;
import com.mubashar.urlshortner.DTO.ShortenUrlResponse;
import com.mubashar.urlshortner.urlShortnerService.UrlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@AllArgsConstructor
@RequestMapping("/api/urls")
public class UrlController {
    private final UrlService urlService;

    public UrlController(UrlService urlService){
        this.urlService = urlService;

    }


    @PostMapping("/")
    public ResponseEntity<ShortenUrlResponse> createShortUrl(@RequestBody ShortenUrlRequest shortener){

        return ResponseEntity.ok(urlService.sendUrl(shortener));
    }



    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> redirect(@PathVariable String shortCode) {

        String  originalUrl = urlService.getOriginalUrl(shortCode);
        return  ResponseEntity
                .status(302)
                .header("Location",originalUrl)
                .build();

    }

}