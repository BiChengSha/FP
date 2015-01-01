// Date: Dec 27, 2014

abstract class Property extends GameTile {
  protected int baseRent;
  protected int cost;
  protected String owner;
  
  public Property(String name, String owner, int baseRent, int cost) {
    super(name);
    this.owner = owner;
    this.baseRent = baseRent;
    this.cost = cost;
  }
  
  abstract int calculateRent();
  
  public String toString() {
    String temp = super.toString();
    temp += "Owner: " + owner;
    temp += "Cost: " + cost;
    temp += "Base Rent: " + baseRent;
    return temp;
  }
  
}
