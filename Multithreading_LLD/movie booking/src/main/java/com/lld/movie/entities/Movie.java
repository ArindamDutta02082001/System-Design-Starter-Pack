package com.lld.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movie {

    private Integer movieId;
    private String name;
    private String genre;
    private int duration; // in minutes

    // can use factory pattern for creating diff movies not using as of now

}
