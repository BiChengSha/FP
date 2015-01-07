// Date: Dec 27, 2014

public class GameTile {
  protected String name;
   
  // Accessor
  public String getName() {
    return name;
  }

  public GameTile(String name) {
    this.name = name;
  }
  
  public String toString() {
    return "Name: " + name;
  }
}
