import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PlayerInfo extends JFrame /*implements ActionListener*/ {
   
   JPanel overall = new JPanel();
   
   JPanel information = new JPanel();
   
   //Player info
   JTextField playerInfo = new JTextField(25);
   JPanel infoLayout = new JPanel();
   
   //List of players
   String[] temp = {"Matias", "Zain", "David", "BiCheng"};
   JPanel playerLayout = new JPanel();
   JList players = new JList(temp);
   
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
   
   //GameManager manager;
   
   
   public PlayerInfo(String title/*, GameManager temp*/) {
      
      super(title);
      
      //manager = temp;
      
      //players = new JList(manager.getPlayers());
      
      overall.setLayout(new BoxLayout(overall, BoxLayout.Y_AXIS));
      
      //Search bar layout
      searchBar.setLayout(new BoxLayout(searchBar, BoxLayout.X_AXIS));
      
      input.setMaximumSize(input.getPreferredSize());
      
      searchBar.add(instruction);
      searchBar.add(input);
      searchBar.add(search);
      
      //Radio buttons layout
      buttonGroup.setLayout(new BoxLayout(buttonGroup, BoxLayout.Y_AXIS));
      
      radButtons.add(sortAlph);
      radButtons.add(sortCash);
      radButtons.add(sortNumProp);
      
      buttonGroup.add(new JLabel("Sorts players"));
      buttonGroup.add(Box.createRigidArea(new Dimension(1, 5)));
      buttonGroup.add(sortAlph);
      buttonGroup.add(sortCash);
      buttonGroup.add(sortNumProp);
      
      //Players list and info
      information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));
      playerLayout.setLayout(new BoxLayout(playerLayout, BoxLayout.Y_AXIS));
      infoLayout.setLayout(new BoxLayout(infoLayout, BoxLayout.Y_AXIS));
      
      playerLayout.add(new JLabel("Players"));
      playerLayout.add(Box.createRigidArea(new Dimension(1, 10)));
      playerLayout.add(players);
      
      infoLayout.add(new JLabel("Player info"));
      infoLayout.add(Box.createRigidArea(new Dimension(1, 10)));
      infoLayout.add(playerInfo);
      
      information.add(playerLayout);
      information.add(Box.createRigidArea(new Dimension(50, 1)));
      information.add(infoLayout);
      playerInfo.setEditable(false);
      
      //Overall layout
      overall.add(searchBar);
      overall.add(Box.createRigidArea(new Dimension(1, 25)));
      
      overall.add(buttonGroup);
      overall.add(Box.createRigidArea(new Dimension(1, 25)));
      
      overall.add(information);
      
      add(overall);
      
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      
   }
   
   public static void main (String[] args) {
      
      PlayerInfo test = new PlayerInfo("Players");
      
      test.setSize(500, 500);
      test.setVisible(true);
      
   }
   
}
