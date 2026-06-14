package com.chess.chess.entity;

import com.chess.chess.entity.pieces.Piece;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {

        Coordinate coordinate;

        Piece piece;

        Cell( Coordinate coordinate)
        {
            this.coordinate =coordinate;
        }



        // overwriting the .equals : same cooridnate means same cell

        @Override
        public boolean equals(Object o)
        {
            Cell cell = (Cell)o;
           if (this.getCoordinate().getX() == cell.getCoordinate().getX() &&
                   this.getCoordinate().getY() == cell.getCoordinate().getY())
               return true;
           return false;
        }

}
