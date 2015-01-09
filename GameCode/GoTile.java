// Date: Dec 30, 2014

public class GoTile extends GameTile {
  
  private int amount;
  
  public GoTile(int amount) {
    super("Go");
    this.amount = amount;
  }
  
  public void passGo(Player player) {
    player.setCash(player.getCash() + amount);
  }
}
