/*
 * Author(s): Zain
 * Date: Dec. 20
 * Description: Main window for the Monopoly Program, holding the game board and player options
 * GUI CLASS
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame implements ActionListener{
  /**
   * The width of the main window
   */
  private int sizex = 700;
  
  /**
   * Height of the main window
   */
  private int sizey = 900;
  
  /**
   * Game Manager instance 
   */
  GameManager manager;
  
  /**
   * Variables for drawing board
   */
  
  private JPanel board;
  private JLabel imageHolder;
  private ImageIcon image;
  
  /**
   * Variables for Drawing options
   */
  private JPanel holder;
  private JPanel infoPanel;
  private JButton purchase;
  
  private JPanel optionButtons;
  private JButton endTurn;
  private JButton viewAllProperties;
  private JButton viewOwnedProperties;
  private JButton playerStats;
  private JButton saveGame;
  private JButton endGame;
  
  /**
   * Text Area to put property info into
   * Can be edited by external classes to update the text it shows.
   */
  public JTextArea propertyInfo;
  
  /**
   * Class Constructor
   * Creates the window, draws the board and buttons
   * @author Zain
   * @param title Title of the window
   */
  public GameWindow(String title, GameManager man) {
    // calling the superclass constructor which is the JFrame constructor
    super(title);
    // Game manager
    // specifications of the window
    setSize(sizex, sizey);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(true);
    setLayout(new GridLayout(2, 1));
    
    // drawing the game board
    drawBoard();
    
    // drawing game options section (under board)
    drawOptions();
    
    setVisible(true);
  }
  
  /**
   * Draws Game Board Panel
   * @author Zain
   */
  public void drawBoard() {
    // board holds the image. BorderLayout is used so that the image can be centered
    board = new JPanel(new BorderLayout());
    image = new ImageIcon("monopoly2.jpg");
    imageHolder = new JLabel("", image, JLabel.CENTER);
    
    board.setSize(sizex, sizey/2);
    // add image to jpanel
    board.add(imageHolder, BorderLayout.CENTER);
    // add Jpanel to JFrame
    add(board);
  }
  
  /**
   * Draws the game options panel
   * @author Zain
   */
  public void drawOptions() {
    holder = new JPanel(new BorderLayout());
    
    infoPanel = new JPanel();
    infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
    // 3/4 the width and half the height
    infoPanel.setSize(sizex * 3 / 4, sizey / 2);
    // property info label
    propertyInfo = new JTextArea("Property Info:", 10, 40);
    propertyInfo.setMaximumSize(new Dimension(400, 275));
    propertyInfo.setEditable(false);
    infoPanel.add(propertyInfo);
    // purchase button
    purchase = new JButton("Purchase This Property");
    purchase.setAlignmentX(Component.CENTER_ALIGNMENT);
    infoPanel.add(purchase);
    
    holder.add(infoPanel, BorderLayout.LINE_START);
    
    // Now for the buttons
    // components
    optionButtons = new JPanel();
    optionButtons.setLayout(new BoxLayout(optionButtons, BoxLayout.PAGE_AXIS));
    viewAllProperties = new JButton("View All Properties");
    viewAllProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
    viewOwnedProperties = new JButton("View Owned Properties");
    viewOwnedProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
    endTurn = new JButton("End Turn");
    endTurn.setAlignmentX(Component.CENTER_ALIGNMENT);
    playerStats = new JButton("View Player Stats");
    playerStats.setAlignmentX(Component.CENTER_ALIGNMENT);
    saveGame = new JButton("Save Game");
    saveGame.setAlignmentX(Component.CENTER_ALIGNMENT);
    endGame = new JButton("End Game");
    endGame.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    optionButtons.setSize(sizex / 4, sizey / 2);
    
    // Action commands
    purchase.setActionCommand("purchase");
    viewAllProperties.setActionCommand("viewAllProp");
    viewOwnedProperties.setActionCommand("viewOwnedProp");
    endTurn.setActionCommand("endTurn");
    playerStats.setActionCommand("playerStats");
    saveGame.setActionCommand("saveGame");
    endGame.setActionCommand("endGame");
    
    // Adding action listeners to buttons
    purchase.addActionListener(this);
    viewAllProperties.addActionListener(this);
    viewOwnedProperties.addActionListener(this);
    endTurn.addActionListener(this);
    playerStats.addActionListener(this);
    saveGame.addActionListener(this);
    endGame.addActionListener(this);
    
    // adding everything
    optionButtons.add(endTurn);
    optionButtons.add(viewAllProperties);
    optionButtons.add(viewOwnedProperties);
    optionButtons.add(playerStats);
    optionButtons.add(saveGame);
    optionButtons.add(endGame);
    
    holder.add(optionButtons, BorderLayout.LINE_END);
    
    add(holder);
  }
  
  
  /**
   * Handles all the events (button clicks, etc)
   * @author Zain
   */
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    
    if (command.equals("purchase")) {
      // purchase button
      
    } else if (command.equals("viewAllProp")) {
      // opening the property window
      PropertyWindow propWindow = new PropertyWindow(manager);
      
    } else if (command.equals("viewOwnedProp") {
      // opening the  property wqindow with player's properties
      PropertyWindow propWindow;
      
      // getting the current player's property manager
      Player[] players = manager.getPlayers();
      PropertyManager propManager = players[manager.getCurrentPlayerIndex()].getPropertiesOwned();
      
      // opening the property window
      propWindow = new PropertyWindow(propManager);
      
    } else if (command.equals("playerStats")) {
      // Player info
      PlayerInfo playerInfo = new PlayerInfo("Player Info", manager);
      
    } else if (command.equals("saveGame")) {
      // save the game
      manager.save();
      
    } else if (command.equals("endGame") {
      // end the game
      manager.endGame();
    }
               
  }
}

