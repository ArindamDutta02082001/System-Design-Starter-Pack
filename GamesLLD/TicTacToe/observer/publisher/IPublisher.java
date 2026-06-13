package GamesLLD.TicTacToe.observer.publisher;

import GamesLLD.TicTacToe.observer.subsciber.ISubscriber;

public interface IPublisher {

    public void register(ISubscriber subscriber);
    public void deregister(ISubscriber subscriber);
    public void update(String message);
}
