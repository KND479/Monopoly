package monopoly;

import static monopoly.Monopoly.players;
import static monopoly.Monopoly.spaces;

/**
 *
 * @author r.pablo
 */
public class CC {
    
    public int move;

    public CC(Player player, int num) {
        if (num == 1) {
            player.goToJail();
            System.out.println(player.space);
        } else if (num == 2) {
            player.space = 39;
            player.output("Advance to Boardwalk");
            player.checkSpace();
            System.out.println(player.space);
        } else if (num == 3) {
            player.output("Advance to the nearest railroad");
            if(player.space == 7) {
                player.space = 15;
            }
            else if(player.space == 17 || player.space == 22) {
                player.space = 25;
            }
            else if(player.space == 33) {
                player.space = 35;
            }
            else if(player.space == 36 || player.space == 2) {
                player.space = 5;
            }
            player.checkSpace();
            System.out.println(player.space);
        } else if (num == 4) {
            player.output("Congrats you gained 50 dollars");
            player.cash += 50;
        } else if (num == 5) {
            player.output("Get out of Jail Card");
            player.cash += 50;
        } else if (num == 6) {
            player.space = 0;
            player.output("Advance to GO");
            player.checkSpace();
            System.out.println(player.space);
        } else if (num == 7) {
            player.output("You are caught cheating" + "\n pay each player 50");
            for (int i = 0; i < players.length; i++) {
                players[i].cash += 50;
                player.cash -= 50;
            }

        } else if (num == 8) {
            player.output("Go back 3 spaces");
            player.space -= 3;
            player.checkSpace();
        }
    }
    
}
