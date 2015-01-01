// Date: Dec 30, 2014 

public class IncomeTax {
  private double percentage;
  
  public IncomeTax(double percentage) {
    this.percentage = percentage;
  }
  
  public void deductTax(Player player) {
    player.cash = player.getCash() * (1.00 - percentage);
  }
}
