package GamesLLD.TicTacToe;

import GamesLLD.TicTacToe.entity.Computer;
import GamesLLD.TicTacToe.entity.HumanPlayer;
import GamesLLD.TicTacToe.entity.Player;
import GamesLLD.TicTacToe.observer.subsciber.ScoreBoardSubs;

import java.util.Scanner;

class Main
{
    public static void main(String args[])
    {
        System.out.println(" Hello Tic Tac Toe Game !! ");

        // setting up the actors

        Player p1 = new HumanPlayer("Alice", "X");
        Player p2 = new HumanPlayer("Bob", "O");

        Board board = new Board( p1 , p2 , 3);
        board.initializeBoard();

        board.scoreBoardPublisher.add( new ScoreBoardSubs());

        // actions

        // press 1 for demo , 2 for interactive play
        int demoOrInteractive = 1;
        Scanner sc = new Scanner(System.in);
        demoOrInteractive = sc.nextInt();

        if(demoOrInteractive == 1) {

            // scenario 1 Alice wins
            board.makeMove(p1, 0, 0);
            board.makeMove(p2, 0, 1);
            board.makeMove(p1, 1, 1);
            board.makeMove(p2, 2, 0);
            board.makeMove(p1, 2, 2);
            board.makeMove(p2, 0, 2);  // invalid move

            // scenario 2 Bob wins
            board.initializeBoard();
            board.isGameOver = false;
            board.countMoves = 0;

            board.makeMove(p1, 0, 0);
            board.makeMove(p2, 0, 1);
            board.makeMove(p1, 0, 2);
            board.makeMove(p2, 1, 1);
            board.makeMove(p1, 1, 0);
            board.makeMove(p2, 2, 1);
            board.makeMove(p1, 2, 2);

            // scenario 3 Draw
            board.initializeBoard();
            board.isGameOver = false;
            board.countMoves = 0;

            board.makeMove(p1, 0, 0);
            board.makeMove(p2, 0, 1);
            board.makeMove(p1, 0, 2);
            board.makeMove(p2, 1, 1);
            board.makeMove(p1, 1, 0);
            board.makeMove(p2, 2, 0);
            board.makeMove(p1, 2, 1);
            board.makeMove(p2, 2, 2);
            board.makeMove(p1, 1, 2);

        }
        else
        {
            // real game play
                System.out.println("Enter you name & symbol X or 0 ");
                String name1 = sc.next();
                String symbol1 = sc.next();

                Player human = new HumanPlayer( name1 , symbol1 );
                Computer p1c = new Computer("PC" , symbol1.equals("X") ? "O" : "X" );

                board.playerQueue.add(human);
                board.playerQueue.add(p1c);

                // always human plays first
                board.currentPlayer = human;

            while( !board.isGameOver)
            {
                System.out.println(board.currentPlayer.name + "'s turn. Enter your move (row and column): ");
                int x = sc.nextInt();
                int y = sc.nextInt();
                board.makeMoveAuto( x , y);

                if( !board.isGameOver)
                {
                    int ComuterMove[] = Computer.getMove(board);
                    int cx = ComuterMove[0];
                    int cy = ComuterMove[1];
                    System.out.println(p1c.name+"'s turn. row :"+cx+" column :"+cy);
                    board.makeMoveAuto( cx , cy);
                }
            }

        }

    }
}
