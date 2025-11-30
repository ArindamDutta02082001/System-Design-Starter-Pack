package GamesLLD.SnakeLadder.entity.Player;

public class Player {
    public String _name;

   public String color;

   public Integer position = 0;     // to store the position in the Cell chain

   public Player( Integer position , String _playerName , String _playerColor)
   {
       this.position = position;
       this._name = _playerName;
       this.color = _playerColor;
   }

}
