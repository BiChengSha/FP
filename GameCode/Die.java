/* Author: David
 * Date: Dec 25, 2014
 * Description: Class which creates a die for the monopoly board and performs a roll of the die function
 */

import java.util.Random; // importing the random method from java docs

public class Die {
  // The integer value assigned to the roll of a single die
  public int lastRoll;
  
  public int getLastRoll() {
    return lastRoll;
  }
  
  // Constructor of the class
  public Die() {
    lastRoll = Die.Roll();
  }
  
  public static int Roll() {
    Random rand = new Random();
    return rand.nextInt(6) + 1;
  }
  
  public int compareTo(Die other) {
    return this.getLastRoll() - other.getLastRoll();
  }
  
  public static void main (String[] args) {
    Die d1 = new Die();
    System.out.println(d1.getLastRoll());
  }
}
