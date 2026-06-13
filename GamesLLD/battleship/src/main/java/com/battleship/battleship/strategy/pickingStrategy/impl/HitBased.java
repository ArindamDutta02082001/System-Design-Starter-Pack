package com.battleship.battleship.strategy.pickingStrategy.impl;

import com.battleship.battleship.entity.Player;
import com.battleship.battleship.enums.FireType;
import com.battleship.battleship.strategy.pickingStrategy.IPlayerPickingStrategy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class HitBased implements IPlayerPickingStrategy {



    @Override
    public Player getNextPlayer(List<Player> playerList) {

        // same person should get the chance

        Player curr = playerList.get(0);
        if(curr.getLastHitType() == FireType.HIT || curr.getLastHitType() == null )
            return playerList.get(0);


        // mutating the list also
        playerList.add(curr);
        playerList.remove(0);

        return playerList.get(0);  // **vvi bug , dont return curr
    }
}