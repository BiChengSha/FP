/*
Created by: BiCheng
Created on: January 5, 2015
What it does: GameManager will call the ChanceTaken method in this class, and the method will randomly pick a "card" and
                return the String value (its contents) to the GameManager to handle
*/

import java.util.*; //For the "Random" class

public class Chance extends GameTile{
  Random rand = new Random();
  String[] chanceCards = new String[16]; //Initialising the array of cards, no values
  int randint;
  
  public String ChanceTaken(){
    randint = rand.nextInt(16); //Calls up a random integer
    return chanceCards[randint]; //Returns a card value from below
  }
  
  chanceCards[0] = "Advance to Go (Collect $200)";
  chanceCards[1] = "Advance to Illinois Ave.";
  chanceCards[2] = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
  chanceCards[3] = "Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)";
  chanceCards[4] = "Advance to St. Charles Place – if you pass Go, collect $200";
  chanceCards[5] = "Bank pays you dividend of $50";
  chanceCards[6] = "Get out of Jail free – this card may be kept until needed, or traded/sold";
  chanceCards[7] = "Go back 3 spaces";
  chanceCards[8] = "Go directly to Jail – do not pass Go, do not collect $200";
  chanceCards[9] = "Make general repairs on all your property – for each house pay $25 – for each hotel $100";
  chanceCards[10] = "Pay poor tax of $15";
  chanceCards[11] = "Take a trip to Reading Railroad – if you pass Go collect $200";
  chanceCards[12] = "Take a walk on the Boardwalk – advance token to Boardwalk";
  chanceCards[13] = "You have been elected chairman of the board – pay each player $50";
  chanceCards[14] = "Your building loan matures – collect $150";
  chanceCards[15] = "You have won a crossword competition - collect $100";
  
}
