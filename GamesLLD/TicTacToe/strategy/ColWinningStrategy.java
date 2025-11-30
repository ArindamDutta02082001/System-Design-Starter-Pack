package GamesLLD.TicTacToe.strategy;

import GamesLLD.TicTacToe.Board;
import GamesLLD.TicTacToe.entity.Player.Player;

public class ColWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Board board , Player p) {

        int size = board.size;

        for( int i=0;i<size;i++)
        {
            int ss = 0;
            for(int j=0;j<size;j++)
            {
                if(board.matrix[j][i].value.equals(p.symbol) )
                    ss++;
            }
            if( ss == size)
                return true;
        }

        return false;
    }
}
