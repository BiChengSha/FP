public class Utility extends Property {
  
  public Utility (String owner, int cost, int baseRent) {
    super(owner, cost, baseRent);
  }
  
  public String toString() {
    return super.toString();
  }
  
  public int calculateRent() {
    
    Die die1 = new Die();
    Die die2 = new Die();
    
    if (owner.getNumUtilities() == 1) {
      int temp = die1.roll() + die2.roll();
      return temp*baseRent;
    } else {
      int temp = die2.roll() + die1.roll();
      return (int)(temp*baseRent*2.5);
    }
  }
}
