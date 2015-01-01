//Created Dec 27, 2014
//Modified Jan 1, 2015

abstract class Property extends GameTile {
  protected int baseRent;
  protected int cost;
  protected Player owner;
  
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
  
  public boolean purchase(Player player) {
    if (player.getCash() >= cost) {
      player.cash = player.getCash() - cost;
      owner = player.getName();
      return true;
    } else {
      return false;
    }
  }
  
  public boolean sell() {
    player.cash = player.getCash() + cost;
    owner = null;
    return true;
  }
  
}
