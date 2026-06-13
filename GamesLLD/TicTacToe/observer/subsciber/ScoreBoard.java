package GamesLLD.TicTacToe.observer.subsciber;

public class ScoreBoard implements ISubscriber {

    @Override
    public void notifyy(String message) {
        System.out.println(message);
    }
}
