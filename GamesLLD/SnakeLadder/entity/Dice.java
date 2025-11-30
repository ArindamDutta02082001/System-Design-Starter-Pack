package GamesLLD.SnakeLadder.entity;

public class Dice {

    public Integer rollDice()
    {
        return (int)(Math.random()*6) + 1;
    }

}
