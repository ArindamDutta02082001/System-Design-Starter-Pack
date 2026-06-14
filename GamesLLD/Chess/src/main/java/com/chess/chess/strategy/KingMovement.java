package com.chess.chess.strategy;

import com.chess.chess.entity.Cell;
import com.chess.chess.entity.Coordinate;
import com.chess.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class KingMovement implements IMovementStrategy{

    @Override
    public boolean move(Piece piece, Cell start, Cell end) {

        // first check is move possible
        if(!canMove(start,end))
            return false;

        // king movement logic

        for( Coordinate coordinate : getAllPossibleCoordinates(piece,start))
        {
            if( coordinate.getX() == end.getCoordinate().getX() && coordinate.getY() == end.getCoordinate().getY())
            {
                return  true;
            }
        }

        return false;

    }

    @Override
    public List<Coordinate> getAllPossibleCoordinates( Piece piece , Cell start) {

        int dir[][] = {{-1,0},{1,0},{0,1},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};

        List<Coordinate> possible = new ArrayList<>();

        int startX = start.getCoordinate().getX();
        int startY = start.getCoordinate().getY();

        for( int d[] : dir)
        {
            int newX = startX+d[0];
            int newY = startY+d[1];

            Coordinate newCordinate = new Coordinate(newX , newY );

            if(isWithinBoard( newCordinate ) && !isSameColorPieceExisting(piece,newCordinate))
                possible.add(newCordinate);
        }

        return possible;
    }


}
