/*
 Created by: BiCheng
 Edited by: David & Matias & Zain
 Created on: January 5, 2015
 What it does: GameManager will call the ChanceTaken method in this class, and the method will randomly pick a "card" and
 return the String value (its contents) to the GameManager to handle
 */

import java.util.*; //For the "Random" class

public class Chance extends GameTile {
  private Random rand = new Random();
  private int randint;
  private String title = "Chance";
  
  GameManager manager;
  
  // initializing the messages arraay
private String[] chanceCards = {("Advance to Go (Collect $200)"),  // 0
    ("Advance to Springfield."), // 1
    ("Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown."), // 2
    ("Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)"), // 3
    ("Advance to King's Landing - if you pass Go, collect $200"), // 4
    ("Bank pays you dividend of $50"), // 5
    ("Get out of Jail free - this card may be kept until needed, or traded/sold"), // 6
    ("Go back 3 spaces"), // 7
    ("Go directly to Jail - do not pass Go, do not collect $200"), // 8
    ("Make general repairs on all your property - for each house pay $25"), // 9
    ("Pay poor tax of $15"), // 10
    ("Take a trip to Reading Railroad - if you pass Go collect $200"), // 11
    ("Go to Hell"), // 12
    ("You have been elected chairman of the board - pay each player $50"), // 13
    ("Your building loan matures - collect $150"), // 14
    ("You have won a crossword competition - collect $100") // 15
};
  
  public Chance(GameManager manage){
    super("Chance");
    manager = manage;
  }

  public void performAction(Player player) {
    switch (randint) {
      case 0: // Advance to GO (Collect $200)
        new NotificationWindow(title, chanceCards[randint]);
        manager.move(manager.GO_TILE);
        break;
      case 1: // Advance to Springfield (index 24 in the players)
        manager.move(24);
        break;
      case 2: // Advance to the nearest utility
        new NotificationWindow(title, chanceCards[randint]);
        
        if (player.getLocation() >= manager.UTILITY_2 && player.getLocation() < manager.UTILITY_1) {
          manager.move(manager.UTILITY_1);
        } else {
          manager.move(manager.UTILITY_2);
        }
        
        break;
      case 3: // Advance to the nearest Railroad
        new NotificationWindow(title, chanceCards[randint]);
        
        if(player.getLocation() >= manager.RAILROAD_1 && player.getLocation() < manager.RAILROAD_2) {
          manager.move(manager.findMovement(manager.RAILROAD_2, player.getLocation()));
        } else if (player.getLocation() >= manager.RAILROAD_2 && player.getLocation() < manager.RAILROAD_3) {
          manager.move(manager.findMovement(manager.RAILROAD_3, player.getLocation()));
        } else if (player.getLocation() >= manager.RAILROAD_3 && player.getLocation() < manager.RAILROAD_4) {
          manager.move(manager.findMovement(manager.RAILROAD_4, player.getLocation()));
        } else {
          manager.move(manager.findMovement(manager.RAILROAD_1, player.getLocation()));
        }
        break;
      case 4: // Advance to the nearest Railroad
        new NotificationWindow(title, chanceCards[randint]);
        
        if(player.getLocation() >= manager.RAILROAD_1 && player.getLocation() < manager.RAILROAD_2) {
          manager.move(manager.findMovement(manager.RAILROAD_2, player.getLocation()));
        } else if (player.getLocation() >= manager.RAILROAD_2 && player.getLocation() < manager.RAILROAD_3) {
          manager.move(manager.findMovement(manager.RAILROAD_3, player.getLocation()));
        } else if (player.getLocation() >= manager.RAILROAD_3 && player.getLocation() < manager.RAILROAD_4) {
          manager.move(manager.findMovement(manager.RAILROAD_4, player.getLocation()));
        } else {
          manager.move(manager.findMovement(manager.RAILROAD_1, player.getLocation()));
        }
        break;
      case 5: // Advance to King's Landing (index 11 in the players)
        new NotificationWindow(title, chanceCards[randint]);
        manager.move(manager.findMovement(11, player.getLocation()));
        break;
      case 6: // Banks pays you a divident of $50
        new NotificationWindow(title, chanceCards[randint]);
        player.setCash(player.getCash() + 50);
        break;
      case 7: // Go back three spaces
        new NotificationWindow(title, chanceCards[randint]);
        // if the index of the player's location is less than 3, than the player must move to the end of the board to prevent the
        // index value of the player's location going into a negative number
        
        if (player.getLocation() - 3 >= 0) {
          manager.move(manager.findMovement(player.getLocation()-1, player.getLocation()));
          player.setCash(player.getCash() - 200); // $200 needs to be removed from the player's cash since they never passed go, but the move method
          // only works when a player moves forward, so in the code, the player travels around the entire board, but lands
          // on the GameTile 3 locations prior to their previous location 
        } else {
          manager.move(manager.findMovement(player.getLocation()-3 + manager.NUM_TILES, player.getLocation()));
        }
        
        break;
      case 8: // Make general repairs - $15 per house owned by player
        new NotificationWindow(title, chanceCards[randint]);
        int numHouses = 0;
        
        Property[] properties = manager.getPropertyManager().getPropertyList();
        
        for (int i = 0; i < properties.length; i++) {
          if (properties[i] instanceof Estate) {
            if (properties[i].getOwner().equals(player.getName())) {
              numHouses += ((Estate)properties[i]).getNumHouses();
            }
          }
        }
        player.setCash(player.getCash() - numHouses * 15);
        break;
      case 9: // pay poor tax of $20
        new NotificationWindow(title, chanceCards[randint]);
        player.setCash(player.getCash() - 20);
        break;
      case 10: // Take a trip to the first railroad (constant in the manager)
        new NotificationWindow(title, chanceCards[randint]);
        manager.move(manager.findMovement(manager.RAILROAD_1, player.getLocation()));
        break;
      case 11: // "Go to hell" index 39 in players;
        new NotificationWindow(title, chanceCards[randint]);
        manager.move(manager.findMovement(39, player.getLocation()));
        break;
      case 12: // You have been eleceted chairman of the board - pay each player $50
        new NotificationWindow(title, chanceCards[randint]);
        int playerNum = manager.getPlayers().length;
        
        for (int i = 0; i < playerNum; i++) {
          player.transferCash(manager.getPlayers()[i] ,-50);
        }
        break;
      case 13: // Your building loan matures - collect $150
        new NotificationWindow(title, chanceCards[randint]);
        player.setCash(player.getCash() + 150);
        break;
      case 14: // You have won a crossword competition - collect $100
        new NotificationWindow(title, chanceCards[randint]);
        player.setCash(player.getCash() + 100);
        break;
    }
  } 
}
