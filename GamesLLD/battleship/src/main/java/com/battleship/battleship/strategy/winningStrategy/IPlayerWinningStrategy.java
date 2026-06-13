package com.battleship.battleship.strategy.winningStrategy;

import com.battleship.battleship.entity.Player;

import java.util.List;

public interface IPlayerWinningStrategy {

    Player checkWinner( List<Player> playerList);
}
