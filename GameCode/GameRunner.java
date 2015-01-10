import java.awt.*;
import javax.swing.*;

public class GameRunner {
  public static void main(String[] args) {
  // code copied from oracle website
  	 try {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
            UIManager.getCrossPlatformLookAndFeelClassName());
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

	 mainWindow.pack();

  }
}
