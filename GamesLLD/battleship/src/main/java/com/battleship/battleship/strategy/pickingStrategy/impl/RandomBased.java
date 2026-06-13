package com.battleship.battleship.strategy.pickingStrategy.impl;

import com.battleship.battleship.entity.Player;
import com.battleship.battleship.enums.FireType;
import com.battleship.battleship.strategy.pickingStrategy.IPlayerPickingStrategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RandomBased implements IPlayerPickingStrategy {

    @Override
    public Player getNextPlayer(List<Player> playerList) {

        int rand = (int) (Math.random()*2);
        return playerList.get(rand);
    }
}
