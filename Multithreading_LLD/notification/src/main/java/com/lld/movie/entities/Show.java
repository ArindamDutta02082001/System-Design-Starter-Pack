package com.lld.movie.entities;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Show {

    Integer showId = UUID.randomUUID().hashCode();

    LocalDateTime startTime;
    LocalDateTime endTime;

    Movie movie;


}
