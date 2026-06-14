package com.chess.chess.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Coordinate {
    private final int x;
    private final int y;


    // overriding .equals and hash
    @Override
    public boolean equals( Object object )
    {
        Coordinate coordinate = (Coordinate) object;
        if( coordinate.getX() == this.getX() && coordinate.getY() == this.getY() )
            return true;
        return false;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(this.getX() , this.getY());
    }

}
