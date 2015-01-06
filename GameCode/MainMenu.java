/*
 * Name: Matias Gonzalez
 *
 *
 */



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame implements ActionListener {
   
   ImageIcon image = new ImageIcon("title.jpg");
   
   JLabel imageHolder = new JLabel("", image, JLabel.CENTER);
   
   JPanel buttons = new JPanel();
   JPanel position = new JPanel();
   
   JButton newGame = new JButton("New Game");
   JButton loadGame = new JButton("Load Game");
   
   GameManager manager;
   
   public MainMenu(GameManager temp) {
      
      super("Menu");
      
      manager = temp;
      
      newGame.setActionCommand("new");
      loadGame.setActionCommand("load");
      
      position.setLayout(new BoxLayout(position, BoxLayout.Y_AXIS));
      
      //Aligns everything
      newGame.setAlignmentX(Component.CENTER_ALIGNMENT);
      loadGame.setAlignmentX(Component.CENTER_ALIGNMENT);
      imageHolder.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      //Adds all objects to a label
      position.add(imageHolder);
      //Separates image and buttons
      position.add(Box.createRigidArea(new Dimension(1, 50)));
      
      buttons.add(newGame);
      buttons.add(loadGame);
      position.add(buttons);
      
      //Tells these buttons to follow the this actionperformed method
      newGame.addActionListener(this);
      loadGame.addActionListener(this);
      
      //Background color
      buttons.setBackground(Color.WHITE);
      position.setBackground(Color.WHITE);
      
      //Adds the overall layout to the frame
      add(position);
      
      setSize(500, 300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }
   
   public void actionPerformed(ActionEvent evt) {
      
      if (evt.getActionCommand().equals("new")) {
         manager.newGame();
      } else {
         //manager.loadGame();
      }
      
   }
   
   /*
   public static void main(String[] args) {
   
      MainMenu window = new MainMenu("Main Menu");
      
      window.setSize(500, 300);
      window.setVisible(true);
   
   }*/
   

}
