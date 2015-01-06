
/*
 * Name: Matias Gonzalez
 * Date: 4/1/2015
 * Class:
 * Teacher:
 * Description:
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
   JLabel warning = new JLabel("You must set the cash first and then add at least 2 players");
   JButton exit = new JButton("Ok");
   
   //The set cash, add player, and start game buttons
   JButton setCash = new JButton("Set Cash");
   JButton add = new JButton("Add");
   JButton start = new JButton("Start Game");
   
   AddPlayerWindow warningWindow;
   
   int cashForPlayers = -1, countPlayers = 0;
   
   GameManager manager;
   
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
   
   /*public AddPlayerWindow(String title) {
      super(title);
      
      exit.setActionCommand("exit");
      
      position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
      
      position.add(warning);
      position.add(Box.createRigidArea(new Dimension(1, 20)));
      position.add(exit);
      
      warning.setAlignmentX(Component.CENTER_ALIGNMENT);
      exit.setAlignmentX(Component.CENTER_ALIGNMENT);
      position.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      exit.addActionListener(this);
      
      add(position);
      
      setSize(300,100);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      
   }*/
   
   public void actionPerformed(ActionEvent evt) {
      
      if (evt.getActionCommand().equals("add")) {
         if (cashForPlayers >= 0) {
            manager.addPlayer(addName.getText(), cashForPlayers);
            countPlayers++;
            addName.setText("");
         } else {
            //warningWindow = new AddPlayerWindow("Warning!");
         }
      } else if (evt.getActionCommand().equals("set")) {
         if (Integer.parseInt(addCash.getText()) >= 0) {
            cashForPlayers = Integer.parseInt(addCash.getText());
            addCash.setEditable(false);
            //setCash.setActionCommand("denied");
         }
         
      } else if (evt.getActionCommand().equals("start")) {
         if (countPlayers >= 2) {
            dispose();
            //start game
            GameWindow x = new GameWindow(manager);
         } else {
            //Another warning message?
         }
      //For warning messages
      } else if (evt.getActionCommand().equals("exit")) {
         dispose();
      }
      
   }
   
   /*public static void main (String[] args) {
      
      AddPlayerWindow window = new AddPlayerWindow("Add Player", );
      
      window.setSize(400, 200);
      window.setVisible(true);
      
   }*/

}
