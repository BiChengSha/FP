import java.util.*;

public class CommunityChest extends GameTile {
  
  Random rand = new Random();
  
  private GameManager manager;
  private String title = "Community Chest";
  private int randCard = rand.nextInt(15);
    
  private String[] communityCards = {("Advance to Go (Collect $200)"),                          //Index 0
    ("Bank error in your favor â€“ Collect $200"),                                              //Index 1
    ("Doctor's fees â€“ Pay $50"),                                                              //Index 2
    ("From sale of stock you get $50"),                                                         //Index 3
    ("Grand Opera Night â€“ Collect $50 from every player for opening night seats"),            //Index 4
    ("Holiday Fund matures - Receive $100"),                                                    //Index 5
    ("Income tax refund â€“ Collect $20"),                                                      //Index 6
    ("It is your birthday - Collect $10 from each player"),                                     //Index 7
    ("Life insurance matures â€“ Collect $100"),                                                //Index 8
    ("Pay hospital fees of $100"),                                                              //Index 9
    ("Pay school fees of $150"),                                                                //Index 10
    ("Receive $25 consultancy fee"),                                                            //Index 11
    ("You are assessed for street repairs â€“ $45 per house"),                                  //Index 12
    ("You have won second prize in a beauty contest â€“ Collect $10"),                          //Index 13
    ("You inherit $100"),                                                                       //Index 14
  };
  
  
  
  public CommunityChest(String name, GameManager manager) {
    super(name);
    this.manager = manager;
  }
  
  public void performAction(Player player, int num, GameMananger manager) {
    switch (randCard) {
      case 0: // Advance to Go (Collect $200)
        new NotificationWindow(title, communityCards[randCard]);
        
        player.location = 0;
        player.cash = player.getCash() + 200;
        break;
      case 1: // Bank error in your favor â€“ Collect $200
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 200;
        break;
      case 2: // Doctor's fees â€“ Pay $50
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() - 50;
        break;
      case 3: // From sale of stock you get $50
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 50;
        break;
      case 4: // Grand Opera Night â€“ Collect $50 from every player for opening night seats
        new NotificationWindow(title, communityCards[randCard]);
        
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (i != currentPlayerIndex) {
            players[i].cash = player.getCash() - 50;
          }
        }
        player.cash = player.getCash() + ((playerAmount-1)*50);
        break;
      case 5: // Holiday Fund matures - Receive $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 100;
        break;
      case 6: // Income tax refund â€“ Collect $20
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 20;
        break;
      case 7: // It is your birthday - Collect $10 from each player
        new NotificationWindow(title, communityCards[randCard]);
        
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (i != currentPlayerIndex) {
            players[i].cash = player.getCash() - 10;
          }
        }
        player.cash = player.getCash() + ((playerAmount-1)*10);
        break;
      case 8: // Life insurance matures â€“ Collect $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 100;
        break;
      case 9: // Pay hospital fees of $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() - 100;
        break;
      case 10: // Pay school fees of $150
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() - 150;
        break;
      case 11: // Receive $25 consultancy fee
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 25;
        break;
      case 12: // You are assessed for street repairs â€“ $45 per house
        new NotificationWindow(title, communityCards[randCard]);
        
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
      case 13: // You have won second prize in a beauty contest â€“ Collect $10
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 10;
        break;
      case 14: // You inherit $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.cash = player.getCash() + 100;
        break;
    }
  }
  
}
