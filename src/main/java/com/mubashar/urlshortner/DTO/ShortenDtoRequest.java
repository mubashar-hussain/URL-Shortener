package com.mubashar.urlshortner.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShortenDtoRequest {

    private String originalUrl;
    private String shortenUrl;
}
