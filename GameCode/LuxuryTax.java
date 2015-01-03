// Date: Dec 30, 2014

public class LuxuryTax {
  private int amount;
  
  public LuxuryTax(int amount) {
    super("Luxury Tax");
    this.amount = amount;
  }
  
  public void deductTax(Player player) {
    player.cash = player.getCash() - amount;
  }
}
