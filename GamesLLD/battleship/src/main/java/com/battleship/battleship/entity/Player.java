package com.battleship.battleship.entity;

import com.battleship.battleship.enums.FireType;
import lombok.Getter;

@Getter
public class Player {

    String name;

    // since 2 Board , 1-own 2-otherboard
    Board ownBoard;

    Board trackingBoard;

    FireType lastHitType;

    public Player(String name, Board own, Board track)
    {
        this.name = name;
        this.ownBoard =own;
        this.trackingBoard=track;
    }

    // setter for last hit type for HitBased picking strategy
    public void setLastHitType( FireType fireType )
    {
        this.lastHitType = fireType;
    }

}
