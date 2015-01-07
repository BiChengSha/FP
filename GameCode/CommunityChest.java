import java.util.*;

public class CommunityChest extends GameTile {
  
  Random rand = new Random();
  
  private GameManager manager;
  private String title = "Community Chest";
  private int randCard = rand.nextInt(15);
    
  private String[] messages = {("Advance to Go (Collect $200)"),
    ("Bank error in your favor – Collect $200"),
    ("Doctor's fees – Pay $50"),
    ("From sale of stock you get $50"),
    ("Grand Opera Night – Collect $50 from every player for opening night seats"),
    ("Holiday Fund matures - Receive $100"),
    ("Income tax refund – Collect $20"),
    ("It is your birthday - Collect $10 from each player"),
    ("Life insurance matures – Collect $100"),
    ("Pay hospital fees of $100"),
    ("Pay school fees of $150"),
    ("Receive $25 consultancy fee"),
    ("You are assessed for street repairs – $45 per house"),
    ("You have won second prize in a beauty contest – Collect $10"),
    ("You inherit $100"),  
  };
  
  
  
  public CommunityChest(String name, GameManager manager) {
    super(name);
    this.manager = manager
  }
  
  public void performAction(Player player, int num, GameMananger manager) {
    switch () {
      case 0: // Advance to Go (Collect $200)
        NotificationWindow(title, messages[randCard]);
        
        player.location = 0;
        player.cash = player.getCash() + 200;
        break;
      case 1: // Bank error in your favor – Collect $200
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 200;
        break;
      case 2: // Doctor's fees – Pay $50
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() - 50;
        break;
      case 3: // From sale of stock you get $50
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 50;
        break;
      case 4: // Grand Opera Night – Collect $50 from every player for opening night seats
        NotificationWindow(title, messages[randCard]);
        
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (i != currentPlayerIndex) {
            players[i].cash = player.getCash() - 50;
          }
        }
        player.cash = player.getCash() + ((playerAmount-1)*50);
        break;
      case 5: // Holiday Fund matures - Receive $100
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 100;
        break;
      case 6: // Income tax refund – Collect $20
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 20;
        break;
      case 7: // It is your birthday - Collect $10 from each player
        NotificationWindow(title, messages[randCard]);
        
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (i != currentPlayerIndex) {
            players[i].cash = player.getCash() - 10;
          }
        }
        player.cash = player.getCash() + ((playerAmount-1)*10);
        break;
      case 8: // Life insurance matures – Collect $100
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 100;
        break;
      case 9: // Pay hospital fees of $100
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() - 100;
        break;
      case 10: // Pay school fees of $150
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() - 150;
        break;
      case 11: // Receive $25 consultancy fee
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 25;
        break;
      case 12: // You are assessed for street repairs – $45 per house
        NotificationWindow(title, messages[randCard]);
        
        int numHouses = 0;
        for (int i = 0; i < properties.length; i++) {
          if (properties[i] instanceof Estate) {
            if (properties[i].getOwner().equals(player.getName())) {
              numHouses += properties[i].getNumHouses();
            }
          }
        }
        player.cash = player.getCash() - (numHouses*45);
        break;
      case 13: // You have won second prize in a beauty contest – Collect $10
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 10;
        break;
      case 14: // You inherit $100
        NotificationWindow(title, messages[randCard]);
        
        player.cash = player.getCash() + 100;
        break;
    }
  }
  
}
