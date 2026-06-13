package com.battleship.battleship.entity;

import lombok.Getter;

@Getter
public class Coordinates {


    int x , y;


    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

}
