import java.util.*;

public class CommunityChest extends GameTile {
  
  Random rand = new Random();
  
  private GameManager manager;
  private String title = "Community Chest";
  private int randCard = rand.nextInt(15);
    
  private String[] communityCards = {("Advance to Go (Collect $200)"),                          //Index 0
    ("Bank error in your favor - Collect $200"),                                              //Index 1
    ("Doctor's fees - Pay $50"),                                                              //Index 2
    ("From sale of stock you get $50"),                                                         //Index 3
    ("Grand Opera Night - Collect $50 from every player for opening night seats"),            //Index 4
    ("Holiday Fund matures - Receive $100"),                                                    //Index 5
    ("Income tax refund - Collect $20"),                                                      //Index 6
    ("It is your birthday - Collect $10 from each player"),                                     //Index 7
    ("Life insurance matures - Collect $100"),                                                //Index 8
    ("Pay hospital fees of $100"),                                                              //Index 9
    ("Pay school fees of $150"),                                                                //Index 10
    ("Receive $25 consultancy fee"),                                                            //Index 11
    ("You are assessed for street repairs - $45 per house"),                                  //Index 12
    ("You have won second prize in a beauty contest - Collect $10"),                          //Index 13
    ("You inherit $100"),                                                                       //Index 14
  };
  
  
  
  public CommunityChest(GameManager manager) {
    super("Community Chest");
    this.manager = manager;
  }
  
  public void performAction(Player player) {
    switch (randCard) {
      case 0: // Advance to Go (Collect $200)
        new NotificationWindow(title, communityCards[randCard]);
        
        manager.move(manager.findMovement(0, player.getLocation()));
        break;
      case 1: // Bank error in your favor - Collect $200
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 200);
        break;
      case 2: // Doctor's fees - Pay $50
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() - 50);
        break;
      case 3: // From sale of stock you get $50
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 50);
        break;
      case 4: // Grand Opera Night - Collect $50 from every player for opening night seats
        new NotificationWindow(title, communityCards[randCard]);
        
        int playerNum = manager.getPlayers().length;
        for (int i = 0; i < playerNum; i++) {
          player.transferCash(manager.getPlayers()[i], 50);
        }

        break;
      case 5: // Holiday Fund matures - Receive $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 100);
        break;
      case 6: // Income tax refund - Collect $20
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 20);
        break;
      case 7: // It is your birthday - Collect $10 from each player
        new NotificationWindow(title, communityCards[randCard]);
        
        int numPlayers = manager.getPlayers().length;
        for (int i = 0; i < numPlayers; i++) {
          player.transferCash(manager.getPlayers()[i], 10);
        }

        break;
      case 8: // Life insurance matures - Collect $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 100);
        break;
      case 9: // Pay hospital fees of $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() - 100);
        break;
      case 10: // Pay school fees of $150
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() - 150);
        break;
      case 11: // Receive $25 consultancy fee
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 25);
        break;
      case 12: // You are assessed for street repairs - $45 per house
        new NotificationWindow(title, communityCards[randCard]);
        
        int numHouses = 0;
        
        Property[] properties = manager.getPropertyManager().getPropertyList();
        
        for (int i = 0; i < properties.length; i++) {
          if (properties[i] instanceof Estate) {
            if (properties[i].getOwner().equals(player.getName())) {
              numHouses += ((Estate)properties[i]).getNumHouses();
            }
          }
        }
        player.setCash(player.getCash() - (numHouses*45));
        break;
      case 13: // You have won second prize in a beauty contest - Collect $10
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 10);
        break;
      case 14: // You inherit $100
        new NotificationWindow(title, communityCards[randCard]);
        
        player.setCash(player.getCash() + 100);
        break;
    }
  }
  
}
