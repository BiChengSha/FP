/*
  PropertyWindow Class
  Author: Zain
  Date: Jan. 4
  The window to list, sort and search properties
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PropertyWindow extends JFrame implements ActionListener {
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
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  setLayout(new FlowLayout());
  setResizable(false);

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

  // action commands
  search.setActionCommand("searchName");
  searchNameButton.setActionCommand("searchName");
  searchGroupbutton.setActionCommand("searchGroup");

  // registering action listeners
  search.addActionListener(this);
  searchNameButton.addActionListener(this);
  searchGroupbutton.addActionListener(this);

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

  // action commands
  sortByName.setActionCommand("sortName");
  sortByGroup.setActionCommand("sortGroup");
  sortByCost.setActionCommand("sortCost");

  // registering action listeners
  sortByName.addActionListener(this);
  sortByCost.addActionListener(this);
  sortByGroup.addActionListener(this);

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

  // scrollable list
  list = new JList(propertyNames);
  list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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


  /**
   * Updates the String array "propertyNames" with names of the properties in the property manager
   * @author Zain
   * @param updatedProperties the array of properties which names should be included
   */
  public void updatePropertyNames(Property[] updatedProperties) {
    propertyNames = new String[updatedProperties.length];

    for (int i = 0; i < updatedProperties.length) {
      propertyNames[i] = updatedProperties[i].getName();
    }
  }


  /**
   * Updates the String array "propertyNames" with name of property specified (used by searchByName)
   * @author Zain
   * @param prop: property to list
   */
  public void updatePropertyNames(Property prop) {
    propertyNames = new String[1];

    propertyNames[0] = prop.getName();
  }


  /**
   * Action event handler  (responds to action events)
   * @author Zain
   */
  public void actionPerformed(ActionEvent evt) {
    String command = evt.getActionCommand();

    // search buttons
    if (command.equals("searchName")) {
      updatePropertyNames(manager.searchPropertiesByName(search.getText()));
    }
    else if (command.equals("searchGroup")) {
      updatePropertyNames(manager.searchPropertiesByGroup(Integer.parseInt(search.getText)));
    }

    // sort buttons
    if (command.equals("sortName")) {
      manager.sortPropertiesByName();
      updatePropertyNames(manager.getPropertyList());
    }
    else if (command.equals("sortGroup")) {
      manager.sortPropertiesByGroup();
      updatePropertyNames(manager.getPropertyList());
    }
    else if (command.equals("sortCost")) {
      manager.sortPropertiesByCost();
      updatePropertyNames(manager.getPropertyList());
    }
  }


  /**
   * List selection listener - handles the event triggered when an item in the list is clicked
   * @author Zain
   */
  public void valueChanged(ListSelectionEvent evt) {
    // source is the list "list"

    if (!evt.getValueIsAdjusting()) {
      int index = list.getSelectedIndex();

      propInfo.setText(manager.getPropertyList()[index].toString();
    }
  }
  
}
