package com.mubashar.urlshortner.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "short_url")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shortener {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @Column(nullable = false,length = 2048)
    private String originalURl ;

    @Column(nullable = false , unique = true)
    private String shortUrl;

}
