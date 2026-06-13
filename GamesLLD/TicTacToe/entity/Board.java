package GamesLLD.TicTacToe.entity;

import GamesLLD.TicTacToe.entity.Player.Player;
import GamesLLD.TicTacToe.observer.publisher.IPublisher;
import GamesLLD.TicTacToe.observer.subsciber.ISubscriber;
import GamesLLD.TicTacToe.strategy.*;

import java.util.*;

public class Board implements IPublisher {

    // will be the manager class for all other entities

    public int size;
    public Cell[][] matrix;

    // keeping all the winning strategies
    List<IWinningStrategy> winningStrategies;


    // small enhancement I have done after the main thing is complete
    public int countMoves;  // to keep track of number of moves made
    public boolean isGameOver = false; // to keep track if game is over or not

    public Board(int size , List<IWinningStrategy> winningStrategies)
    {
        this.size = size;
        this.matrix = new Cell[size][size];

        this.winningStrategies = winningStrategies;
    }

    // initialize the board
    public void initializeBoard()
    {
        for( int i=0;i<size;i++)
        {
            for( int j=0;j<size;j++)
            {
                Cell cell = new Cell();
                cell.setCoordinates(new Coordinates(i, j));
                cell.setValue("*"); // empty cell
                matrix[i][j] = cell;
            }
        }
    }

    public void makeMove( Player p , int x , int y)
    {
        if( isGameOver )
        {
            System.out.println(" Game is already over !! No more moves can be made ");
            return;
        }

        if( !matrix[x][y].value.equals("*") )
        {
            System.out.println(" Cell is already occupied !! ");
            return;
        }
        matrix[x][y].value = p.symbol;
        countMoves++;

        printBoard();
    }

    public void checkWinner(Board board , Player p)
    {
        for( IWinningStrategy w : winningStrategies)
        {
            if( w.checkWin( board , p))
            {
                // System.out.println(" Player " + p.name + " has won the game !! ");
                // we will use observer pattern to notify the win
                update(" Player " + p.name + " has won the game !! ");
                isGameOver = true;
                return;
            }
        }

        if( isDraw() )
        {
            // System.out.println(" The game is a Draw !! ");
            update(" The game is a Draw !! ");
            isGameOver = true;
        }
    }

    public boolean isDraw()
    {
        return countMoves == size * size;
    }

    // extra functions : not required , generally not asked in LLDs
    public void printBoard()
    {
        for( int i=size-1;i>=0;i--)
        {
            System.out.print(" | ");
            for( int j=0;j<size;j++)
            {
                System.out.print( matrix[i][j].value + " | ");
            }
            System.out.println();
        }
            System.out.println(" ========================================== ");
    }


    // implement observer pattern

    List<ISubscriber> subscribers = new ArrayList<>();

    @Override
    public void register( ISubscriber subscriber ) {
        subscribers.add(subscriber);
    }

    @Override
    public void deregister(ISubscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void update( String message) {
        for( ISubscriber s : subscribers )
        {
            s.notifyy(message);
        }
    }




}
