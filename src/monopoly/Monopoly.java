package monopoly;

import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Monopoly.java - to create a monopoly game
 *
 * @author William Gore & Raden Pablo
 * @since 23-May-2019
 */
public class Monopoly {

    // Global Variable
    final static String TITLE = "Monopoly";
    final static String IMAGE_FILE = "C:\\Users\\r.pablo\\Desktop\\Will and Raden FInal Project For Computer Science 30S\\Pictures\\monopoly.png";
    static Player[] players;
    static Space[] spaces;
    static int turn = 0;
    static Board board;
    static Player bank;

    public static void main(String[] args) {
        int choice = intro();
        checkChoice(choice);
    }

    /**
     * Welcomes the player to the program
     *
     * @return - returns the choice of action
     */
    private static int intro() {
        String[] options = {"Play Game", "Rules", "Quit"};
        Icon picture = new ImageIcon(IMAGE_FILE);
        int choice = JOptionPane.showOptionDialog(
                null,
                "Welcome to Monopoly!\n"
                + "What would you like to do?",
                TITLE,
                0,
                0,
                picture,
                options,
                TITLE);
        return choice;
    }

    /**
     * check which button was clicked
     *
     * @param choice whatever the user choice
     */
    private static void checkChoice(int choice) {
        if (choice == 0) {
            startGame();
        } else if (choice == 1) {
            showRules();
        } else {
            close();
        }
    }

    /**
     * set up the game
     */
    private static void startGame() {
        Board board = new Board();
        bank = new Player();
        setSpaces();
        String choice = input("Please enter the number of players\n"
                + "from 2 - 8:");
        int playerNumber = convert(choice);
        if (playerNumber > 8 || playerNumber < 2) {
            error();
            startGame();
        } else {
            // make an array 
            players = new Player[playerNumber];
            // loops it for how many player
            for (int i = 0; i < playerNumber; i++) {
                String name = input("Please enter a name:");
                players[i] = new Player(name);
            }
        }
        for (int i = 0; i < players.length; i++) {
            board.labels[i].setVisible(true);
            board.labels[i].setText(players[i].name);
            players[i].label = board.labels[i];
            players[i].YMod = (i + 1) * 15;
            
        }
        
        board.startGame();
        
    }

    /**
     * exit the game
     */
    private static void close() {
        output("Thank you for using our program!");
        System.exit(0);
    }

    private static void output(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    /**
     * shows the rules of monopoly
     */
    private static void showRules() {
        // makes the link a hyperlink
        try {
            Desktop.getDesktop().browse(new URL("http://www.fgbradleys.com/rules/Monopoly%20Millennium%20Edition.pdf").toURI());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Board.class.getName()).log(Level.SEVERE, null, ex);
        }
        int choice = intro();
        checkChoice(choice);
    }
   
    /**
     * Converts a String to an integer and calls isNumber
     *
     * @param input whatever the user choice
     * @return see if the choice was a number or not
     */
    private static int convert(String input) {
        //checks if the string is even an integer to begin with
        // this means that the isNumber method doesnt need to be
        // called every time we use a number
        if (isNumber(input) == false) {
            return 0;
        }
        //converts the integer
        int output = Integer.parseInt(input);
        //returns the integer
        return output;
    }

    /**
     * Checks for valid inputs
     *
     * @param input - input given by the user
     * @return - returns true or false
     */
    private static boolean isNumber(String input) {
        if (input == null) {
            System.out.println("null string");
            return false;
        } else if (input.equals("")) {
            System.out.println("empty string");
            return false;
        } else {
            // check for letters, non-digits
            int decimalCount = 0;
            for (int i = 0; i < input.length(); i++) {
                char character = input.charAt(i);

                int ascii = (int) character;

                if (character == '.' && i != 0) {
                    if (decimalCount <= 1) { // ok, move on                        
                        decimalCount++;
                    } else {
                        return false;
                    }
                } else if (ascii == 45) {
                    if (i != 0) {
                        // ok, negative not in first spot
                        return false;
                    }
                } else if (Character.isDigit(character) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String input(String text) {
        String choice = JOptionPane.showInputDialog(
                null,
                text,
                TITLE,
                3);
        return choice;
    }

    /**
     * says there is an error
     */
    private static void error() {
        output("Please enter a valid command");
    }
    // set the spaces and the name for each board

    private static void setSpaces() {
        spaces = new Space[40];
        spaces[0] = new Space(-200, "GO", 960, 900);
        spaces[1] = new Space(60, 2, "Brown", "Mediterranean Ave.", 810, 900);
        spaces[2] = new Space("Community Chest", 725, 900);
        spaces[3] = new Space(60, 4, "Brown", "Baltic Ave.", 640, 900);
        spaces[4] = new Space(200, "Income Tax", 555, 900);
        spaces[5] = new Space(true, 200, "Reading Railroad", 470, 900);
        spaces[6] = new Space(100, 6, "LBlue", "Oriental Ave.", 385, 900);
        spaces[7] = new Space("Chance", 300, 900);
        spaces[8] = new Space(100, 6, "LBlue", "Vermont Ave.", 215, 900);
        spaces[9] = new Space(120, 8, "LBlue", "Connecticut Ave.", 130, 900);
        spaces[10] = new Space(0, "Jail, Just Visiting", 0, 900);
        spaces[11] = new Space(140, 10, "Pink", "St. Charles Place", 20, 820);
        spaces[12] = new Space("Electric Company", 150, 20, 735);
        spaces[13] = new Space(140, 10, "Pink", "States Ave.", 20, 650);
        spaces[14] = new Space(160, 12, "Pink", "Virginia Ave.", 20, 565);
        spaces[15] = new Space(true, 200, "Pennsylvania Railroad", 20, 480);
        spaces[16] = new Space(180, 14, "Orange", "St. James Place", 20, 395);
        spaces[17] = new Space("Community Chest", 20, 310);
        spaces[18] = new Space(180, 14, "Orange", "Tennessee Ave.", 20, 225);
        spaces[19] = new Space(200, 16, "Orange", "New York Ave.", 20, 140);
        spaces[20] = new Space(0, "Free Parking", 20, 20);
        spaces[21] = new Space(220, 18, "Red", "Kentucky Ave.", 140, 20);
        spaces[22] = new Space("Chance", 225, 20);
        spaces[23] = new Space(220, 18, "Red", "Indiana Ave.", 310, 20);
        spaces[24] = new Space(240, 20, "Red", "Illinois Ave.", 395, 20);
        spaces[25] = new Space(true, 200, "B.& O. Railroad", 480, 20);
        spaces[26] = new Space(260, 22, "Yellow", "Atlantic Ave.", 565, 20);
        spaces[27] = new Space(260, 22, "Yellow", "Ventnor Ave.", 650, 20);
        spaces[28] = new Space("Water Works", 150, 735, 20);
        spaces[29] = new Space(280, 22, "Yellow", "Marvin Gardens", 820, 20);
        spaces[30] = new Space(true, "Go to Jail", 920, 20);
        spaces[31] = new Space(300, 26, "Green", "Pacific Ave.", 920, 150);
        spaces[32] = new Space(300, 26, "Green", "North Carolina Ave.", 920, 235);
        spaces[33] = new Space("Community Chest", 920, 320);
        spaces[34] = new Space(320, 28, "Green", "Pennsylvania Ave.", 920, 405);
        spaces[35] = new Space(true, 200, "Short Line", 920, 490);
        spaces[36] = new Space("Chance", 920, 575);
        spaces[37] = new Space(350, 35, "Blue", "Park Place", 920, 660);
        spaces[38] = new Space(100, "Luxury Tax", 920, 745);
        spaces[39] = new Space(400, 50, "Blue", "Boardwalk", 920, 830);
    }
}
