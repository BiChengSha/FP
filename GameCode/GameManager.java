//Started by Zain/BiCheng
import java.io.*;
public class GameManager {
  private GameTile[] board;
  private PropertyManager propertyManager;
  private Arraylist players;
  private Die die1;
  private Die die2;
  private int currentPlayerIndex;
  
  //GameManager
  public GameManager(){
    initializeProperties();
  }  
  
  
  //newGame
  public void newGame(){
  }/////////////////////////////////////////////////////////////////////////////////////////
    
//loadGame
  public void loadGame(){
    //DO FILE READER
  }
  
//initializeProperties
  public void initializeProperties(){
    //DO FILE READER
  }
  
  //addPlayer
  
  public void addPlayer(String name, int cash){
    players.add(new Player(name, cash));
  }
  
  //removePlayer
  public void removePlayer(Player person){
    players.remove(players.indexOf(person));
  }
  
  //rollDice return int
  public void rollDice(){
    die1.roll();
    die2.roll();
    //CALL DOUBLES METHOD TO CHECK
    move(players.get(currentPlayerIndex), (die1.lastRoll + die2.lastRoll));
  }
  
//endTurn
  public void endTurn(){
    if(currentPlayerIndex < players.size() - 1){
      currentPlayerIndex++;
    } else {
      currentPlayerIndex = 0;
    }
  }
  
  
  //Save(String)
  
//move(Player, int)
  
  //doubles return bool
  public boolean doubles(){
    if (die1.lastRoll == die2.lastRoll){
      return true;
    } else {
      return false;
    }
  }
}
