public class Railroad extends Property {
  
  public Railroad (String owner, int cost, int baseRent) {
    super(owner, cost, baseRent);
  }
  
  public String toString() {
    return super.toString();
  }
  
  public int calculateRent() {
    return (int)(baseRent * Math.pow(2, owner.getNumRR()-1));
  }
}
