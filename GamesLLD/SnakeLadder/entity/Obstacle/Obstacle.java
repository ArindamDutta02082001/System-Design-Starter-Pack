package GamesLLD.SnakeLadder.entity.Obstacle;

public abstract class Obstacle {


    public int start;
    public int end;

    public Obstacle( int start, int end) {

        if( start <0 || start > 100 || end <0 || end > 100 )
        {
            throw new IllegalArgumentException(" Invalid start or end for Obstacle ");
        }
        this.start = start;
        this.end = end;
    }
}
