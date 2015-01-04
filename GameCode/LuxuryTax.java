// Date: Dec 30, 2014

public class LuxuryTax {
  private int amount;
  
  // accesors
  public int getAmount() {
    return amount;
  }
  
  //mutators
  public void setAmount(int amount) {
    this.amount = amount;
  }
  
  public LuxuryTax(int amount) {
    super("Luxury Tax");
    this.amount = amount;
  }
  
  public boolean deductTax(Player player) {
    if (player.getCash() - amount >= 0) {
      player.cash = player.getCash() - amount;
      return true;
    } else {
      return false;
    }
  }
}
