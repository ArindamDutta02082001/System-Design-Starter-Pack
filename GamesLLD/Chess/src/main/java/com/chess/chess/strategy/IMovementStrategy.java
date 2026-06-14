package com.chess.chess.strategy;

import com.chess.chess.entity.Board;
import com.chess.chess.entity.Cell;
import com.chess.chess.entity.Coordinate;
import com.chess.chess.entity.pieces.Piece;

import java.util.List;

import static GamesLLD.Chess.src.main.java.com.chess.chess.util.Constants.BOARD_SIZE;


public interface IMovementStrategy {

    // move function from start to end
    boolean move(Piece piece , Cell start , Cell end);

    List<Coordinate> getAllPossibleCoordinates( Piece piece , Cell start );


    default boolean canMove( Cell start , Cell end )
    {
        if( start.equals(end))
            return false;

        if(end.getPiece() != null && end.getPiece().getColor() == start.getPiece().getColor())
            return false;

        return true;
    }


    default boolean isWithinBoard( Coordinate coordinate )
    {

        if( coordinate.getX() >= BOARD_SIZE || coordinate.getY() >= BOARD_SIZE)
            return false;

        return true;

    }

    default boolean isSameColorPieceExisting( Piece piece , Coordinate coordinate )
    {
        Piece cellPiece = Board.cellPieceMap.get(coordinate);

        if( cellPiece != null && cellPiece.getColor() == piece.getColor())
            return false;

        return true;

    }
}
