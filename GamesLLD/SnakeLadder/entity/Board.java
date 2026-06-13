package GamesLLD.SnakeLadder.entity;

import GamesLLD.SnakeLadder.entity.Obstacle.LadderObstacle;
import GamesLLD.SnakeLadder.entity.Obstacle.SnakeObstacle;
import GamesLLD.SnakeLadder.entity.Player.Player;

import java.util.*;

public class Board {

    // this is the central manager class of all the other entities

    // a length of 100 cells
    public Cell[] cellChain = new Cell[101];

    // Dice entity
    Dice dice = new Dice();


    // keeping the list of snakes and ladders
    List<SnakeObstacle> so ;
    List<LadderObstacle> lo ;


    // utility flag
    public boolean isGameOver = false;



    public Board( List<SnakeObstacle> so , List<LadderObstacle> lo )
    {
        this.so = so;
        this.lo = lo;
        initializeBoard();
    }


    public void initializeBoard()
    {
        for( int i=0;i<=100;i++)
        {
            cellChain[i] = new Cell(i);
        }

        // placing the ladders and the snakes
        for(SnakeObstacle s : so )
        {
            cellChain[s.start].obstacle = s;
        }

        for(LadderObstacle l : lo )
        {
            cellChain[l.start].obstacle = l;
        }
    }



    // play logic
    public void makeMove( Player player )
    {

        int diceValue = dice.rollDice();
        int currentPos = player.position;


        // if there is obstacle at the new position
        int newpos = player.position + diceValue;

        if(newpos > 100)
        {
            System.out.println(" Player( curr pos )" + player._name +"("+currentPos+") rolled a " + diceValue +" Try next time ! " );
            return;
        }

        if( cellChain[newpos].obstacle != null )
        {
            player.position = cellChain[newpos].obstacle.end;
            return;
        }

        // if there is no obstacle
        if( newpos < 100 )
        {
            player.position = newpos;
            System.out.println(" Player( curr pos )" + player._name +"("+currentPos+") rolled a " + diceValue +" and moved to new position " + newpos );
        }
        else
        {
            isGameOver = true;
            System.out.println(" Player " + player._name + " has won the game !! ");
        }

    }



}
