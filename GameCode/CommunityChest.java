public class CommunityChest extends GameTile {
  
  private GameManager manager;
    
    public CommunityChest(String name, GameManager manager) {
    super(name);
  }
  
  public void performAction(Player player, int num, GameMananger manager) {
    switch (num) {
      case 1: // Advance to Go (Collect $200)
        MyFrame("Community Chest", "Advance to Go (Collect $200)");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.location = 0;
        player.cash = player.getCash() + 200;
        break;
      case 2: // Bank error in your favor – Collect $200
        MyFrame("Community Chest", "Bank error in your favor – Collect $200");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 200;
        break;
      case 3: // Doctor's fees – Pay $50
        MyFrame("Community Chest", "Doctor's fees – Pay $50");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() - 50;
        break;
      case 4: // From sale of stock you get $50
        MyFrame("Community Chest", "From sale of stock you get $50");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 50;
        break;
      case 5: // Grand Opera Night – Collect $50 from every player for opening night seats
        MyFrame("Community Chest", "Grand Opera Night – Collect $50 from every player for opening night seats");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (players[i] != players[currentPlayerIndex]) {
            players[i].cash = player.getCash() - 50;
          }
        }
        player.cash = player.getCash() + ((playerAmount-1)*50);
        break;
      case 6: // Holiday Fund matures - Receive $100
        MyFrame("Community Chest", "Holiday Fund matures - Receive $100");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 100;
        break;
      case 7: // Income tax refund – Collect $20
        MyFrame("Community Chest", "Income tax refund – Collect $20");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 20;
        break;
      case 8: // It is your birthday - Collect $10 from each player
        MyFrame("Community Chest", "It is your birthday - Collect $10 from each player");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        int playerNum = players.length;
        for (int i = 0; i < playerAmountNum; i++) {
          if (players[i] != players[currentPlayerIndex]) {
            players[i].cash = player.getCash() - 10;
          }
        }
        player.cash = player.getCash() + ((playerAmount-1)*10);
        break;
      case 9: // Life insurance matures – Collect $100
        MyFrame("Community Chest", "Life insurance matures – Collect $100");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 100;
        break;
      case 10: // Pay hospital fees of $100
        MyFrame("Community Chest", "Pay hospital fees of $100");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() - 100;
        break;
      case 11: // Pay school fees of $150
        MyFrame("Community Chest", "Pay school fees of $150");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() - 150;
        break;
      case 12: // Receive $25 consultancy fee
        MyFrame("Community Chest", "Receive $25 consultancy fee");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 25;
        break;
      case 13: // You are assessed for street repairs – $45 per house
        MyFrame("Community Chest", "You are assessed for street repairs – $45 per house");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
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
      case 14: // You have won second prize in a beauty contest – Collect $10
        MyFrame("Community Chest", "You have won second prize in a beauty contest – Collect $10");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 10;
        break;
      case 15: // You inherit $100
        MyFrame("Community Chest", "You inherit $100");
        frame.setVisible( true );             // ask it to become visible
        frame.setSize(400, 175);     
        frame.setVisible( true );
        player.cash = player.getCash() + 100;
        break;
    }
  }
  
}
