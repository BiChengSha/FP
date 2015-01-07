// ***Possible additions***
// after sorting by group sort each group by name
// after sorting by cost sort each cost by name

/**
 * Name(s): Zain
 * Date: Dec.24
 * Class: PropertyManager Class
 * Description: stores properties in an ArrayList and performs actions
 */
import java.util.*;

public class PropertyManager {
 /**
  * Holds all the properties
  */
 private ArrayList propertyList;

 /**
  * Constructor
  * @author Zain
  */
 public PropertyManager() {
  propertyList = new ArrayList();
 }

 /**
  * Accessor for arraylist
  * @author Zain
  * @return Property[]
  */
 public Property[] getPropertyList() {
  Property[] list = new Property[propertyList.size()];

  for (int i = 0; i < list.length; i++) {
   list[i] = (Property)propertyList.get(i);
  }

  return list;
 }

 /**
  * Searches Properties by their name (unique to each property) using sequential search
  * @author Zain
  * @param name The name of the property
  * @return Property the property which matches the name
  */
 public Property searchPropertiesByName(String name) {
  for (int i = 0; i < propertyList.size(); i++) {
   // checking if this property's name matches the required name
   if (((Property)propertyList.get(i)).getName().equals(name)) {
    // returning the matching property. At this point the program exits the method
    return propertyList.get(i);
   }
  }

  // If the program reaches this point then the property is not in the array, so it return s null
  return null;
 }

 /**
  * Searches properties by group. it needs to return an ArrayList because there may be more than one match
  * Sequential Search
  * @author Zain
  * @param group the group number required
  * @return matches: the array of all matched properties
  */
 public Property[] searchpropertiesByGroup(int group) {
  ArrayList matchedList = new ArrayList();
  Property[] matches;

  // finding all properties in the group
  for (int i = 0; i < propertyList.size(); i++) {
   // only estates are classified into groups
   if (propertyList.get(i) instanceof Estate) {
    if (((Estate)propertyList.get(i)).getGroup() == group) {
     matchedList.add(propertyList.get(i));
    }
   }
  }

  // converting arraylist to array
  matches = new Property[matchedList.size()];
  for (int i = 0; i < matchedList.size(); i++) {
   matches[i] = (Property)matchedList.get(i);
  }

  return matches;
 }

 /**
  * Sorts properties in ascending order by group number
  * uses bubble sort
  * @author Zain
  */
 public void sortPropertiesByGroup() {
  // forwards loop
  for (int i = 1; i < propertyList.size(); i++) {

   Property current = propertyList.get(i);
   int location = i - 1;

   // backwards loop deciding what spot to place this element in
   while(location >= 0) {
    // only estates have groups
    // Non-estate properties (ex. utilities and Railroads) are ignored, and are carried to the end of the list
    if (propertyList.get(location) instanceof Estate) {
     if (((Estate)propertyList.get(location)).getGroup() > current.getGroup()) {
      propertyList.set(location + 1, propertyList.get(location));
     } else {
      // insertion location has been found
      break;
     }
    }
    location --;
   }

   // placing this element at the right location
   propertyList.set(location + 1, current);
  }
 }

 /**
  * Sorts properties by Cost (ascending)
  * Uses bubble sort algorithm
  * @author Zain
  */
 public void sortPropertiesByCost() {
  // boolean switch to check when the list is sorted
  boolean sorted = false;

  // looping until list is sorted
  while (!sorted) {
   sorted = true;
   // looping through list
   for (int i = 0; i < propertyList.size() - 1; i++) {
    if (((Property)propertyList.get(i)).getCost() < ((Property)propertyList.get(i+1)).getCost()) {
     // switching elements of the ArrayList
     Property temp = propertyList.get(i);
     propertyList.set(i, propertyList.get(i+1));
     propertyList.set(i + 1, temp);
     // sorting is not complete
     sorted = false;
    }
   }
  }
 }

 /**
  * Sorts properties by name using bubble sort, alphabetically ascending
  * @author Zain
  */
 public void sortPropertiesByName() {
  // boolean switch, checks when sorting is completed
  boolean sorted = false;

  // loop until sorted
  while (!sorted) {
   sorted = true;
   // loop through list
   for (int i = 0; i < propertyList.size(); i++) {
    if (((Property)propertyList.get(i)).getName().compareTo(((Property)propertyList.get(i+1)).getName()) < 0) {
     // switching
     Property temp = propertyList.get(i);
     propertyList.set(i, propertyList.get(i+1));
     propertyList.set(i + 1, temp);
     // sorting is not complete
     sorted = false;
    }
   }
  }
 }

 /**
  * Adds a property to the ArrayList
  * @author Zain
  * @param property property to add
  */
 public void addProperty(Property property) {
  propertyList.add(property);
 }

 /**
  * removes a property from the ArrayList
  * @author Zain
  * @param property property to remove
  */
 public void removeProperty(Property property) {
  propertyList.remove(property);
 }

 /**
  * returns a string with all properties
  * @author zin
  * @return String
  */
 public String listAllProperties() {
  String temp = "";
  // adding all properties
  for (int i = 0; i < propertyList.size(); i++) {
   temp += propertyList.get(i) + "\n";
  }

  return temp;
 }


}

















