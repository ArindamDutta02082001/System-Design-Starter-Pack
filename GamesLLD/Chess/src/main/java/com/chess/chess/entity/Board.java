package com.chess.chess.entity;

import com.chess.chess.entity.pieces.Piece;
import com.chess.chess.enums.ColorType;
import com.chess.chess.enums.PieceType;

import java.util.*;

import static GamesLLD.Chess.src.main.java.com.chess.chess.util.Constants.BOARD_SIZE;


public class Board {


    // to store the pieces :  coordinate vs Pieces
    public static Map<Coordinate, Piece> cellPieceMap = new HashMap<>();

    // setting a 8x8 board

    Cell[][] matrix = new Cell[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++) {
                matrix[i][j] = new Cell(new Coordinate(i, j));
                cellPieceMap.put(new Coordinate( i,j ), null);
            }

    }


    // utility function
    public void placePiece(int x , int y, Piece piece) {
        cellPieceMap.put(new Coordinate( x,y ), piece);
        matrix[x][y].setPiece(piece);

    }

    // play
    // CORE LOGIC
    public void play(
            Coordinate source,
            Coordinate destination)
    {

        // curr player color
        ColorType playerColor = cellPieceMap.get(source).getColor();

        Cell start =
                matrix[source.getX()][source.getY()];

        Cell end =
                matrix[destination.getX()][destination.getY()];

        Piece piece =
                cellPieceMap.get(source);

        System.out.println(
                "Piece from map = "
                        + piece.getPieceType().name());

        if(piece == null)
        {
            System.out.println(
                    "No piece found in map");
            return;
        }

            // move the piece
            if( piece.getMovementStrategy().move(piece , start, end)) {

                // update board
                // no explicit capture logic if there were any pieces auto null
                    end.setPiece(piece);
                    start.setPiece(null);

                cellPieceMap.remove(source);
                cellPieceMap.put(destination, piece);
            }

        // print board after successful move
        draw();

        if( isKingUnderAttack(playerColor))
        {
            System.out.println(" you are under checkmate !! ");
            return;
        }

    }

    // draw/print board to console
    public void draw() {
        System.out.println("+----+----+----+----+----+----+----+----+");
        for (int i = BOARD_SIZE-1; i >=0;i--) {
            System.out.print("|");
            for (int j = BOARD_SIZE-1; j >=0;j--)  {
                Cell c = matrix[i][j];
                Piece p = c.getPiece();
                String cellRep = "    ";
                if (p != null) {
                    String color = p.getColor() == ColorType.WHITE ? "w" : "b";
                    String pt = p.getPieceType().name().substring(0,1);
                    // use 'P' for pawn, 'K' for king, 'Q' queen, 'B' bishop, 'R' rook, 'N' knight
                    if (p.getPieceType() == PieceType.KNIGHT) pt = "N";
                    cellRep = String.format(" %s%s ", color, pt);
                }
                System.out.print(cellRep + "|");
            }
            System.out.println();
            System.out.println("+----+----+----+----+----+----+----+----+");
        }
    }

    // current king checkmate fn
    boolean isKingUnderAttack(  ColorType currColor)
    {

        Cell currKingPosCell = findKing(currColor);
        Piece kingpiece = currKingPosCell.getPiece();


        // find my kings all possible move position
        List<Coordinate> allKingpossibleCoordinates = kingpiece.getMovementStrategy().getAllPossibleCoordinates( kingpiece , currKingPosCell);

        // find opponents all possible location
        List<Coordinate> allOppCoordinatePossibleCoordinates = getAllOpponentPiecesinCell(currColor);

        for( Coordinate kingPos : allKingpossibleCoordinates )
        {
            if(allOppCoordinatePossibleCoordinates.contains(kingPos))
                return true;

        }
    return false;
    }

    private Cell findKing( ColorType colorType )
    {
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++) {
                if( matrix[i][j].getPiece() != null  && matrix[i][j].getPiece().getPieceType() == PieceType.KING
                        && matrix[i][j].getPiece().getColor() ==colorType )
                    return matrix[i][j];
            }
        return null;
    }

    private List<Coordinate> getAllOpponentPiecesinCell( ColorType colorType )
    {
        List<Coordinate> allOppPossibleCoord = new ArrayList<>();

        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(  matrix[i][j].getPiece() != null && matrix[i][j].getPiece().getColor() != colorType )
                {
                    Cell c = matrix[i][j];
                    Piece p = matrix[i][j].getPiece();
                    for( Coordinate co : p.getMovementStrategy().getAllPossibleCoordinates(p,c))
                        allOppPossibleCoord.add(co);
                }
            }

        return allOppPossibleCoord;


    }



}
