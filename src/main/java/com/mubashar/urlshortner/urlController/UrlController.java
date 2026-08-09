package com.mubashar.urlshortner.urlController;

import com.mubashar.urlshortner.DTO.ShortenDtoRequest;
import com.mubashar.urlshortner.DTO.ShortenDtoResponse;
import com.mubashar.urlshortner.Entity.Shortener;
import com.mubashar.urlshortner.urlShortnerService.UrlService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/urls")
public class Url {
private  final UrlService urlService;


    @PostMapping
    public ResponseEntity<ShortenDtoResponse> creatOriginalUrl(ShortenDtoRequest shortenDtoRequest){

        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.creatOriginalUrl(shortenDtoRequest);
    }

    @GetMapping("/url/{id}")
    public Optional<Shortener> getShortUrl(@PathVariable  Long id ){
        return urlService.getShroteUrl(id);

    }
}
