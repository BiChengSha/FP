/**
 * Authors: Zain, BiCheng
 * GameManager class
 * Started Dec. 30
 */

import java.io.*;
import java.util.*;

public class GameManager {
  /**
   * Constants for unchanging locations on the board (utilities, railroads, four corners)
   */
  public static final int UTILITY_1 = 12;
  public static final int UTILITY_2 = 28;

  public static final int RAILROAD_1 = 5;
  public static final int RAILROAD_2 = 15;
  public static final int RAILROAD_3 = 25;
  public static final int RAILROAD_4 = 35;

  public static final int GO_TILE = 0;
  public static final int AZKABAN = 10;
  public static final int LIMBO = 20;
  public static final int SCENIC_ROUTE = 30;

  /**
   * Number of Tiles on the board
   */
  public final int NUM_TILES = 40;

  /**
   * The Game Board players which holds all the tiles in order
   */
  private GameTile[] board;

  /**
   * PropertyManager instance which keeps track of all the purchasable properties in the game
   */
  private PropertyManager propertyManager;

  /**
   * The List of players currently in the game
   */
  private ArrayList players;

  /**
   * The two dice which are used in the game
   */
  private Die die1;
  private Die die2;

  /**
   * Checks if this player has rolled
   */
  private boolean roll;

  /**
   * The player (determined by the index in the playerslist) whose turn it is
   */
  private int currentPlayerIndex;

  /**
   * The file (name) that the properties for the gameboard are read from (read-only)
   */
  private String propertyList = "PropertyList.txt";

  /**
   * The file (name) which the game is saved in (and loaded from)
   */
  private String savedGameFile = "save.txt";


  /**
   * Accessor Methods
   * @author Zain
   */
  // game board
  public GameTile[] getBoard() {
    return board;
  }

  public Die getDie1() {
    return die1;
  }

  public Die getDie2() {
    return die2;
  }

  // property manager
  public PropertyManager getPropertyManager() {
    return propertyManager;
  }

  //players - this one returns an players (not an playerslist)
  public Player[] getPlayers() {
    Player[] temp = new Player[players.size()];
    // initializing players
    for (int i = 0; i < temp.length; i++) {
      temp[i] = (Player)players.get(i);
    }
    return temp;
  }

  // current player index
  public int getCurrentPlayerIndex() {
    return currentPlayerIndex;
  }

  // number of players
  public int getNumPlayers() {
    return players.size();
  }

  // No mutator methods are required.

  /**
   * Constructor, Initializes variables
   * @author Bicheng
   * @author Zain
   */
  public GameManager(){
    board = new GameTile[NUM_TILES];
    die1 = new Die();
    die2 = new Die();
    propertyManager = new PropertyManager();
    players = new ArrayList();
    initializeProperties();
    roll = false;
  }

  /**
   * Starts a new game
   * @author Zain
   */
  public void newGame(){
    AddPlayerWindow addPlayers = new AddPlayerWindow(this);
  }

  /**
   * Loads a saved game
   * @author Zain
   */
  public void loadGame(){
    BufferedReader input;

    try {
      input = new BufferedReader(new FileReader(savedGameFile));
      // Holds the name of each player. When this is null the loop exits.
      String name;

      // Loops through input until "next" is null
      while ((name = input.readLine()) != null) {
        // Required variables
        int cash, location, utilities, railroads;

        // Getting variable info
        cash = Integer.parseInt(input.readLine());
        location = Integer.parseInt(input.readLine());
        utilities = Integer.parseInt(input.readLine());
        railroads = Integer.parseInt(input.readLine());

        // placing new player in the playerslist
        Player newPlayer = new Player(name, cash, location, utilities, railroads);
        players.add(newPlayer);

        /* Looping through the properties that this player owns. The name variable will
           now hold the name of property. The loop will exit when this variable holds a blank line */
        while (!(name = input.readLine()).equals("")) {
          // finding the property with this name
          Property temp = propertyManager.searchPropertiesByName(name);
          // making the owner this player
          temp.setOwner(newPlayer);
          // number of houses (if it is an estate)
          if (temp instanceof Estate) {
            ((Estate)temp).setNumHouses(Integer.parseInt(input.readLine()));
          }
          // adding this property to the player's property manager
          newPlayer.getPropertiesOwned().addProperty(temp);
        }

      }
    }
    catch (IOException iox) {
      System.out.println("Error Accessing the file to load game from");
    }
  }

  /**
   * Initializes the game board properties from a file
   * @author Zain
   */
  public void initializeProperties(){
    BufferedReader input;

    try {
      input = new BufferedReader(new FileReader(propertyList));

      // Holds the type of property
      String type;

      // looping the number of times required to fill in the players
      // It is assumed that the number of properties in the file are the exact number needed
      for (int i = 0; i < NUM_TILES; i++) {
        // Property Type
        type = input.readLine();

        // Determining the type of property
        // All properties are added to board, purchaseable properties are added to propertyManager as well
        // Go
        if (type.equals("GoTile")) {
          board[i] = new GoTile(200);
        }

        // Estate
        else if (type.equals("Estate")) {
          // Variables required
          String name;
          int group, num_in_group, cost, rent, rent_increase;

          // Getting values
          name = input.readLine();
          group = Integer.parseInt(input.readLine());
          num_in_group = Integer.parseInt(input.readLine());
          cost = Integer.parseInt(input.readLine());
          rent = Integer.parseInt(input.readLine());
          rent_increase = Integer.parseInt(input.readLine());

          // Constructor for Estate
          board[i] = new Estate(name, group, num_in_group, cost, rent, rent_increase);
          // Add to property manager
          propertyManager.addProperty((Property)board[i]);
          //System.out.println(board[i].getName());
        }

        // Community Chest
        else if (type.equals("CommunityChest")) {
          board[i] = new CommunityChest(this);
        }

        // Chance
        else if (type.equals("Chance")) {
          board[i] = new Chance(this);
        }

        // Railroad
        else if (type.equals("Railroad")) {
          // Variables required
          String name;
          int cost, rent;

          // Reading variables
          name = input.readLine();
          cost = Integer.parseInt(input.readLine());
          rent = Integer.parseInt(input.readLine());

          // Constructor for Railroad
          board[i] = new Railroad(name, cost, rent);
          // Add to property manager
          propertyManager.addProperty((Property)board[i]);
          //System.out.println(board[i].getName());
        }

        // Utiity
        else if (type.equals("Utility")) {
          // Variables required
          String name;
          int cost, rent;

          // Reading variables
          name = input.readLine();
          cost = Integer.parseInt(input.readLine());
          rent = Integer.parseInt(input.readLine());

          // Constructor for Utility
          board[i] = new Utility(name, cost, rent);
          // Add to property manager
          propertyManager.addProperty((Property)board[i]);
          //System.out.println(board[i].getName());
        }

        // Income Tax
        else if (type.equals("IncomeTax")) {
          // next line is the percentage
          board[i] = new IncomeTax(Double.parseDouble(input.readLine()));
        }

        // Luxury Tax
        else if (type.equals("LuxuryTax")) {
          // next line is the amount
          board[i] = new LuxuryTax(Integer.parseInt(input.readLine()));
        }

        // anything else (blank gametile)
        else {
          // the name will just be the type (whatever it is)
          board[i] = new GameTile(type);
        }

        // Reading the blank line after property has been read
        input.readLine();
      }
    }
    catch (IOException iox) {
      System.out.println("Error accessing property list file");
    }
  }

  public int findMovement(int destination, int location) {
    if (destination < location) {
      return destination - location + NUM_TILES;
    } else {
      return destination - location;
    }
  }

  public void move(int movement) {

   Player player = ((Player)players.get(currentPlayerIndex));
   int location = player.getLocation();

   if (location == 0) {
      ((GoTile)board[0]).passGo(player);
   }

   if (movement >= 1 && location == NUM_TILES-1) {
      player.setLocation(0);
      move(movement-1);
   } else if (movement == 1) {
      player.setLocation(player.getLocation() + 1);
   } else if (movement >= 1) {
      player.setLocation(player.getLocation() + 1);
      move(movement-1);
   }

  }

  /**
   * Adds a new player to the playerslist
   * @author Bicheng
   * @param name the name of the person to add
   * @param cash the cash they start off with
   */
  public void addPlayer(String name, int cash){
    players.add(new Player(name, cash));
  }

  /**
   * Removes a player from the playerslist
   * @author Bicheng
   * @param person the person to remove
   */
  public void removePlayer(Player person){
    players.remove(players.indexOf(person));
  }

  /**
   * Rolls both dice
   * @author Bicheng
   */
  public void rollDice(){
    die1.roll();
    die2.roll();
    //CALL DOUBLES METHOD TO CHECK
    roll = true;
    doubles();
    move(die1.getLastRoll() + die2.getLastRoll());
  }

  /**
   * Ends the player's turn
   * @author Bicheng
   */
  public void endTurn(){
    if(currentPlayerIndex < players.size() - 1){
      currentPlayerIndex++;
    } else {
      currentPlayerIndex = 0;
    }

    roll = false;
  }


  /**
   * Saves the current game
   * @author Zain
   */
  public void save() {
    BufferedWriter pen;

    try {
      pen = new BufferedWriter(new FileWriter(savedGameFile));

      // Looping through all players
      for (int i = 0; i < players.size(); i++) {
        Player current = (Player)players.get(i);
        // Writing the player's name, cash, location, number of utilities, and number of railroads
        pen.write(current.getName());
        pen.newLine();
        pen.write(current.getCash() + "");
        pen.newLine();
        pen.write(current.getLocation() + "");
        pen.newLine();
        pen.write(current.getNumUtilities() + "");
        pen.newLine();
        pen.write(current.getNumRR() + "");
        pen.newLine();

        // Player's properties

        // accessing the player's propertyList in their property manager
        Property[] propertyList = current.getPropertiesOwned().getPropertyList();

        // looping through properties
        for (int k = 0; k < propertyList.length; k++) {
          pen.write(propertyList[k].getName());
          pen.newLine();
          // if it is an estate then the number of houses needs to be saved
          if (propertyList[k] instanceof Estate) {
            pen.write(((Estate)propertyList[k]).getNumHouses());
            pen.newLine();
          }
        }

        // blank line after this player's info has been saved
        pen.newLine();
      }
    } catch (IOException iox) {
      System.out.println("Error saving game (writing to file)");
    }
  }


  /**
   * Draws the player on the game board (given the location to draw them on)
   * @author Zain
   * @param player; the player to move
   * @param location the location to draw the player on
   */
  public void drawPlayer(Player player, int location) {

  }

  /**
   * Checks if a die has been rolled
   */
  public boolean rollCheck() {
    return !roll;
  }

  /**
   * checks if a double was rolled
   * @author Bicheng
   */
  public void doubles(){
    if (die1.compareTo(die2) == 0){
      roll = false;
    } else {
      roll = true;
    }
  }

  /**
   * Sorts players by name (alphabetical, ascending)
   * uses bubble sort
   * @author Zain
   * @return Player[]
   */
  public Player[] sortPlayersByName() {
    Player[] players = getPlayers();
    boolean sorted = false;

    // outer loop
    while (!sorted) {
      sorted = true;
      // loop through players
      for (int i = 0; i < players.length - 1; i++) {
        if (players[i].getName().compareTo(players[i + 1].getName()) > 0) {
          // switch elements
          Player temp = players[i];
          players[i] = players[i + 1];
          players[i + 1] = temp;
          sorted = false;
        }
      }
    }

    // players is now sorted
    return players;
  }

  /**
   * Sorts players by cash (ascending)
   * uses bubble sort
   * @author Zain
   * @return Player[]
   */
  public Player[] sortPlayersByCash() {
    Player[] players = getPlayers();
    boolean sorted = false;

    // outer loop
    while (!sorted) {
      sorted = true;
      // loop through players
      for (int i = 0; i < players.length - 1; i++) {
        if (players[i].getCash() > players[i + 1].getCash()) {
          // switch elements
          Player temp = players[i];
          players[i] = players[i + 1];
          players[i + 1] = temp;
          sorted = false;
        }
      }
    }

    // players is now sorted
    return players;
  }

  /**
   * Sorts players by Properties owned (ascending)
   * uses bubble sort
   * @author Zain
   * @return Player[]
   */
  public Player[] sortPlayersByPropertiesOwned() {
    Player[] players = getPlayers();
    boolean sorted = false;

    // outer loop
    while (!sorted) {
      sorted = true;
      // loop through players
      for (int i = 0; i < players.length - 1; i++) {
        if (players[i].getPropertiesOwned().getPropertyList().length > players[i + 1].getPropertiesOwned().getPropertyList().length) {
          // switch elements
          Player temp = players[i];
          players[i] = players[i + 1];
          players[i + 1] = temp;
          sorted = false;
        }
      }
    }

    // players is now sorted
    return players;
  }

  public Player searchPlayer(String name) {
    Player[] players = getPlayers();

    for (int i = 0; i < players.length; i++) {
      if (players[i].getName().equals(name)) {
        return players[i];
      }
    }

    return null;

  }


}
