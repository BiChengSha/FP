import java.awt.*; 
import javax.swing.*;
public class PropertyWindow{
  
  class ButtonFrame extends JFrame
{
  JButton bChange ; // reference to the button object

  // constructor for ButtonFrame
  ButtonFrame(String title) 
  {
    super( title );                     // invoke the JFrame constructor
    setLayout( new FlowLayout() );      // set the layout manager

    bChange = new JButton("Click Me!"); // construct a JButton
    add( bChange );                     // add the button to the JFrame
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
  }
}
  public class ButtonDemo
{
  public static void main (String[]args){
    JFrame frame1 = new JFrame("Properties");
    frame1.setSize(1024, 768);
    frame1.setVisible(true);
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
      ButtonFrame frm = new ButtonFrame("Button Demo");
      
      frm.setSize( 150, 75 );     
      frm.setVisible( true );   
    }
  }
}
