package GamesLLD.TicTacToe;

import GamesLLD.TicTacToe.entity.Cell;
import GamesLLD.TicTacToe.entity.Player.Player;
import GamesLLD.TicTacToe.observer.publisher.ScoreBoardPublisher;
import GamesLLD.TicTacToe.strategy.*;

import java.util.*;

public class Board {

    // will be the manager class for all other entities

    public int size;
    public Cell[][] matrix;

    Player p1;
    Player p2;

    // keeping all the winning strategies
    List<WinningStrategy> winningStrategies;

    // for the observer pattern
    ScoreBoardPublisher scoreBoardPublisher;

    // small enhancement I have done after the main thing is complete
    public int countMoves;  // to keep track of number of moves made
    public boolean isGameOver = false; // to keep track if game is over or not

    public Board(Player p1 , Player p2 , int size)
    {
        this.size = size;
        this.matrix = new Cell[size][size];
        this.p1 = p1;
        this.p2 = p2;

        winningStrategies = new ArrayList<>();
        scoreBoardPublisher = new ScoreBoardPublisher();

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());
        winningStrategies.add(new RevDiagonalWinningStrategy());
    }

    // initialize the board
    public void initializeBoard()
    {
        for( int i=0;i<size;i++)
        {
            for( int j=0;j<size;j++)
            {
                Cell cell = new Cell();
                cell.x = i;
                cell.y = j;
                cell.value = "*"; // empty cell
                matrix[i][j] = cell;
            }
        }

        // req in auto lpay
//        // initialize player queue
//        playerQueue = new ArrayDeque<>();
//        playerQueue.addLast(p1);
//        playerQueue.addLast(p2);
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
        checkWinner( this , p);
    }

    public void checkWinner(Board board , Player p)
    {
        for( WinningStrategy w : winningStrategies)
        {
            if( w.checkWin( board , p))
            {
                // System.out.println(" Player " + p.name + " has won the game !! ");
                // we will use observer pattern to notify the win
                scoreBoardPublisher.notifySubscribers(" Player " + p.name + " has won the game !! ");
                isGameOver = true;
                return;
            }
        }

        if( isDraw() )
        {
            // System.out.println(" The game is a Draw !! ");
            scoreBoardPublisher.notifySubscribers(" The game is a Draw !! ");
            isGameOver = true;
            return;
        }
    }

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

    public boolean isDraw()
    {
        return countMoves == size * size;
    }




    // ============= THE BELOW FN IS USED IN AUTOMATED PC PLAY =============

    Deque<Player>playerQueue;
    Player currentPlayer;

    public void makeMoveAuto( int x , int y)
    {
        if( isGameOver )
        {
            System.out.println(" Game is already over !! No more moves can be made ");
            return;
        }

        // taking out the top player from queue
        Player p = playerQueue.poll();

        // do the stuffs
        if( !matrix[x][y].value.equals("*") )
        {
            System.out.println(" Cell is already occupied !! ");
            return;
        }
        matrix[x][y].value = p.symbol;
        countMoves++;

        printBoard();
        checkWinner( this , p);

        // put the player back to queue
        playerQueue.addLast(p);
        this.currentPlayer = playerQueue.peek();
    }




}
