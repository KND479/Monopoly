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

    final static String TITLE = "Monopoly";
    final static String IMAGE_FILE = "C:\\Users\\r.pablo\\Desktop\\Monopoly.png";
    static Player[] players;
    static Space[] spaces;
    static int turn = 0;
    static Board board;
    static Player bank;

    /**
     * @param args the command line arguments
     */
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

    private static void checkChoice(int choice) {
        if (choice == 0) {
            setupGame();
            playGame();
        } else if (choice == 1) {
            showRules();
        } else {
            close();
        }
    }

    private static void setupGame() {
        bank = new Player();
        setSpaces();
        String choice = input("Please enter the number of players\n"
                + "from 2 - 8:");
        int playerNumber = convert(choice);
        if (playerNumber > 8 || playerNumber < 2) {
            error();
            setupGame();
        } else {
            // make an array 
            players = new Player[playerNumber];
            // loops it for how many player
            for (int i = 0; i < playerNumber; i++) {
                String name = input("Please enter a name:");
                players[i] = new Player(name);
            }
        }
        Board board = new Board();
    }

    private static void close() {
        output("Thank you for using our program!");
        System.exit(0);
    }

    private static void output(String text) {
        JOptionPane.showMessageDialog(null, text);
    }

    private static void showRules() {
            try {
            Desktop.getDesktop().browse(new URL("http://www.fgbradleys.com/rules/Monopoly%20Millennium%20Edition.pdf").toURI());
        } catch (MalformedURLException ex) {
            Logger.getLogger(TEST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(TEST.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TEST.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Converts a String to an integer and calls isNumber
     *
     * @param input
     * @return
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

    private static void error() {
        output("Please enter a valid command");
    }

    private static void playGame() {
        for (turn = 0; turn < players.length; turn++) {
            players[turn].takeTurn();
            System.out.println(turn);
            if (turn == players.length - 1) {
                turn = -1;
            }
            System.out.println("turn end");
        }
    }

    private static void setSpaces() {
        spaces = new Space[40];
        spaces[0] = new Space(-200, "GO");
        spaces[1] = new Space(60, 2, "Brown", "Mediterranean");
        spaces[2] = new Space("chest");
        spaces[3] = new Space(60, 4, "Brown", "Baltic");
        spaces[4] = new Space(200, "Income Tax");
        spaces[5] = new Space(true, 200, "Reading Railroad");
        spaces[6] = new Space(100, 6, "LBlue", "Oriental");
        spaces[7] = new Space("chance");
        spaces[8] = new Space(100, 6, "LBlue", "Vermont");
        spaces[9] = new Space(120, 8, "LBlue", "Connecticut");
        spaces[10] = new Space(0, "Jail");
        spaces[11] = new Space(140, 10, "Pink", "St. Charles");
        spaces[12] = new Space("Electric Company", 150);
        spaces[13] = new Space(140, 10, "Pink", "States");
        spaces[14] = new Space(160, 12, "Pink", "Virginia");
        spaces[15] = new Space(true, 200, "Pennsylvania Railroad");
        spaces[16] = new Space(180, 14, "Orange", "St. James");
        spaces[17] = new Space("chest");
        spaces[18] = new Space(180, 14, "Orange", "Tennessee");
        spaces[19] = new Space(200, 16, "Orange", "New York");
        spaces[20] = new Space(0, "Free Parking");
        spaces[21] = new Space(220, 18, "Red", "Kentucky");
        spaces[22] = new Space("chance");
        spaces[23] = new Space(220, 18, "Red", "Indiana");
        spaces[24] = new Space(240, 20, "Red", "Illinois");
        spaces[25] = new Space(true, 200, "B.& O. Railroad");
        spaces[26] = new Space(260, 22, "Yellow", "Atlantic");
        spaces[27] = new Space(260, 22, "Yellow", "Ventnor");
        spaces[28] = new Space("Water Works", 150);
        spaces[29] = new Space(280, 22, "Yellow", "Marvin Gardens");
        spaces[30] = new Space(true, "Go to Jail");
        spaces[31] = new Space(300, 26, "Green", "Pacific");
        spaces[32] = new Space(300, 26, "Green", "North Carolina");
        spaces[33] = new Space("chest");
        spaces[34] = new Space(320, 28, "Green", "Pennsylvania");
        spaces[35] = new Space(true, 200, "Short Line");
        spaces[36] = new Space("chance");
        spaces[37] = new Space(350, 35, "Blue", "Park Place");
        spaces[38] = new Space(100, "Luxury Tax");
        spaces[39] = new Space(400, 50, "Blue", "Boardwalk");
    }
}
