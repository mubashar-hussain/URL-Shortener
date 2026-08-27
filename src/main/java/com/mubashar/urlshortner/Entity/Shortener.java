package com.mubashar.urlshortner.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "shortener")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shortener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false,length = 2048)
    private String originalUrl ;

    @Column(nullable = false , unique = true)
    private String shortCode;


    public Shortener(String shortcode, String originalUrl) {
        this.shortCode = shortcode;
        this.originalUrl = originalUrl;

    }
}
