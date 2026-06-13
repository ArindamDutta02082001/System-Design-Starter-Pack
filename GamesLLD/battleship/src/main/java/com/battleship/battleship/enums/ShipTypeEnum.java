package com.battleship.battleship.enums;

import lombok.Getter;

@Getter
public enum ShipTypeEnum {

    CARRIER(5),
    BATTLESHIP(4),
    CRUISER(3),
    SUBMARINE(3),
    DESTROYER(2);

    final int length;

    ShipTypeEnum(int length )
    {
        this.length = length;
    }




}
