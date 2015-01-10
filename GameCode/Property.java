//Created Dec 27, 2014
//Modified Jan 1, 2015

abstract class Property extends GameTile {
  protected int baseRent;
  protected int cost;
  protected Player owner;
  
  //Accessors
  public int getBaseRent() {
    return baseRent;
  }
  
  public int getCost() {
    return cost;
  }
  
  public Player getOwner() {
    return owner;
  }
  
  // Mutators
  public void setOwner(Player other) {
    owner = other;
  }
  
  
  // Constructor
  public Property(String name, int baseRent, int cost) {
    super(name);
    owner = null;
    this.baseRent = baseRent;
    this.cost = cost;
  }
  
  // calculate the rent
  abstract int calculateRent();
  
  //return info
  public String toString() {
    String temp = super.toString();
    temp += "Owner: " + owner;
    temp += "\nCost: " + cost;
    temp += "\nBase Rent: " + baseRent;
    return temp;
  }
  
  public boolean purchase(Player player) {
    if (player.getCash() >= cost) {
      player.setCash(player.getCash() - cost);
      owner = player;
      return true;
    } else {
      return false;
    }
  }
  
  public boolean sell() {
    owner.setCash(owner.getCash() + cost);
    owner = null;
    return true;
  }
  
}
