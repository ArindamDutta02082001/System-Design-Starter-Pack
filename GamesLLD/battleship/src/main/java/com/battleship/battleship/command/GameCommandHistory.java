package com.battleship.battleship.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameCommandHistory {

    private final Deque<GameCommand> history = new ArrayDeque<>();
    private final int maxHistory;

    public GameCommandHistory() {
        this.maxHistory = 100; // default
    }

    public void executeCommand(GameCommand cmd) {
        cmd.execute();
        history.addLast(cmd);
        if (history.size() > maxHistory) history.removeFirst();
    }

    public void undoLast() {
        if (history.isEmpty()) return;
        GameCommand last = history.poll();
        last.undo();
    }

    public int size() {
        return history.size();
    }
}

