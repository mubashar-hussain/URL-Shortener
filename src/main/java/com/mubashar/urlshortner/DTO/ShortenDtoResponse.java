package com.mubashar.urlshortner.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShortenDtoResponse {
  private  String originalURl;
   private String shortenUrl;
}
