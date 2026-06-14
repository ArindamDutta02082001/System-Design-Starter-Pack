package com.chess.chess.entity.pieces;

import com.chess.chess.enums.ColorType;
import com.chess.chess.enums.PieceType;
import com.chess.chess.strategy.IMovementStrategy;
import lombok.Getter;

@Getter
public class Piece {

    PieceType pieceType;

    ColorType color;

    IMovementStrategy movementStrategy;

    boolean isFirstMove = true;

    Piece( PieceType pieceType , ColorType color , IMovementStrategy movementStrategy)
    {
        this.pieceType = pieceType;
        this.color=color;
        this.movementStrategy=movementStrategy;
    }

    // set is first move to false;
    public void setFirstMoveTofalse()
    { this.isFirstMove = false;}




}
