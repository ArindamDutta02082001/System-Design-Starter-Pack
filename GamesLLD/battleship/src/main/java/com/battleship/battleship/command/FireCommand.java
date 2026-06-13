package com.battleship.battleship.command;

import com.battleship.battleship.entity.Cell;
import com.battleship.battleship.entity.Player;
import com.battleship.battleship.entity.Ship;
import com.battleship.battleship.enums.FireType;


public class FireCommand implements GameCommand {

    private final Player currPlayer;
    private final int x;
    private final int y;

    FireType afterFireResult;

    public FireCommand( Player currPlayer , int x, int y) {
        this.currPlayer = currPlayer;
        this.x = x;
        this.y = y;
    }

    @Override
    public void execute() {
        afterFireResult = currPlayer.getTrackingBoard().fire(x,y);
    }

    @Override
    public void undo() {
        afterFireResult = null;
        currPlayer.getTrackingBoard().unfire(x,y);
    }

    public FireType getFireResult()
    {
        return afterFireResult;
    }

}

