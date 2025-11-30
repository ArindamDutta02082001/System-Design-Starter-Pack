package GamesLLD.SnakeLadder;

import GamesLLD.SnakeLadder.entity.Obstacle.LadderObstacle;
import GamesLLD.SnakeLadder.entity.Obstacle.SnakeObstacle;
import GamesLLD.SnakeLadder.entity.Player.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Snake and Ladder Game!");

        // setting actors
        Player p1 = new HumanPlayer(0,"Alice", "Red");
        Player p2 = new HumanPlayer(0,"Blice", "blue");
        Player p3 = new HumanPlayer(0,"Clice", "green");

        /**
         *  you can create snake and ladder game object here and assign to the cellChain
         *  but it is not the way
         *  you have to create a List<Objects> in the manager class only ( has a relationship )
         *  then add players to that list via invoke fn
         */

        // creating some snakes
        SnakeObstacle s1 = new SnakeObstacle(14,7);
        SnakeObstacle s2 = new SnakeObstacle(31,26);
        SnakeObstacle s3 = new SnakeObstacle(78,39);

        // creating the ladders
        LadderObstacle l1 = new LadderObstacle(3,22);
        LadderObstacle l2 = new LadderObstacle(5,8);
        LadderObstacle l3 = new LadderObstacle(20,29);

        Board board = new Board(new ArrayDeque<>(List.of(p1,p2,p3)) ,
                List.of(s1,s2,s3) ,
                List.of(l1,l2,l3)
        );

        // game simulation
        while(!board.isGameOver)
            board.play();








    }
}
