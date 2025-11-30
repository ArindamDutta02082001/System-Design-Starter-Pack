package GamesLLD.TicTacToe.entity.Player;

public abstract class Player {
    public String name;
    public String symbol;

    public Player(String name, String symbol)
    {
        this.name = name;
        this.symbol = symbol;
    }
}
