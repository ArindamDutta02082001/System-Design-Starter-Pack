package com.chess.chess.strategy;

import com.chess.chess.entity.Cell;
import com.chess.chess.entity.Coordinate;
import com.chess.chess.entity.pieces.Piece;
import com.chess.chess.entity.Board;
import com.chess.chess.enums.ColorType;

import java.util.ArrayList;
import java.util.List;

public class PawnMovement implements IMovementStrategy{

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

        piece.setFirstMoveTofalse();

        return false;

    }

    @Override
    public List<Coordinate> getAllPossibleCoordinates( Piece piece , Cell start) {

        // we assume that WHITE moves upward and BLACK down
      int direction =
        piece.getColor() == ColorType.WHITE
                ? 1
                : -1;

        List<Coordinate> possible = new ArrayList<>();

        int startX = start.getCoordinate().getX();
        int startY = start.getCoordinate().getY();

        // 1 front
        Coordinate oneStep =
                new Coordinate(
                        startX + direction,
                        startY
                );


        if(isWithinBoard( oneStep ) && isSameColorPieceExisting(piece,oneStep))
            possible.add(oneStep);

        // 2 front
        Coordinate twoStep =
                new Coordinate(
                        startX + 2 * direction,
                        startY
                );
        if(isWithinBoard( twoStep ) && isSameColorPieceExisting(piece,twoStep) && piece.isFirstMove() )
            possible.add(twoStep);


        // one diagonal
        Coordinate rightDiag =
                new Coordinate(
                        startX + direction,
                        startY + 1
                );
        if(isWithinBoard( rightDiag ) && isSameColorPieceExisting(piece,rightDiag) && isOpponentPieceExist( piece , rightDiag) )
            possible.add(rightDiag);

        Coordinate leftDiag =
                new Coordinate(
                        startX + direction,
                        startY - 1
                );
        if(isWithinBoard( leftDiag ) && isSameColorPieceExisting(piece,leftDiag) && isOpponentPieceExist( piece , leftDiag) )
            possible.add(leftDiag);


        return possible;
    }

    // private helper
    boolean isOpponentPieceExist( Piece piece , Coordinate coordinate)
    {

        Piece diagPiece  = Board.cellPieceMap.get( coordinate );
        if( diagPiece != null && piece.getColor() != diagPiece.getColor() )
            return true;
        return false;
    }


}
