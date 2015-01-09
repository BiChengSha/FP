// Date: Dec 30, 2014 

public class IncomeTax extends GameTile {
  private double percentage;
  
  public IncomeTax(double percentage) {
    super("Income Tax");
    this.percentage = percentage;
  }
  
  public void deductTax(Player player) {
    player.setCash((int)(player.getCash() * (1.00 - percentage)));
  }
}
