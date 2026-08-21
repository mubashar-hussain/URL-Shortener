package com.mubashar.urlshortner.urlShortnerService;

import com.mubashar.urlshortner.DTO.ShortenUrlRequest;
import com.mubashar.urlshortner.DTO.ShortenUrlResponse;
import com.mubashar.urlshortner.Entity.Shortener;
import com.mubashar.urlshortner.repo.UrlRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
public class UrlService {
    private final UrlRepo urlRepo;

    public UrlService(UrlRepo urlRepo) {
        this.urlRepo = urlRepo;
    }

    public ShortenUrlResponse sendUrl(ShortenUrlRequest request) {
        String shortcode = generateShortCode();

        Shortener shortener = new Shortener();

        shortener.setOriginalURl(request.originalUrl());
        shortener.setShortUrl(shortcode);

        Shortener saved = urlRepo.save(shortener);

        String shorturl = "http://localhost:8080/" + shortcode;

        return new ShortenUrlResponse(saved.getOriginalURl(), request.originalUrl());

    }

    public String getOriginalUrl(String shortcode) {

        Shortener shortener = urlRepo.findShortCode(shortcode).orElseThrow(() -> new RuntimeException("Short url not found"));

        return shortener.getOriginalURl();
    }


    public String generateShortCode() {

        return UUID.randomUUID().toString().substring(0, 6);
    }
}
