import javax.swing.*;

public class GameRunner {
  public static void main(String[] args) {
    
    // System Look and feel
    try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
    } 
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }
    
    GameManager manager = new GameManager();
    
    MainMenu mainWindow = new MainMenu(manager);
    

  }
}
