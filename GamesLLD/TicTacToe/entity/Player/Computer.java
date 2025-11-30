package GamesLLD.TicTacToe.entity.Player;

import GamesLLD.TicTacToe.Board;

import java.util.Random;

public class Computer  extends Player {
    
//    public String name = "Computer";
//    public String symbol;
    
//    public Computer(String name , String symbol) {
//        this.name = name;
//        this.symbol = symbol;
//    }
    public Computer(String name , String symbol) {
       super(name, symbol);
    }


    public static int[] getMove(Board board) {
        Random random = new Random();
        int size = board.size;

        while (true) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (board.matrix[x][y].value.equals("*")) {
                return new int[]{x, y};
            }
        }
    }


}
