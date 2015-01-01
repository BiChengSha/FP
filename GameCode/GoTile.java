// Date: Dec 30, 2014

public class GoTile extends GameTile {
  
  private int amount;
  
  public GoTile(String name, int amount) {
    super(name);
    this.amount = amount;
  }
  
  public void passGo(Player player) {
    player.cash = player.getCash() + amount;
  }
}
