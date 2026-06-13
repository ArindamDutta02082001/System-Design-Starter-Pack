package GamesLLD.TicTacToe;

import GamesLLD.TicTacToe.entity.Board;
import GamesLLD.TicTacToe.entity.Player.Computer;
import GamesLLD.TicTacToe.entity.Player.HumanPlayer;
import GamesLLD.TicTacToe.entity.Player.Player;
import GamesLLD.TicTacToe.observer.subsciber.ISubscriber;
import GamesLLD.TicTacToe.observer.subsciber.ScoreBoard;
import GamesLLD.TicTacToe.strategy.*;

import java.util.*;

class Main
{
    public static void main(String args[])
    {
        System.out.println(" Hello Tic Tac Toe Game !! ");

        // setting up the actors

        System.out.println("Enter you name & symbol X or 0 ");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.next();
        String symbol1 = sc.next();

        // player 1 : human
        Player human = new HumanPlayer( name1 , symbol1 );

        // player 2 : bot
        Player p1c = new Computer("PC" , symbol1.equals("X") ? "O" : "X" );


        // by default round-robin
        Deque<Player> dq = new ArrayDeque<>();
        dq.add(human);
        dq.add(p1c);


        // keeping all the winning strategies
        List<IWinningStrategy> winningStrategies = new ArrayList<>();;

        winningStrategies.add(new RowWinningStrategy());
        winningStrategies.add(new ColWinningStrategy());
        winningStrategies.add(new DiagonalWinningStrategy());
        winningStrategies.add(new RevDiagonalWinningStrategy());

        // here a single board is shared among all players
        Board board = new Board( 3 , winningStrategies);
        board.initializeBoard();


        // add subscribers
        ISubscriber subscriber1 = new ScoreBoard();
        board.register(subscriber1);

        // actions : game play

            while( true )
            {
                Player currentPlayer = dq.poll();

                // play
                if( currentPlayer.name.equals("PC"))
                {
                    int ComuterMove[] = Computer.getMove(board);
                    int cx = ComuterMove[0];
                    int cy = ComuterMove[1];
                    board.update(p1c.name+"'s turn. row :"+cx+" column :"+cy);
                    board.makeMove( currentPlayer , cx , cy);
                }
                else
                {
                    board.update(currentPlayer.name + "'s turn. Enter your move (row and column): ");
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    board.makeMove( currentPlayer , x , y);
                }
                // check for the winner
                board.checkWinner(board,currentPlayer);

                dq.addLast(currentPlayer);
            }

        }

}
