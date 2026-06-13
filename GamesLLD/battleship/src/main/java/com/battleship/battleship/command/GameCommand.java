package com.battleship.battleship.command;

import com.battleship.battleship.enums.FireType;

public interface GameCommand {
    void execute();
    void undo();
}

