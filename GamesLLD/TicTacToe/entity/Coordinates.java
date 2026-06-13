package GamesLLD.TicTacToe.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinates {


    int x , y;

    public Coordinates(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

}
