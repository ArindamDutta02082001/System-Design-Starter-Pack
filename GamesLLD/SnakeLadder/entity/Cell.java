package GamesLLD.SnakeLadder.entity;

import GamesLLD.SnakeLadder.entity.Obstacle.Obstacle;

public class Cell
{
    public Integer cellNo;

    public Obstacle obstacle = null;

    public Cell(Integer cellNo )
    {
        this.cellNo = cellNo;
    }

}
