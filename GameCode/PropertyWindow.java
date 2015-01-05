/*
  PropertyWindow Class
  Author: Zain
  Date: Jan. 4
  The window to list, sort and search properties
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PropertyWindow extends JFrame implements ActionListener{
	/**
	 * The property manager which holds all the properties included in this window
	 */
	private PropertyManager manager;

	/**
	 * Search area variables
	 */
	private JPanel searchPanel;
	private JTextField search;
	private JLabel searchInstruction;
	private JButton searchNameButton;
	private JButton searchGroupbutton;

	/**
	 * Sort options fields
	 */
	private JPanel optionPanel;
	private JRadioButton sortByName;
	private JRadioButton sortByGroup;
	private JRadioButton sortByCost;
	private ButtonGroup options;
	private JLabel sort;

	/**
	 * Info area variables
	 */
	private JPanel infoArea;
	private JTextArea propInfo;
	private JScrollPane scrollPane;
	private JList list;
	String[] propertyNames = {"Prop 1 is a big property", "Prop 2", "Prop 3"};


	/**
	 * COnstructor
	 * JFrame will use flowlayout
	 * @author Zain
	 * @param propertyManager the propertyManager has the complete list of properties to be included
	 */
	public PropertyWindow(PropertyManager properties) {
		// frame specs
		super("Properties");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		//setResizable(false);

		// property manager
		manager = properties;

		// adding search area
		drawSearchArea();

		// adding the sort options
		drawSortOptions();

		// adding the info boxes
		drawInfoArea();

		setVisible(true);
	}

	/**
	 * Draws the search bar and search buttons
	 * @author Zain
	 */
	public void drawSearchArea() {
		searchPanel = new JPanel(new FlowLayout());
		// search box
		search = new JTextField();
		search.setColumns(10);
		// label
		searchInstruction = new JLabel("Search:");
		// option buttons
		searchNameButton = new JButton("Search by Name");
		searchGroupbutton = new JButton("Search by Group");

		// adding everything
		searchPanel.add(searchInstruction);
		searchPanel.add(search);
		searchPanel.add(searchNameButton);
		searchPanel.add(searchGroupbutton);

		// adding this panel
		add(searchPanel);
	}

	/**
	 * Draws the sorting options
	 * @author Zain
	 */
	public void drawSortOptions() {
		optionPanel = new JPanel(new FlowLayout());
		// label
		sort = new JLabel("Sort by:");
		// radiobuttons
		sortByName = new JRadioButton("Sort by Name", false);
		sortByGroup = new JRadioButton("Sort by Group", false);
		sortByCost = new JRadioButton("Sort by Cost", false);
		// adding them to the group
		options = new ButtonGroup();
		options.add(sortByName);
		options.add(sortByGroup);
		options.add(sortByCost);

		// adding radiobuttons (and label) to JPanel
		optionPanel.add(sort);
		optionPanel.add(sortByName);
		optionPanel.add(sortByGroup);
		optionPanel.add(sortByCost);

		// adding the panel to the frame
		add(optionPanel);
	}

	/**
	 * Draws the list of properties and info
	 * @author Zain
	 */
	@SuppressWarnings("unchecked")
	public void drawInfoArea() {
		infoArea = new JPanel(new FlowLayout());
		// Making the Scrollable list
		//propertyNames = {"Prop 1", "Prop 2", "Prop 3"};
		list = new JList(propertyNames);
		scrollPane = new JScrollPane(list);

		// property info
		propInfo = new JTextArea(10, 27);
		propInfo.setEditable(false);

		// adding to panel
		infoArea.add(scrollPane);
		infoArea.add(propInfo);

		// adding to frame
		add(infoArea);
	}

}



