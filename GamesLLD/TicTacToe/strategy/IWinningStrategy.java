package GamesLLD.TicTacToe.strategy;

import GamesLLD.TicTacToe.entity.Board;
import GamesLLD.TicTacToe.entity.Player.Player;

public interface IWinningStrategy {
    public boolean checkWin(Board board , Player p);
}
