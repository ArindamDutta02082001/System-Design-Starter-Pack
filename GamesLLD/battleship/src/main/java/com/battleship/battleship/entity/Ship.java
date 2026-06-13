package com.battleship.battleship.entity;

import com.battleship.battleship.enums.ShipDirection;
import com.battleship.battleship.enums.ShipTypeEnum;
import lombok.Getter;

@Getter
public class Ship {

     Coordinates startCoordinates;

     ShipTypeEnum typeEnum;

     ShipDirection direction;

    public Ship( Coordinates startCordinates, ShipTypeEnum typeEnum, ShipDirection direction)
    {
        this.startCoordinates = startCordinates;
        this.typeEnum = typeEnum;
        this.direction = direction;

    }

    // to check if ship is shunk

    int hitCount = 0;


    // for execute
    public void registerHit() {
        hitCount++;
    }

    // for undo
    public void unregisterHit() {
        if (hitCount > 0) hitCount--;
    }

    public boolean isSunk() {
        return hitCount == typeEnum.getLength();
    }

}
