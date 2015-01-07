// /*
//  Created by: BiCheng
//  Created on: January 5, 2015
//  What it does: GameManager will call the ChanceTaken method in this class, and the method will randomly pick a "card" and
//  return the String value (its contents) to the GameManager to handle
//  */

// import java.util.*; //For the "Random" class

// public class Chance extends GameTile{
//   Random rand = new Random();
//   String[] chanceCards = new String[16]; //Initialising the array of cards, no values
//   int randint;
  
//   GameManager manager;
  
//   chanceCards[0] = "Advance to Go (Collect $200)";
//   chanceCards[1] = "Advance to Springfield.";
//   chanceCards[2] = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
//   chanceCards[3] = "Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)";
//   chanceCards[4] = "Advance to King's Landing - if you pass Go, collect $200";
//   chanceCards[5] = "Bank pays you dividend of $50";
//   chanceCards[6] = "Get out of Jail free - this card may be kept until needed, or traded/sold";
//   chanceCards[7] = "Go back 3 spaces";
//   chanceCards[8] = "Go directly to Jail - do not pass Go, do not collect $200";
//   chanceCards[9] = "Make general repairs on all your property - for each house pay $25";
//   chanceCards[10] = "Pay poor tax of $15";
//   chanceCards[11] = "Take a trip to Reading Railroad - if you pass Go collect $200";
//   chanceCards[12] = "Go to Hell";
//   chanceCards[13] = "You have been elected chairman of the board - pay each player $50";
//   chanceCards[14] = "Your building loan matures - collect $150";
//   chanceCards[15] = "You have won a crossword competition - collect $100";
  
//   public Chance(String name, GameManager manage){
//     super(name);
//     manager = manage;
//   }
  
//   public String ChanceTaken(){
//     randint = rand.nextInt(16); //Calls up a random integer
//     Player currentPlayer = manager.players[manager.getCurrentPlayerIndex()];
//     //IF CARD PICKED IS 0///////////////////////////////////////////////////////////////////////////////////////////////
//     if(randint == 0){
//       MyFrame("CHANCE", "Advance to Go (Collect $200)");
//       frame.setVisible( true );             // ask it to become visible
//       frame.setSize(400, 175);
//       frame.setVisible( true );
      
//       manager.move(currentPlayer, 0);
//       currentPlayer.setCash(currentPlayer.getCash() + 200);
//       return chanceCards[randint]; //Returns a card value from above
//     } else if(randint == 1){ //IF CARD PICKED IS 1//////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
      
//       manager.move(currentPlayer, 24);
//       return chanceCards[randint];
//     } else if(randint == 2){//IF CARD PICKED IS 2///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
      
//       if(currentPlayer.getLocation() >= 12 && currentPlayer.getLocation() < 27){
//         manager.move(currentPlayer, 27);
//       } else {
//         manager.move(currentPlayer, 12);
//       }
//       return chanceCards[randint];
//     } else if(randint == 3){//IF CARD PICKED IS 3///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank.");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
      
//       if(currentPlayer.getLocation() < 5){
//         manager.move(currentPlayer, 5);
//       } else if (currentPlayer.getLocation() >= 5 && currentPlayer.getLocation() < 15){
//         manager.move(currentPlayer, 15);
//       } else if (currentPlayer.getLocation() >= 15 && currentPlayer.getLocation() < 25){
//         manager.move(currentPlayer, 25);
//       } else if (currentPlayer.getLocation() >= 25 && currentPlayer.getLocation() < 35){
//         manager.move(currentPlayer, 35);
//       } else {
//         manager.move(currentPlayer, 5);
//       } return chanceCards[randint];
//     } else if(randint == 4){//IF CARD PICKED IS 4///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to King's Landing - if you pass Go, collect $200");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
      
//       //GOTO TILE 11
//       if (currentPlayer.getLocation() < 11){
//         manager.move(currentPlayer, 11);
//       } else if (currentPlayer.getLocation() >= 11){
//         manager.move(currentPlayer, 11);
//         currentPlayer.setCash(currentPlayer.getCash() + 200);
//       }
//       return chanceCards[randint];
//     } else if(randint == 5){//IF CARD PICKED IS 5///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       currentPlayer.setCash(currentPlayer.getCash() + 50);
//       return chanceCards[randint];
//     } else if(randint == 6){//IF CARD PICKED IS 6///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       //GET OUT OF JAIL FREE TO BE ADDED IF TIME ALLOWS
//       return chanceCards[randint];
//     } else if(randint == 7){//IF CARD PICKED IS 7///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       manager.move(currentPlayer, (currentPlayer.getLocation() - 3));
//       return chanceCards[randint];
//     } else if(randint == 8){//IF CARD PICKED IS 8///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       manager.move(currentPlayer, 10); //NO ACTUAL JAIL YET, BUT STILL SENT TO <10>
//       return chanceCards[randint];
//     } else if(randint == 9){//IF CARD PICKED IS 9///////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       Player player = manager.players.get(getCurrentPlayerIndex());
//       int countHouse = 0;
//       for(int i = 0; i < player.getPropertiesOwned().properties.length; i++){
//         if(player.setPropertiesOwned().properties.get(i) instanceof Estate){
//           countHouses += player.setPropertiesOwned().properties.get(i).getNumHouses();
//         }
//       }
//       return chanceCards[randint];
//     } else if(randint == 10){//IF CARD PICKED IS 10/////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       currentPlayer.setCash(currentPlayer.getCash() - 15);
//       return chanceCards[randint];
//     } else if(randint == 11){//IF CARD PICKED IS 11/////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       //READING RAILROAD IS FIRST RAILROAD @BLOCK 5
//       if (currentPlayer.getLocation() < 5){
//         manager.move(currentPlayer, 5);
//       } else if (currentPlayer.getLocation() >= 5){
//         manager.move(currentPlayer, 5);
//         currentPlayer.setCash(currentPlayer.getCash() + 200);
//       }
//       return chanceCards[randint];
//     } else if(randint == 12){//IF CARD PICKED IS 12/////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       manager.move(currentPlayer, 39);
//       return chanceCards[randint];
//     } else if(randint == 13){//IF CARD PICKED IS 13/////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       for(int i = 0; i < /*<NUMBER OF PLAYERS>*/; i++){
//         if(/*i != CURRENT PLAYER*/){
//           //CURRENTPLAYER LOSES $50
//           //PLAYERINDEX GAINS $50
//         }
//       }
//       return chanceCards[randint];
//     } else if(randint == 14){//IF CARD PICKED IS 14/////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       currentPlayer.setCash(currentPlayer.getCash() + 150);
//       return chanceCards[randint];
//     } else if(randint == 15){//IF CARD PICKED IS 15/////////////////////////////////////////////////////////////////////
//       MyFrame("CHANCE", "Advance to Springfield");
//       frame.setVisible( true );
//       frame.setSize(400, 175);
//       frame.setVisible( true );
//       currentPlayer.setCash(currentPlayer.getCash() + 100);
//       return chanceCards[randint];
//     }
//   }
// }

//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
 Created by: David & BiCheng
 Created on: January 5, 2015
 What it does: GameManager will call the ChanceTaken method in this class, and the method will randomly pick a "card" and
 return the String value (its contents) to the GameManager to handle
 */

import java.util.*; //For the "Random" class

public class Chance extends GameTile{
  //Random rand = new Random();
  //String[] chanceCards = new String[16]; //Initialising the array of cards, no values
  //int randint;
  
  GameManager manager;
  
//  chanceCards[0] = "Advance to Go (Collect $200)";
//  chanceCards[1] = "Advance to Springfield.";
//  chanceCards[2] = "Advance token to nearest Utility. If unowned, you may buy it from the Bank. If owned, throw dice and pay owner a total ten times the amount thrown.";
//  chanceCards[3] = "Advance token to the nearest Railroad and pay owner twice the rental to which he/she is otherwise entitled. If Railroad is unowned, you may buy it from the Bank. (There are two of these.)";
//  chanceCards[4] = "Advance to King's Landing - if you pass Go, collect $200";
//  chanceCards[5] = "Bank pays you dividend of $50";
//  chanceCards[6] = "Get out of Jail free - this card may be kept until needed, or traded/sold";
//  chanceCards[7] = "Go back 3 spaces";
//  chanceCards[8] = "Go directly to Jail - do not pass Go, do not collect $200";
//  chanceCards[9] = "Make general repairs on all your property - for each house pay $25 - for each hotel $100";
//  chanceCards[10] = "Pay poor tax of $15";
//  chanceCards[11] = "Take a trip to Reading Railroad - if you pass Go collect $200";
//  chanceCards[12] = "Go to Hell";
//  chanceCards[13] = "You have been elected chairman of the board - pay each player $50";
//  chanceCards[14] = "Your building loan matures - collect $150";
//  chanceCards[15] = "You have won a crossword competition - collect $100";
  
  public Chance(String name, GameManager manage){
    super(name);
    manager = manage;
  }
  
//  // Author: David
//  public void performAction(Player player, int num, GameMananger manager) {
//    randint = rand.nextInt(16); //Calls up a random integer
//    Player currentPlayer = manager.players[manager.getCurrentPlayerIndex()];
//    if(randint == 0){
//      manager.move(currentPlayer, 0);
//      currentPlayer.setCash(currentPlayer.getCash() + 200);
//      return chanceCards[randint]; //Returns a card value from above
//    } else if(randint == 1){
//      manager.move(currentPlayer, 24);
//      return chanceCards[randint];
//    } else if(randint == 2){
//      if(currentPlayer.getLocation() >= 12 && currentPlayer.getLocation() < 27){
//        manager.move(currentPlayer, 27);
//      } else {
//        manager.move(currentPlayer, 12);
//      }
//      return chanceCards[randint];
//    } else if(randint == 3){
//      if(){
//      } else if {
//      }
//      return chanceCards[randint];
//    } else if(randint == 4){
//      
//      return chanceCards[randint];
//    } else if(randint == 5){
//      
//      return chanceCards[randint];
//    } else if(randint == 6){
//      
//      return chanceCards[randint];
//    } else if(randint == 7){
//      
//      return chanceCards[randint];
//    } else if(randint == 8){
//      
//      return chanceCards[randint];
//    } else if(randint == 9){
//      
//      return chanceCards[randint];
//    } else if(randint == 10){
//      
//      return chanceCards[randint];
//    } else if(randint == 11){
//      
//      return chanceCards[randint];
//    } else if(randint == 12){
//      
//      return chanceCards[randint];
//    } else if(randint == 13){
//      
//      return chanceCards[randint];
//    } else if(randint == 14){
//      
//      return chanceCards[randint];
//    } else if(randint == 15){
//      
//      return chanceCards[randint];
//    }
//  }
  
  
  // Author: David
  public void performAction(Player player, int num, GameMananger manager) {
    switch (num) {
      case 0: // Advance to GO (Collect $200)
        manager.move(player, 0, player.getLocation(), movementCheck(0, player.getLocation()));
        break;
      case 1: // Advance to Springfield (index 24 in the array)
        manager.move(player, 24, player.getLocation(), movementCheck(24, player.getLocation()));
        break;
      case 2: // Advance to the nearest utility
        player.cash = player.getCash();
        if (UTILITY_1 >= UTILITY_2) {
          if (player.getLocation() >= UTILITY_2 && player.getLocation() < UTILITY_1) {
            manager.move(player, UTILITY_1, player.getLocation(), movementCheck(UTILITY_1, player.getLocation()));
          } else {
            manager.move(player, UTILITY_2, player.getLocation(), movementCheck(UTILITY_2, player.getLocation()));
          }
        } else { 
          if(player.getLocation() >= UTILITY_1 && player.getLocation() < UTILITY_2) {
            manager.move(player, UTILITY_2, player.getLocation(), movementCheck(UTILITY_2, player.getLocation()));
          } else {
            manager.move(player, UTILITY_1, player.getLocation(), movementCheck(UTILITY_1, player.getLocation()));
          }
        }
        break;
      case 3: // Advance to the nearest Railroad
        
        
        
        if(player.getLocation() >= 5 && player.getLocation() < 15) {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        } else if (player.getLocation() >= 15 && player.getLocation() < 25) {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        } else if (player.getLocation() >= 25 && player.getLocation() < 35) {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        } else {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        }
        break;
      case 4: // Advance to the nearest Railroad
        if(player.getLocation() >= 5 && player.getLocation() < 15) {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        } else if (player.getLocation() >= 15 && player.getLocation() < 25) {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        } else if (player.getLocation() >= 25 && player.getLocation() < 35) {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        } else {
          manager.move(player, 15, player.getLocation(), movementCheck(15, player.getLocation()));
        }
        break;
      case 5: // Advance to King's Landing (index 11 in the array)
        manager.move(player, 11, player.getLocation(), movementCheck(11, player.getLocation()));
        break;
      case 6: // Banks pays you a divident of $50
        player.cash = player.getCash() + 50;
        break;
      case 7: // Go back three spaces
        // if the index of the player's location is less than 3, than the player must move to the end of the board to prevent the
        // index value of the player's location going into a negative number
        if (player.getLocation() == 2) {
          player.setLocation(39);
          player.cash = player.getCash() - 200;
        } else if (player.getLocation() == 1) {
          player.setLocation(38);
          player.cash = player.getCash() - 200;
        } else if (player.getLocation() == 0) {
          player.setLocation(37);
          player.cash = player.getCash() - 200;
        } else {
          manager.move(player, (player.getLocation() - 3), player.getLocation(), movementCheck((player.getLocation() - 3)), player.getLocation());
          player.cash = player.getCash() - 200; // $200 needs to be removed from the player's cash since they never passed go, but the move method
                                                // only works when a player moves forward, so in the code, the player travels around the entire board, but lands
                                                // on the GameTile 3 locations prior to their previous location 
        }
        break;
      case 8: // Make general repairs - $15 per house owned by player
        int numHouses = 0;
        for (int i = 0; i < properties.length; i++) {
          if (properties[i] instanceof Estate) {
            if (properties[i].getOwner().equals(player.getName())) {
              numHouses += properties[i].getNumHouses();
            }
          }
        }
        player.cash = player.getCash() - (numHouses*15);
        break;
      case 9: // pay poor tax of $20
        player.cash = player.getCash() - 20
        break;
      case 10: // Take a trip to reading railroad (index 5 in the array)
        manager.move(player, 5, player.getLocation(), movementCheck(5, player.getLocation()));
        break;
      case 11: // "Go to " + manager.board[39].getName();
        manager.move(player, 39, player.getLocation(), movementCheck(39, player.getLocation()));
        break;
      case 12: // You have been eleceted chairman of the board - pay each player $50
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (i != currentPlayerIndex) {
            players[i].cash = player.getCash() + 50;
          }
        }
        player.cash = player.getCash() - ((playerAmount-1)*50);
        break;
      case 13: // Your building loan matures - collect $150
        player.cash = player.getCash() + 150;
        break;
      case 14: // You have won a crossword competition - collect $100
        player.cash = player.getCash() + 100;
        break;
    }
  }
  
}


