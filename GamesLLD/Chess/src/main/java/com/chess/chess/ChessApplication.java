package com.chess.chess;

import com.chess.chess.entity.Board;
import com.chess.chess.entity.Coordinate;
import com.chess.chess.entity.pieces.Piece;
import com.chess.chess.entity.pieces.PieceFactory;
import com.chess.chess.enums.ColorType;
import com.chess.chess.enums.PieceType;
import com.chess.chess.strategy.*;

import java.util.Scanner;

public class ChessApplication {

    public static void main(String[] args) {

        // actors

        // movememnt strategies

        IMovementStrategy bishopMove = new BishopMovement();
        IMovementStrategy knightMovement = new KnightMovement();
        IMovementStrategy kingMovement = new KingMovement();
        IMovementStrategy queenMovement = new QueenMovement();
        IMovementStrategy rookMovement = new RookMovement();
        IMovementStrategy pawnMovement = new PawnMovement();


        //WHITE
        // pieces
        Piece WB1 = PieceFactory.createPiece( PieceType.BISHOP , bishopMove , ColorType.WHITE);
        Piece WB2 = PieceFactory.createPiece( PieceType.BISHOP , bishopMove , ColorType.WHITE);
        Piece WK = PieceFactory.createPiece( PieceType.KING , kingMovement , ColorType.WHITE);
        Piece WQ = PieceFactory.createPiece( PieceType.QUEEN , queenMovement , ColorType.WHITE);
        Piece WKt1 = PieceFactory.createPiece( PieceType.KNIGHT , knightMovement , ColorType.WHITE);
        Piece WKt2 = PieceFactory.createPiece( PieceType.KNIGHT , knightMovement , ColorType.WHITE);
        Piece WR1 = PieceFactory.createPiece( PieceType.ROOK , rookMovement , ColorType.WHITE);
        Piece WR2 = PieceFactory.createPiece( PieceType.ROOK , rookMovement , ColorType.WHITE);

        // 8 white pawns
        Piece WP1 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP2 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP3 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP4 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP5 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP6 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP7 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);
        Piece WP8 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.WHITE);


        // BLACK
        // pieces
        Piece BB1 = PieceFactory.createPiece( PieceType.BISHOP , bishopMove , ColorType.BLACK);
        Piece BB2 = PieceFactory.createPiece( PieceType.BISHOP , bishopMove , ColorType.BLACK);
        Piece BK = PieceFactory.createPiece( PieceType.KING , kingMovement , ColorType.BLACK);
        Piece BQ = PieceFactory.createPiece( PieceType.QUEEN , queenMovement , ColorType.BLACK);
        Piece BKt1 = PieceFactory.createPiece( PieceType.KNIGHT , knightMovement , ColorType.BLACK);
        Piece BKt2 = PieceFactory.createPiece( PieceType.KNIGHT , knightMovement , ColorType.BLACK);
        Piece BR1 = PieceFactory.createPiece( PieceType.ROOK , rookMovement , ColorType.BLACK);
        Piece BR2 = PieceFactory.createPiece( PieceType.ROOK , rookMovement , ColorType.BLACK);

        // 8 white pawns
        Piece BP1 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP2 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP3 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP4 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP5 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP6 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP7 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);
        Piece BP8 = PieceFactory.createPiece(PieceType.PAWN, pawnMovement, ColorType.BLACK);


        Board board = new Board();

        // rooks
        board.placePiece(0,0,WR1);
        board.placePiece(0,7,WR2);
        board.placePiece(7,7,BR1);
        board.placePiece(7,0,BR2);

        // knght
        board.placePiece(0,1,WKt1);
        board.placePiece(0,6,WKt2);
        board.placePiece(7,1,BKt1);
        board.placePiece(7,6,BKt2);

        // bishop
        board.placePiece(0,2,WB1);
        board.placePiece(0,5,WB2);
        board.placePiece(7,2,BB1);
        board.placePiece(7,5,BB2);

        // kings n queen
        board.placePiece(0,3,WK);
        board.placePiece(0,4,WQ);
        board.placePiece(7,3,BK);
        board.placePiece(7,4,BQ);

        // white pawns
        board.placePiece(1,0,WP1);
        board.placePiece(1,1,WP2);
        board.placePiece(1,2,WP3);
        board.placePiece(1,3,WP4);
        board.placePiece(1,4,WP5);
        board.placePiece(1,5,WP6);
        board.placePiece(1,6,WP7);
        board.placePiece(1,7,WP8);

        // black pawns
        board.placePiece(6,0,BP1);
        board.placePiece(6,1,BP2);
        board.placePiece(6,2,BP3);
        board.placePiece(6,3,BP4);
        board.placePiece(6,4,BP5);
        board.placePiece(6,5,BP6);
        board.placePiece(6,6,BP7);
        board.placePiece(6,7,BP8);

        //actiosn


        Scanner sc = new Scanner(System.in);

        while(true) {

            int sx = sc.nextInt();
            int sy = sc.nextInt();

            int dx = sc.nextInt();
            int dy = sc.nextInt();

            board.play(
                    new Coordinate(sx,sy),
                    new Coordinate(dx,dy)
            );
        }
    }

}
