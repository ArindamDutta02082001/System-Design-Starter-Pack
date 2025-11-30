package GamesLLD.TicTacToe.strategy;

import GamesLLD.TicTacToe.Board;
import GamesLLD.TicTacToe.entity.Player.Player;

public class RevDiagonalWinningStrategy implements WinningStrategy {

    @Override
    public boolean checkWin(Board board , Player p) {

        int size = board.size;

        for( int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if( j-i == -1)
                    if( !board.matrix[i][j].value.equals(p.symbol) )
                    {
                        return false;
                    }
            }
        }

        return true;
    }
}
