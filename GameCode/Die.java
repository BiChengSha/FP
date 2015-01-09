/* Author: David
 * Date: Dec 25, 2014
 * Description: Class which creates a die for the monopoly board and performs a roll of the die function
 */

import java.util.Random; // importing the random method from java docs

public class Die {
  // The integer value assigned to the roll of a single die
  private int lastRoll;
  
  public int getLastRoll() {
    return lastRoll;
  }
  
  // Constructor of the class
  public Die() {
    lastRoll = 0;
  }
  
  public int roll() {
    Random rand = new Random();
    lastRoll = rand.nextInt(6) + 1;
    return lastRoll;
  }
  
  public int compareTo(Die other) {
    return this.getLastRoll() - other.getLastRoll();
  }
}
