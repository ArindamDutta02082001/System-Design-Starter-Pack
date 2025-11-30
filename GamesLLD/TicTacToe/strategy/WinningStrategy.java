package GamesLLD.TicTacToe.strategy;

import GamesLLD.TicTacToe.Board;
import GamesLLD.TicTacToe.entity.Player.Player;

public interface WinningStrategy {
    public boolean checkWin(Board board , Player p);
}
