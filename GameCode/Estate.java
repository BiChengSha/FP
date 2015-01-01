/*
 * Name: Matias Gonzalez
 * Date: 
 * Class: ICS4U1-03
 * Teacher: 
 * Description: The estate class is a type of property that includes the number of houses and a monopoly group, performs different calculations and it's more complex (idk)
 */
 
public class Estate extends Property {
   
   private static final int MAX_HOUSES = 5;
   
   private int increasePerHouse;
   private int numHouses;
   private int group;
   private int numInGroup;
   
   
   /**
    * Constructor
    * @Author: Matias G
    */
    
   public Estate(String name, int group, int numInGroup, int cost, int baseRent, int increasePerHouse) {
      super(name, baseRent, cost);
      this.increasePerHouse = increasePerHouse;
      numHouses = 0;
      this.group = group;
      this.numInGroup = numInGroup;
   }
   
   /**
    * Accessors
    * @Author: Matias G
    */
    
   public int getIncreasePerHouse() {
      return increasePerHouse;
   }
   
   public int getNumHouses() {
      return numHouses;
   }
   
   public int getGroup() {
      return group;
   }
   
   
   /**
    * Mutators
    * @Author: Matias G
    */
   
   public void setIncreasePerHouse(int increasePerHouse) {
      this.increasePerHouse = increasePerHouse;
   }
   
   public void setNumHouses(int numHouses) {
      this.numHouses = numHouses;
   }
   
   public void setGroup(int group) {
      this.group = group;
   }
   
   /*
    * Calculates the rent that the player has to pay
    * @Author: Matias G
    */
    
   public int calculateRent() {
      //Checks if owner has monopoly and doesn't contain houses to multiply the rent by 2
      if (checkMonopoly() && numHouses == 0) {
         return  baseRent * 2;
      //Checks if owner has a house to calculate rent accordingly
      } else if (numHouses > 0) {
         return baseRent + numHouses*increasePerHouse;
      //Returns the base rent of the property if owner doesn't have any bonuses
      } else {
         return baseRent;
      }
   }
   
   /**
    * Checks if owner of property has monopoly for that property
    * @Author: Matias G
    */
   
   public boolean checkMonopoly() {
      int temp = 0;
      //Sorry i forgot how to do this properly
      for (int i = 0; i < owner.getPropertiesOwned().properties.length; i++) {
         //Checks if owned property belongs to Estate
         if (owner.getPropertiesOwned().properties.get(i) instanceof Estate) {
            //Checks if the property belongs in the group
            if (owner.getPropertiesOwned().properties.get(i).getGroup() == group) {
               temp++;
            }
         }
      }
      
      //Checks if player has all the properties from that group
      if (temp == numInGroup) {
         return true;
      } else {
         return false;
      }
      
      
   }
   
   /**
    * Purchases a house of the property
    * @Author: Matias G
    */
   
   public boolean purchaseHouse() {
      //Checks if any more houses can be purchased and if the owner has enough cash
      if (houseAllowed() && owner.getCash() >= increasePerHouse) {
         //Sets cash for owner as well as increasing the number of houses
         owner.setCash(owner.getCash() - increasePerHouse);
         numHouses++;
         
         return true;
      //If owner fails to be able to purchase then returns false
      } else {
         return false;
      }
   }
   
   /**
    * Checks if any more houses can be purchased
    * @Author: Matias G
    */
   
   public boolean houseAllowed() {
      return (numHouses < MAX_HOUSES);
   }
   
   /**
    * Sells a house in the property
    * @Author: Matias G
    */
   
   public boolean sellHouse() {
      //Checks if user can sell a house
      if (numHouses > 0) {
         //Sets cash for owner and decreases the number of houses
         owner.setCash(owner.cash + increasePerHouse);
         numHouses--;
         
         return true;
      //Otherwise returns false
      } else {
         return false;
      }
   }
   
   /**
    * toString method for easy output of information
    * @Author: Matias G
    */
   
   public String toString() {
      return super.toString() + "\nRent increased per house:  " + increasePerHOuse + "\nNumber of Houses:  " + numHouses + "\nGroup:  " + group;
   }
   
}
