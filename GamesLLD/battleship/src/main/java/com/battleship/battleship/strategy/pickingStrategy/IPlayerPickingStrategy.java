package com.battleship.battleship.strategy.pickingStrategy;

import com.battleship.battleship.entity.Player;
import com.battleship.battleship.enums.FireType;

import java.util.List;

public interface IPlayerPickingStrategy {

    Player getNextPlayer(List<Player> playerList);
}
