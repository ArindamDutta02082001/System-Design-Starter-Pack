package com.chess.chess.strategy;

import com.chess.chess.entity.Cell;
import com.chess.chess.entity.Coordinate;
import com.chess.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static GamesLLD.Chess.src.main.java.com.chess.chess.util.Constants.BOARD_SIZE;

public class BishopMovement implements IMovementStrategy{

    @Override
    public boolean move(Piece piece, Cell start, Cell end) {

        // first check is move possible
        if(!canMove(start,end))
            return false;

        // rook movement logic

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

        int dir[][] = {{-1,-1},{1,1},{-1,1},{1,-1}};

        List<Coordinate> possible = new ArrayList<>();

        int startX = start.getCoordinate().getX();
        int startY = start.getCoordinate().getY();

        for( int factor = 1; factor<BOARD_SIZE;factor++)
        for( int d[] : dir)
        {
            int newX = startX+(d[0] * factor);
            int newY = startY+(d[1] * factor);

            Coordinate newCordinate = new Coordinate(newX , newY );

            if(isWithinBoard( newCordinate ) && !isSameColorPieceExisting(piece,newCordinate))
                possible.add(newCordinate);
            else
                break;
        }

        return possible;
    }


}
