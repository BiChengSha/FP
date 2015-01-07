// Date: Dec 27, 2014

public class GameTile {
  protected String name;
  protected int location;
   
  // Accessors (Author: Zain)
  public String getName() {
    return name;
  }
  
  public int getLocation() {
    return location;
  }
  
  public GameTile(String name) {
    this.name = name;
  }
  
  public String toString() {
    return "Name: " + name;
  }
}
