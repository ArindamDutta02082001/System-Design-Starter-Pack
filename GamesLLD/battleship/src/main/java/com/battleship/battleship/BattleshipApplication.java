package com.battleship.battleship;


import com.battleship.battleship.entity.Board;
import com.battleship.battleship.entity.Coordinates;
import com.battleship.battleship.entity.Player;
import com.battleship.battleship.entity.Ship;
import com.battleship.battleship.enums.FireType;
import com.battleship.battleship.enums.ShipDirection;
import com.battleship.battleship.enums.ShipTypeEnum;
import com.battleship.battleship.strategy.pickingStrategy.IPlayerPickingStrategy;
import com.battleship.battleship.strategy.pickingStrategy.impl.HitBased;
import com.battleship.battleship.strategy.pickingStrategy.impl.RoundRobin;

import com.battleship.battleship.command.FireCommand;
import com.battleship.battleship.command.GameCommandHistory;
import java.util.*;

public class BattleshipApplication {

    public static void main(String[] args) {

        // actors

        final int MAX_SHIP_PER_BOARD = 5;

        // ships for p1board
        Ship s1 = new Ship(new Coordinates(0,1), ShipTypeEnum.BATTLESHIP, ShipDirection.HORIZONTAL );
        Ship s2 = new Ship(new Coordinates(1,1), ShipTypeEnum.CARRIER, ShipDirection.VERTICAL );
        Ship s3 = new Ship(new Coordinates(3,4), ShipTypeEnum.DESTROYER, ShipDirection.HORIZONTAL );
        Ship s4 = new Ship(new Coordinates(4,5), ShipTypeEnum.SUBMARINE, ShipDirection.HORIZONTAL );
//        Ship s5 = new Ship(10,1, ShipTypeEnum.CRUISER, ShipDirection.HORIZONTAL );

        List<Ship> shipListP1board = new ArrayList<>();
        shipListP1board.add(s1);
        shipListP1board.add(s2);
        shipListP1board.add(s3);
        shipListP1board.add(s4);
//        shipListP1board.add(s5);

        // for nw keeping the same points in board for p2 also
        Ship s11 = new Ship(new Coordinates(0,1), ShipTypeEnum.BATTLESHIP, ShipDirection.HORIZONTAL );
        Ship s12 = new Ship(new Coordinates(1,1), ShipTypeEnum.CARRIER, ShipDirection.VERTICAL );
        Ship s13 = new Ship(new Coordinates(3,4), ShipTypeEnum.DESTROYER, ShipDirection.HORIZONTAL );
        Ship s14 = new Ship(new Coordinates(4,5), ShipTypeEnum.SUBMARINE, ShipDirection.HORIZONTAL );
//        Ship s15 = new Ship(10,1, ShipTypeEnum.CRUISER, ShipDirection.HORIZONTAL );

        List<Ship> shipListP2board = new ArrayList<>();
        shipListP2board.add(s11);
        shipListP2board.add(s12);
        shipListP2board.add(s13);
        shipListP2board.add(s14);
//        shipListP2board.add(s15);

        // boards
        Board p1board = new Board();
        p1board.placeShips(shipListP1board);

        Board p2board = new Board();
        p2board.placeShips(shipListP2board);

        // players  p1 vs p2
        // p1 - p1board own
        // p2 - p2board own

        Player p1 = new Player("Arindam" , p1board , p2board );
        Player p2 = new Player("Rahul" , p2board , p1board );


        // actions

        // section to create player turns

        /**

        when we need to use this code when we want a player after player chance
        Deque<Player> playerList = new ArrayDeque<>();
        playerList.addLast(p1);
        playerList.addLast(p2);

         currplayer pop ->
         play logic
         playerList.addLast(currplayer);

         */

        // player picking strategy
        List<Player> playerList = new ArrayList<>();
        playerList.add(p1);
        playerList.add(p2);

        IPlayerPickingStrategy pickingStrategy = new HitBased();

        GameCommandHistory history = new GameCommandHistory();

        while( true )
         {
             Player currPlayer = pickingStrategy.getNextPlayer(playerList);
             System.out.println("\n--- " + currPlayer.getName() + "'s turn ---");


             int x = (int) (Math.random() * 10);
             int y = (int) (Math.random() * 10);

             // execute command
             FireCommand cmd = new FireCommand(currPlayer, x, y);
             history.executeCommand(cmd);

             FireType result = cmd.getFireResult();
             System.out.println("Shot at [" + x + ", " + y + "]: " + result);

            // setting the last hit type of the current player
            currPlayer.setLastHitType(result);


             // TODO : you can plugin the winning strategy
             // TODO : in the winning strategy you can send the board nad then count 3 , 5 ship to win
             // TODO : or you can pass the objects needed for winner calc

             // after firing check if all the ships in the board are sunken
             if(currPlayer.getTrackingBoard().checkAllShipsSunkOrNot()) {
                 System.out.println("\n🎉 Player : " + currPlayer.getName() + " WINS! 🎉");

             break;

             }
        }


    }

}
