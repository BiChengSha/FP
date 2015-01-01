/*
 * Author(s): Zain
 * Date: Dec. 20
 * Description: Main window for the Monopoly Program, holding the game board and player options
 * GUI CLASS
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameWindow extends JFrame {
	/**
	 * The width of the main window
	 */
	private int sizex = 700;

	/**
	 * Height of the main window
	 */
	private int sizey = 900;

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
	public GameWindow(String title) {
		// calling the superclass constructor which is the JFrame constructor
		super(title);
		// specifications of the window
		setSize(sizex, sizey);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setLayout(new GridLayout(2, 1));

		// drawing the game board

			// JPanel p = new JPanel(new BorderLayout());
			// ImageIcon icon = new ImageIcon("monopoly2.jpg");
			// p.add(new JLabel("", icon, JLabel.CENTER), BorderLayout.CENTER);
			// add(p);

		drawBoard();

		// drawing game options section (under board)
		drawOptions();
	}

	/**
	 * Draws Game Board Panel
	 * @author Zain
	 */
	public void drawBoard() {
			//add(new GameBoard(sizex, sizey));

			// JPanel p = new JPanel(new BorderLayout());
			// ImageIcon icon = new ImageIcon("monopoly2.jpg");
			// p.add(new JLabel("", icon, JLabel.CENTER), BorderLayout.CENTER);
			// add(p);

		JPanel board;
		JLabel imageHolder;
		ImageIcon image;

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
		JPanel holder = new JPanel(new BorderLayout());
		// First drawing the property info panel
		// components
		JPanel infoPanel;
			// Property info text area is a gloabl field
		JButton purchase;

		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.PAGE_AXIS));
		// 3/4 the width and half the height
		infoPanel.setSize(sizex * 3 / 4, sizey / 2);
		// property info label
		propertyInfo = new TextArea("Property Info: ", 10, 40);
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
		JPanel optionButtons = new JPanel();
		optionButtons.setLayout(new BoxLayout(optionButtons, BoxLayout.PAGE_AXIS));
		JButton viewAllProperties = new JButton("View All Properties");
		viewAllProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton viewOwnedProperties = new JButton("View Owned Properties");
		viewOwnedProperties.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton endTurn = new JButton("End Turn");
		endTurn.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton playerStats = new JButton("View Player Stats");
		playerStats.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton saveGame = new JButton("Save Game");
		saveGame.setAlignmentX(Component.CENTER_ALIGNMENT);
		JButton endGame = new JButton("End Game");
		endGame.setAlignmentX(Component.CENTER_ALIGNMENT);

		optionButtons.setSize(sizex / 4, sizey / 2);

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

}
