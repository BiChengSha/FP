/*
 *
 * @Author: Matias G
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddPlayerWindow extends JFrame implements ActionListener {
   
   //Panels to align the buttons, textfields and labels
   JPanel overall = new JPanel();
   JPanel playerText = new JPanel();
   JPanel cashText = new JPanel();
   
   //Name of player
   JLabel name = new JLabel("Name:  ");
   JTextField addName = new JTextField(10);
   
   //Cash for all players
   JLabel cash = new JLabel("Cash for all players:  ");
   JTextField addCash = new JTextField(10);
   
   //For warning message
   JPanel position = new JPanel();
   JLabel warning = new JLabel("You must set an integer value for cash first");
   JLabel warningCont = new JLabel("and then add at least 2 players");
   JLabel warningCont2 = new JLabel("also you can't add a player with no name");
   JLabel warningCont3 = new JLabel("and there's a maximum of 8 players");
   JButton exit = new JButton("Ok");
   
   //The set cash, add player, and start game buttons
   JButton setCash = new JButton("Set Cash");
   JButton add = new JButton("Add");
   JButton start = new JButton("Start Game");
   
   //Constant
   final static private int MAX_PLAYERS = 8;
   
   //Variables
   AddPlayerWindow warningWindow;
   GameManager manager;
   int cashForPlayers = -1, countPlayers = 0;
   
   
   /*
    * Contructor
    * @Author: Matias G
    */
   public AddPlayerWindow(GameManager temp) {
      
      super("Add Players");
      
      manager = temp;
      
      //Action commands for the 3 buttons
      setCash.setActionCommand("set");
      add.setActionCommand("add");
      start.setActionCommand("start");
      
      //Label and textfield for player
      playerText.setLayout(new BoxLayout(playerText, BoxLayout.X_AXIS));
      //Label and textfield for cash
      cashText.setLayout(new BoxLayout(cashText, BoxLayout.X_AXIS));
      
      //Adds the label and textfield
      playerText.add(name);
      playerText.add(addName);
      
      cashText.add(cash);
      cashText.add(addCash);
      
      //Layout
      overall.setLayout(new BoxLayout(overall, BoxLayout.Y_AXIS));
      
      //Adds player textfield layout and button
      overall.add(playerText);
      overall.add(add);
      
      overall.add(Box.createRigidArea(new Dimension(1, 20)));
      
      //Adds cash textfield layout and button
      overall.add(cashText);
      overall.add(setCash);
      
      overall.add(Box.createRigidArea(new Dimension(1, 20)));
      
      //Adds the start game button
      overall.add(start);
      
      //Aligns everything to the center
      overall.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      //Sets action listeners
      setCash.addActionListener(this);
      add.addActionListener(this);
      start.addActionListener(this);
      
      add(overall);
      
      setResizable(false);    //Players cannot resize the window
      
      setSize(400, 200);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
   public void actionPerformed(ActionEvent evt) {
      
      //Add player button
     if (evt.getActionCommand().equals("add")) {
       //Checks if the set cash is valid, the name is valid, and the max number of player was reached
       if (cashForPlayers >= 0 && !addName.getText().equals("") && countPlayers < MAX_PLAYERS) {
         manager.addPlayer(addName.getText(), cashForPlayers);    //Adds player to the players list
         countPlayers++;      //Counts players
         addName.setText(""); //Resets text
       } 
       //Warning message
       else if (cashForPlayers < 0) {
         new NotificationWindow("Warning", "You can't add a player without setting the cash first and it needs to be a positive integer or 0");
       }  else if (countPlayers == 8){
         new NotificationWindow("Warning", "You can't add more than 8 players");
       } else {
         new NotificationWindow("Warning", "You can't add a player with no name");
       }
      //Set cash button
     } else if (evt.getActionCommand().equals("set")) {
         try {
            if (Integer.parseInt(addCash.getText()) >= 0) {
               cashForPlayers = Integer.parseInt(addCash.getText());
               addCash.setEditable(false);
            }
         }
         //Warning message
         catch (NumberFormatException iox) {
            new NotificationWindow("Warning", "You have to set an integer value");
         }
         
      }
      //Start game button
      else if (evt.getActionCommand().equals("start")) {
         if (countPlayers >= 2) {
            dispose();
            //start game
            new GameWindow(manager);
            
         }
         //Warning message
         else {
           new NotificationWindow("Warning", "You have to add at least 2 players");
         }
      }
      
   }
   

}
