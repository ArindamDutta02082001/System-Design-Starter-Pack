package com.chess.chess.entity.pieces;

import com.chess.chess.enums.ColorType;
import com.chess.chess.enums.PieceType;
import com.chess.chess.strategy.IMovementStrategy;

public class PieceFactory {

    public static Piece createPiece(PieceType pieceType , IMovementStrategy movementStrategy , ColorType colorType)
    {
        Piece p = null;
        switch (pieceType) {
            case PAWN:
                p = new Piece(PieceType.PAWN, colorType, movementStrategy);
                break;
            case BISHOP:
                p = new Piece(PieceType.BISHOP, colorType, movementStrategy);
                break;
            case KING:
                p = new Piece(PieceType.KING, colorType, movementStrategy);
                break;
            case QUEEN:
                p = new Piece(PieceType.QUEEN, colorType, movementStrategy);
                break;
            case KNIGHT:
                p = new Piece(PieceType.KNIGHT, colorType, movementStrategy);
                break;
            case ROOK:
                p = new Piece(PieceType.ROOK, colorType, movementStrategy);
                break;
            default:
                throw new IllegalArgumentException("Unknown piece type: " + pieceType);
        }

        return p;
    }
}
