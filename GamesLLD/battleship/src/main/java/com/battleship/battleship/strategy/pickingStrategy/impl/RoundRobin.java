package com.battleship.battleship.strategy.pickingStrategy.impl;

import com.battleship.battleship.entity.Player;
import com.battleship.battleship.enums.FireType;
import com.battleship.battleship.strategy.pickingStrategy.IPlayerPickingStrategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class RoundRobin implements IPlayerPickingStrategy {



    @Override
    public Player getNextPlayer(List<Player> playerList ) {

        Deque<Player> dq = new ArrayDeque<>();  // bad : dont need dq , as list rotation happening pass by val

        for( Player  p : playerList )
        {
            dq.addLast(p);
        }
        Player curr = dq.poll();
        dq.addLast(curr);

        // mutating the list also
        playerList.add(curr);
        playerList.remove(0);

        return curr;
    }
}
