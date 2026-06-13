package com.battleship.battleship.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cell {

    Coordinates coordinates;

    Ship ship = null;

    Boolean isFired = false;

    Cell( Coordinates coordinates )
    {
        this.coordinates = coordinates;

    }

    public void setShip( Ship ship )
    {
        this.ship =ship;
    }

    // for execute action
    public void fire()
    {
        this.isFired = true;
    }

    // for undo action
    public void unFire()
    {
        this.isFired = false;
    }

    public boolean isFired()
    {
        return this.isFired;
    }
}
