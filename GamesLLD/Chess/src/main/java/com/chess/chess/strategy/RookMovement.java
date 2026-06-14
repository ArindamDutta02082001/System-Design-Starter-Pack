package com.chess.chess.strategy;

import com.chess.chess.entity.Cell;
import com.chess.chess.entity.Coordinate;
import com.chess.chess.entity.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static GamesLLD.Chess.src.main.java.com.chess.chess.util.Constants.BOARD_SIZE;


public class RookMovement implements IMovementStrategy{

    @Override
    public boolean move(Piece piece, Cell start, Cell end) {

        // first check is move possible
        if(!canMove(start,end))
            return false;

        // rook movement logic

        for( Coordinate coordinate : getAllPossibleCoordinates(piece , start))
        {
            if( coordinate.getX() == end.getCoordinate().getX() && coordinate.getY() == end.getCoordinate().getY())
            {
                return  true;
            }
        }

        return false;

    }

    @Override
    public List<Coordinate> getAllPossibleCoordinates( Piece piece ,  Cell start) {

        List<Coordinate> possible = new ArrayList<>();

        int startX = start.getCoordinate().getX();
        int startY = start.getCoordinate().getY();


        // horizontally
        for(int i = startX+1 ; i<startX+BOARD_SIZE; i++)
        {
            Coordinate coordinate = new Coordinate( i , startY);
            if( isWithinBoard( coordinate ) && !isSameColorPieceExisting(piece,coordinate))
                possible.add( coordinate);


        }

        // vertically
        for(int j = startY+1 ; j<startY+BOARD_SIZE; j++)
        {
            Coordinate coordinate = new Coordinate( startX , j);
            if( isWithinBoard( coordinate ) && !isSameColorPieceExisting(piece,coordinate) )
                possible.add( coordinate);


        }
        return possible;
    }


}
