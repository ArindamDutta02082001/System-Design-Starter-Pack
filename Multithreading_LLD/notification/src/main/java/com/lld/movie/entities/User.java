package com.lld.movie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class User {

    private Integer userId;
    private String name;
    private String email;
}
