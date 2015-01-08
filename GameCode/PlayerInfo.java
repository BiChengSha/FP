/*
 *
 * @Author: Matias G
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PlayerInfo extends JFrame implements ActionListener {
   
   //Layout for player info and list of players
   JPanel information = new JPanel();
   
   //Player info
   JTextArea playerInfo = new JTextArea(6, 25);
   JPanel infoLayout = new JPanel();
   
   //List of players
   String[] playerNames;
   JPanel playerLayout = new JPanel();
   JList players;
   JButton back = new JButton("Default");
   
   //Search bar
   JPanel searchBar = new JPanel();
   JLabel instruction = new JLabel("Enter player name:  ");
   JTextField input = new JTextField(10);
   JButton search = new JButton("Search");
   
   //Radio Button label
   JPanel buttonGroup = new JPanel();
   ButtonGroup radButtons = new ButtonGroup();
   
   //Radio Buttons for sorting
   JRadioButton sortAlph = new JRadioButton("Sort Alphabetically", false); 
   JRadioButton sortCash = new JRadioButton("Sort by Cash", false);
   JRadioButton sortNumProp = new JRadioButton("Sort by number of properties", false);
   
   //Variables
   GameManager manager;
   Player[] playerList;
   Player player = null;
   int index = -1;
   
   /*
    * Contructor
    * @Author: Matias G
    */
   public PlayerInfo(GameManager temp) {
      
      super("Player info");
      
      //Passes on the GameManager
      manager = temp;
      
      //Creates the array for players
      playerList = manager.getPlayers();
      
      //Creates the array of string for the JList
      playerNames = new String[playerList.length];
      
      //Fills the array with the player names
      for (int i = 0; i < playerList.length; i++) {
         playerNames[i] = playerList[i].getName();
      }
      
      //Creates the JList
      players = new JList(playerNames);
      
      //Sets the layout for the frame
      FlowLayout tempLayout = new FlowLayout();
      tempLayout.setVgap(20);
      setLayout(tempLayout);
      
      //Sets action commands
      sortAlph.setActionCommand("alph");
      sortCash.setActionCommand("cash");
      sortNumProp.setActionCommand("prop");
      search.setActionCommand("search");
      back.setActionCommand("default");
      
      /*
       * Search bar panel
       */
      
      searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));     //Sets the layout of the panel
      
      input.setMaximumSize(input.getPreferredSize());    //Minimizes the textfield to a preferred size
      
      //Adds components to the panel
      searchBar.add(instruction);
      searchBar.add(input);
      searchBar.add(search);
      
      /*
       * Radio buttons layout
       */
       
      buttonGroup.setLayout(new BoxLayout(buttonGroup, BoxLayout.Y_AXIS));
      
      //Creates the group of buttons
      radButtons.add(sortAlph);
      radButtons.add(sortCash);
      radButtons.add(sortNumProp);
      
      //Adds the buttons and a label to a panel
      buttonGroup.add(new JLabel("For sorting the list of players below"));
      buttonGroup.add(Box.createRigidArea(new Dimension(1, 5)));
      buttonGroup.add(sortAlph);
      buttonGroup.add(sortCash);
      buttonGroup.add(sortNumProp);
      
      /*
       * Bottom panel in the window
       */
       
      //Setting the layout for the panels     
      information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));
      playerLayout.setLayout(new BoxLayout(playerLayout, BoxLayout.Y_AXIS));
      infoLayout.setLayout(new BoxLayout(infoLayout, BoxLayout.Y_AXIS));
      
      players.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);    //Test the selection of the JList to a single selection
      
      //Places the JList and a label together
      playerLayout.add(new JLabel("Players"));
      playerLayout.add(Box.createRigidArea(new Dimension(1, 10)));
      playerLayout.add(players);
      
      //Places the text area with a label together
      infoLayout.add(new JLabel("Player info"));
      infoLayout.add(Box.createRigidArea(new Dimension(1, 10)));
      infoLayout.add(playerInfo);
      playerInfo.setEditable(false);
      
      //Places both previous layouts together
      information.add(playerLayout);
      information.add(Box.createRigidArea(new Dimension(50, 1)));
      information.add(infoLayout);
      
      /*
       * Listener for the JList
       */
       
      ListSelectionListener listener = 
         new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
               
               //Checks if the user is still choosing a player
               if (evt.getValueIsAdjusting()) {
                  return;
               }
               else {
                 
                  JList list = (JList) evt.getSource();     //Gets which JList is being used
               
                  index = list.getSelectedIndex();          //Gets the index in the JList
                  
                  //Checks if index is valid
                  if (index >= 0) {
                     playerInfo.setText(playerList[index].toString());
                  } 
                  //Just in case there was an invalid index
                  else {
                     playerInfo.setText("Try again");
                  }
               }
            
            }
         };
      
      players.addListSelectionListener(listener);     //Adds the listener to the player JList
      
      //Adds the group of components to the window
      add(searchBar);
      add(buttonGroup);
      add(information);
      
      //Action Listeners
      sortAlph.addActionListener(this);
      sortCash.addActionListener(this);
      sortNumProp.addActionListener(this);
      search.addActionListener(this);
      back.addActionListener(this);
      
      //Set operations
      setResizable(false);
      setSize(400, 360);
      setVisible(true);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
   }
   
   /*
    * Refreshes the JList when the user wishes to sort players
    * @Author: Matias G
    */
   public void refresh(Player[] players) {
      for (int i = 0; i < players.length; i++) {
         playerNames[i] = players[i].getName();
      }
      repaint();
   }
   
   /*
    * Actions for the buttons and radio buttons
    * @Author: Matias G
    */
   public void actionPerformed(ActionEvent evt) {
      
      //Sort alphabetically
      if (evt.getActionCommand().equals("alph")) {
         playerList = manager.sortPlayersByName();
         refresh(playerList);
      }
      //Sort by amount of money
      else if (evt.getActionCommand().equals("cash")) {
         playerList = manager.sortPlayersByCash();
         refresh(playerList);
      }
      //Sort by number of properties owned button
       /*else if (evt.getActionCommand().equals("prop")) {
         playerList = manager.sortPlayersByPropertiesOwned();
         refresh(playerList);
       }*/
      //Search button
      else if (evt.getActionCommand().equals("search")) {
         
         player = manager.searchPlayer(input.getText());    //Searches for a player in the list
         
         //Outputs the stats of the player if found
         if (player != null) {
            playerInfo.setText(player.toString());
         }
         //Outputs message if player was not found
         else {
            playerInfo.setText("Player not found");
         }
      }
      
   }
   
}
