package GamesLLD.SnakeLadder;

import GamesLLD.SnakeLadder.entity.Cell;
import GamesLLD.SnakeLadder.entity.Dice;
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

    // lIst of players can be maintained here too
    Deque<Player> players = new ArrayDeque<>();


    // keeping the list of snakes and ladders
    List<SnakeObstacle> so = new ArrayList<>();
    List<LadderObstacle> lo = new ArrayList<>();


    // utility flag
    public boolean isGameOver = false;



    public Board(Deque<Player>players , List<SnakeObstacle> so , List<LadderObstacle> lo )
    {
        this.players = players;
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

    // making a play() to automatic give chance to all the players

    public void play()
    {

        if( isGameOver )
        {
            System.out.println("Game Over");
            return;
        }

        // nikalo
        Player p = players.poll();

        // do something
        makeMove(p);

        // put back
        players.add(p);
    }



}
