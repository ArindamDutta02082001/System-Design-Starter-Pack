package GamesLLD.TicTacToe.observer.publisher;

import GamesLLD.TicTacToe.observer.subsciber.ScoreBoardSubs;

import java.util.*;

public class  ScoreBoardPublisher{
    List<ScoreBoardSubs> subscribers;

    public ScoreBoardPublisher()
    {
        subscribers = new ArrayList<>();
    }

    public void add( ScoreBoardSubs scoreBoardSubs)
    {
        subscribers.add(scoreBoardSubs);
    }

    public void remove( ScoreBoardSubs scoreBoardSubs)
    {
        subscribers.remove(scoreBoardSubs);
    }

    public void notifySubscribers( String message)
    {
        for( ScoreBoardSubs s : subscribers)
        {
            s.update(message);
        }
    }
}
