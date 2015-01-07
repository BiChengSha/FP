import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

class NotificationWindow extends JFrame
{
  JPanel panel = new JPanel();
  JTextArea label;
  
  // constructor
  NotificationWindow( String title, String message )
  {
    super( title );                      // invoke the JFrame constructor
    
    //setLayout( new FlowLayout() );       // set the layout manager
    label = new JTextArea(message);  // construct a JLabel
    label.setEditable(false);
    label.setBackground(null);
    label.setLineWrap(true);
    label.setWrapStyleWord(true);
    add( label );                        // add the label to the JFrame
    
    JButton exit  = new JButton("OK"); // reference to the button object
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(label);
    panel.add(exit);
    
    exit.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    add( panel );
    
    setSize( 400, 175 );
    setVisible(true);
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   

  }
  
} 
