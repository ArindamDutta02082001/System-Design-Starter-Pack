package com.battleship.battleship.entity;

import com.battleship.battleship.enums.FireType;
import com.battleship.battleship.enums.ShipDirection;

import java.util.List;

public class Board {


    public int SIZE = 10;
    // creating a size x size board

    Cell[][] matrix = new Cell[SIZE][SIZE];

    List<Ship> shipList;

    public Board()
    {
      for( int i=0;i<SIZE;i++)
          for( int j=0;j<SIZE;j++ )
            matrix[i][j] = new Cell(new Coordinates(i,j));
    }


    // place ships
    public void placeShips( List<Ship> ships )
    {
        // storing the ships in this board for later usage
        this.shipList = ships;

        for( Ship s : ships )
        {
            // horizontal ship
            if(s.getDirection() == ShipDirection.HORIZONTAL )
            {
                int startX = s.startCoordinates.getX();
                int startY = s.startCoordinates.getY();
                
                // small check if ship will fit the board
                if(startY+s.getTypeEnum().getLength() >= SIZE)
                    System.out.println("Ship "+s.typeEnum+" will not fit "+ShipDirection.HORIZONTAL.name());

                for( int i=0;i<s.getTypeEnum().getLength();i++)
                {
                    // setting ship for each cell
                    // vertical x constant
                    matrix[startX][startY+i].setShip(s);
                }

                System.out.println("Ship "+s.typeEnum+" inserted");

            }
            else
            {
                int startX = s.startCoordinates.getX();
                int startY = s.startCoordinates.getY();

                // small check if ship will fit the board
                if(startX+s.getTypeEnum().getLength() >= SIZE)
                    System.out.println("Ship "+s.typeEnum+" will not fit "+ ShipDirection.VERTICAL.name());

                for( int i=0;i<s.getTypeEnum().getLength();i++)
                {
                    // setting ship for each cell
                    // vertical y constant
                    matrix[startX+i][startY].setShip(s);
                }
            }

        }

    }


    // check all ships sunk in the board or not
    public boolean checkAllShipsSunkOrNot()
    {
        for( Ship s : shipList )
        {
            if( s.isSunk() == false )
                return false;
        }

        return true;

    }


    // to register a shot in this board from a player
    // CORE LOGIC
    public FireType fire(int x , int y )
    {
        //  case 1 : already fired
        if (matrix[x][y].isFired())
            return FireType.ALREADY_FIRED;

        // case 2 : not fires - again 2 case has ship or not
        // register fire
        matrix[x][y].fire();

        // case 2.1 : has no ship
        if( matrix[x][y].getShip() == null )
        {
            return FireType.MISS;
        }
        // case 2.2 : has ship
        matrix[x][y].getShip().registerHit();  // Mark the ship : this ship is hit

        return FireType.HIT;
    }



    public void unfire(int x , int y )
    {
        //  case 1 : already fired
        if (!matrix[x][y].isFired())
            return ;

        // case 2 : not fires - again 2 case has ship or not
        // register fire
        matrix[x][y].unFire();;

        // case 2.1 : has no ship
        if( matrix[x][y].getShip() == null )
        {
            return;
        }
        // case 2.2 : has ship
        matrix[x][y].getShip().unregisterHit();  // Mark the ship : this ship is hit

    }



}
