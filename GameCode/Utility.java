public class Utility extends Property {
  
  public Utility (String owner, int cost, int baseRent) {
    super(owner, cost, baseRent);
  }
  
  public String toString() {
    return super.toString();
  }
  
  public int calculateRent() {
    if (owner.getNumUtilities == 1) {
      int temp = Die.Roll() + Die.Roll();
      return temp*4;
    } else {
      int temp = Die.Roll() + Die.Roll();
      return temp*10;
    }
  }
}
