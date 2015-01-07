//*** NOTES ***
// Another addPlayer(String, int, int, int, int) method with parameters for the second constructor (to be used in the loadGame() method)
// Suggest removing doubles() methd; i don't know what we'll do with it

/**
 * Authors: Zain, BiCheng
 * GameManager class
 * Started Dec. 30
 */

import java.io.*;

public class GameManager {
  /**
   * Number of Tiles on the board
   */
  private final int NUM_TILES = 40;

  /**
   * The Game Board array which holds all the tiles in order
   */
  private GameTile[] board;

  /**
   * PropertyManager instance which keeps track of all the purchasable properties in the game
   */
  private PropertyManager propertyManager;

  /**
   * The List of players currently in the game
   */
  private Arraylist players;

  /**
   * The two dice which are used in the game
   */
  private Die die1;
  private Die die2;

  /**
   * The player (determined by the index in the arraylist) whose turn it is
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

  // property manager
  public PropertyManager getPropertyManager() {
    return propertyManager;
  }

  //players - this one returns an array (not an arraylist)
  public Player[] getPlayers() {
    Player[] temp = new Player[players.size()];
    // initializing array
    for (int i = 0; i < temp.length; i++) {
      temp[i] = players.get(i);
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
    propertyManager = new PropertyManager();
    players = new ArrayList();
    initializeProperties();
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

        // placing new player in the arraylist
        Player newPlayer = new Player(name, cash, location, utilities, railroads);
        players.add(newPlayer);

        /* Looping through the properties that this player owns. The name variable will
           now hold the name of property. The loop will exit when this variable holds a blank line */
        while (!(name = input.nextLine()).equals("")) {
          // finding the property with this name
          Property temp = propertyManager.searchPropertiesByName(name);
          // making the owner this player
          temp.setOwner(newPlayer);
          // number of houses (if it is an estate)
          if (temp instanceof Estate) {
            temp.setNumHouses(Integer.parseInt(input.readLine()));
          }
          // adding this property to the player's property manager
          newPlayer.getPropertiesOwned.addProperty(temp);
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

      // looping the number of times required to fill in the array
      // It is assumed that the number of properties in the file are the exact number needed
      for (int i = 0; i < NUM_TILES; i++) {
        // Property Type
        type = input.readline();

        // Determining the type of property
        // All properties are added to board, purchaseable properties are added to propertyManager as well
        // Go
        if (type.equals("Go")) {
          board[i] = new GoTile();
        }

        // Estate
        else if (type.equals("Estate")) {
          // Variables required
          String name;
          int group, num_in_group; cost, rent, rent_increase;

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
          propertyManager.addProperty(board[i]);
        }

        // Community Chest
        else if (type.equals("CommunityChest")) {
          board[i] = new CommunityChest();
        }

        // Chance
        else if (type.equals("Chance")) {
          board[i] = new Chance();
        }

        // Railroad
        else if (type.equals("Railroad")) {
          // Variables required
          String name;
          int cost, rent;

          // Reading variables
          name = input.readLine();
          cost = input.readLine();
          rent = input.readLine();

          // Constructor for Railroad
          board[i] = new Railroad(name, cost, rent);
          // Add to property manager
          propertyManager.addProperty(board[i]);
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
          propertyManager.addProperty(board[i]);
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

  /**
   * Adds a new player to the arraylist
   * @author Bicheng
   * @param name the name of the person to add
   * @param cash the cash they start off with
   */
  public void addPlayer(String name, int cash){
    players.add(new Player(name, cash));
  }

  /**
   * Removes a player from the arraylist
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
    move(players.get(currentPlayerIndex), (die1.lastRoll + die2.lastRoll));
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
        Player current = players.get(i);
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
        Arraylist propertyList = current.getPropertiesOwned().getPropertyList();

        // looping through properties
        for (int i = 0; i < propertyList.size()) {
          pen.write(propertyList.get(i).getName());
          pen.newLine();
          // if it is an estate then the number of houses needs to be saved
          if (propertyList.get(i) instanceof Estate) {
            pen.write(propertyList.get(i).getNumHouses());
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
   * checks if a double was rolled
   * @author Bicheng
   */
  public boolean doubles(){
    if (die1.lastRoll == die2.lastRoll){
      return true;
    } else {
      return false;
    }
  }

  /**
   * Sorts players by name (alphabetical, ascending)
   * uses bubble sort
   * @author Zain
   * @return Player[]
   */
  public Player[] sortPlayersByName() {
    Player[] array = getPlayers();
    boolean sorted = false;

    // outer loop
    while (!sorted) {
      sorted = true;
      // loop through array
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i].getName().compareTo(array[i + 1].getName()) > 0) {
          // switch elements
          Player temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          sorted = false;
        }
      }
    }

    // array is now sorted
    return array;
  }

  /**
   * Sorts players by cash (ascending)
   * uses bubble sort
   * @author Zain
   * @return Player[]
   */
  public Player[] sortPlayersByCash() {
    Player[] array = getPlayers();
    boolean sorted = false;

    // outer loop
    while (!sorted) {
      sorted = true;
      // loop through array
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i].getCash() > array[i + 1].getCash()) {
          // switch elements
          Player temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          sorted = false;
        }
      }
    }

    // array is now sorted
    return array;
  }

  /**
   * Sorts players by Properties owned (ascending)
   * uses bubble sort
   * @author Zain
   * @return Player[]
   */
  public Player[] sortPlayersByPropertiesOwned() {
    Player[] array = getPlayers();
    boolean sorted = false;

    // outer loop
    while (!sorted) {
      sorted = true;
      // loop through array
      for (int i = 0; i < array.length - 1; i++) {
        if (array[i].getPropertiesOwned().size() > array[i + 1].getPropertiesOwned().size()) {
          // switch elements
          Player temp = array[i];
          array[i] = array[i + 1];
          array[i + 1] = temp;
          sorted = false;
        }
      }
    }

    // array is now sorted
    return array;
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











