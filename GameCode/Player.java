/*
 * Name: Matias Gonzalez
 * Date: 
 * Class: ICS4U1-03
 * Teacher: 
 * Description: The player class for our monopoly game, it handels player related performances?
 */
 
public class Player {
   
   private String name;
   private int cash;
   private PropertyManager propertiesOwned;
   private int location;
   private int numUtilities;
   private int numRR;
   
   
   /**
    * Constructors
    * @Author: Matias G
    */
   
   //For starting a new game
   public Player(String name, int cash) {
      this.name = name;
      this.cash = cash;
      propertiesOwned = new PropertyManager();
      location = 0;
      numUtilities = 0;
      numRR = 0;
   }
   
   //For loading a game
   public Player(String name, int cash, int location, int utilities, int railroads) {
      this.name = name;
      this.cash = cash;
      this.location = location;
      numUtilities = utilities;
      numRR = railroads;
   }
   
   /**
    * Accessors
    * @Author: Matias G
    */
    
   public String getName() {
      return name;
   }
   
   public int getCash() {
      return cash;
   }
   
   public PropertyManager getPropertiesOwned() {
      return propertiesOwned;
   }
   
   public int getLocation() {
      return location;
   }
   
   public int getNumUtilities() {
      return numUtilities;
   }
   
   public int getNumRR() {
      return numRR;
   }
   
   
   /**
    * Mutators
    * @Author: Matias G
    */
   
   public void setName(String name) {
      this.name = name;
   }
   
   public void setCash(int cash) {
      this.cash = cash;
   }
   
   public void setPropertiesOwned(PropertyManager properties) {
      propertiesOwned = properties;
   }
   
   public void setLocation(int location) {
      this.location = location;
   }
   
   public void setNumUtilities(int utilities) {
      numUtilities = utilities;
   }
   
   public void setNumRR(int railroads) {
      numRR = railroads;
   }
   
   /**
    * Calculates the rent that the player has to pay***********
    * @Author: Matias G
    */
    
   public boolean transferCash(Player rival, int money) {
      //Checks if rival has enough cash
      if (rival.cash >= money) {
         //Adds money to player and removes money from other player
         cash += money;
         rival.setCash(rival.cash - money);
         
         return true;
      //Otherwise returns false
      } else {
         return false;
      }
   }
   
   /**
    * Lists all properties owned by the player****** How is it going to work for GUI
    * @Author: Matias G
    */
    
   public String listOwnedProperties() {
      return propertiesOwned.listAllProperties();
   }
   
   /**
    * Calculates the amount of cash the player can possibly have by selling everything
    * @Author: Matias G
    */
   
   public int netWorth() {
      int temp = 0;
      //Lol sorry i'm not sure about the instances and extentions im confuzzeled
      for (int i = 0; i < propertiesOwned.properties.length; i++) {
         //Adds the cost of the property
         temp += propertiesOwned.properties[i].getCost();
         //Checks if there could be any houses in the property
         if (propertiesOwned.properties[i] instanceof Estate) {
            temp += propertiesOwned.properties[i].getIncreasePerHouse() * propertiesOwned.properties[i].getNumHouses();
         }
      }
      //Adds the cash
      temp += cash;
      return temp;
   }
   
   /**
    * Comapres the amount of cash between two palyers
    * @Author: Matias G
    */
   
   public int compareCash(Player rival) {
      return cash - rival.cash;
   }
   
   /**
    * Comapres the amount of properties between two players
    * @Author: Matias G
    */
   
   public int comparePropertiesOwned(Player rival) {
      //Same here :D
      return propertiesOwned.properties.length - rival.propertiesOwned.properties.length;
   }
   
   /**
    * Compares the amount of net worth between two players
    * @Author: Matias G
    */
    
   public int compareNetWorth(Player rival) {
      return netWorth() - rival.netWorth();
   }
   
   /**
    * toString method for easy output of what the class contains
    * @Author: Matias G
    */
   
   public String toString() {
      return "Name:  " + name + "\nCash:  " + cash + "\nLocation:  " + location + "\nNumber of utilities
   }  
   
   
}
