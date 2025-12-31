package com.lld.movie.entities;

import lombok.Getter;

import java.util.Map;

@Getter
public class Theatre {


    private String name;
    private String location;

    // map of screenId vs Screen
    private Map<Integer, Screen> screenMap;




}
