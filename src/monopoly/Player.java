package monopoly;

import static monopoly.Monopoly.spaces;
import static monopoly.Monopoly.board;
import javax.swing.JOptionPane;
import static monopoly.Monopoly.TITLE;
import static monopoly.Monopoly.IMAGE_FILE;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static monopoly.Monopoly.players;

/**
 * Players.java - to create players
 *
 * @author William Gore & Raden Pablo
 * @since 23-May-2019
 */
public class Player {
    // properties

    private int turns;
    public int cash;
    public String name;
    public int people;
    public int space;
    private boolean jailed;
    public int railroads = 0;
    public int util = 0;
    public JLabel label;

    public static int amountToMove;
    public static int roll1;
    public static int roll2;

    /**
     * set up how munch money in the bank
     */
    public Player() {
        cash = 1000000;
        name = "Bank";
    }

    /**
     * set the player name, space and cash it also set that there not in jail
     *
     * @param name of the player
     */
    public Player(String name) {
        jailed = false;
        this.name = name;
        space = 0;
        cash = 1500;
    }

    /**
     * rolls the dices
     */
    public void takeTurn() {
        System.out.println("turn start " + name + "\n$" + cash);
        if (jailed == false) {
            int doubles = 0;
            boolean isDouble = roll();
            System.out.println(isDouble);
            while (isDouble == true && doubles < 2) {
                isDouble = roll();
                if (isDouble == true) {
                    doubles++;
                }

                System.out.println("is double " + isDouble);
                if (doubles == 2) {
                    goToJail();
                }
            }
        } else {
            turns++;
            if (roll() == true || turns == 3) {
                jailed = false;
                turns = 0;
                cash -= 50;
            } else {
                System.out.println("Stay in jail!");
            }
        }
        if (cash <= 0) {
            System.out.println("you lose");
        }
    }

    /**
     * Generates a random number
     *
     * @param low lowest number in the range
     * @param high highest number in the range
     * @return random number in range
     */
    private static int random(int low, int high) {
        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double value = (H - L + 1) * seed + L;
        int answer = (int) value;
        return answer;

    }

    /**
     * creates a dice
     *
     * @return give the dice number
     */
    private boolean roll() {
        roll1 = random(1, 6);
        roll2 = random(1, 6);
        showDice(Player.roll1, Player.roll2);
        amountToMove = roll1 + roll2;
        System.out.println("Space " + space);
        System.out.println("dice1 " + roll1 + "\ndice2 " + roll2);
        if (jailed == false) {
            move(amountToMove);
            checkSpace();
        }
        if (roll1 == roll2) {
            return true;
        }
        return false;
    }

    // move the player and if they pass go gain $200
    private void move(int move) {
        for (int i = 0; i < move; i++) {
            space++;
            if (space == 40) {
                space = 0;
                cash += 200;
            }
        }

        System.out.println("space = " + space);
    }

    /**
     * check the player where they landed
     */
    public void checkSpace() {
        String message = name + " landed on " + spaces[space].name;
        output(message);
        if (space == 30) { // if they landed on the go to jail square they
            // have to go to jail
            goToJail();
        } else if (spaces[space].isCC == true) {
            CC chance = new CC(this, random(1, 8));
        } else if (spaces[space].isProperty == true) {
            if (spaces[space].owned == false) {
                // when the property is not owned you have a chance to buy it
                propose();
            } else if (spaces[space].owned == true) {
                if (spaces[space].owner != this) {
                    // when the property owned you have to pay rent
                    if (spaces[space].isRailroad == true) {
                        int rent = 25;
                        if (spaces[space].owner.railroads == 1) {
                            rent = 25;
                            this.cash -= rent;
                            (spaces[space].owner).cash += rent;
                        } else if (spaces[space].owner.railroads == 2) {
                            rent = 50;
                            this.cash -= rent;
                            (spaces[space].owner).cash += rent;
                        } else if (spaces[space].owner.railroads == 3) {
                            rent = 100;
                            this.cash -= rent;
                            (spaces[space].owner).cash += rent;
                        } else if (spaces[space].owner.railroads == 4) {
                            rent = 200;
                            this.cash -= rent;
                            (spaces[space].owner).cash += rent;
                        } else {
                            System.out.println("Error, railroads not between"
                                    + " 1 and 4");
                        }
                        output(this.name + " payed "
                                + spaces[space].owner.name + " $"
                                + rent);
                    }
                    if (spaces[space].isUtility == true) {
                        int rent = 5;
                        if (spaces[space].owner.util == 1) {
                            rent = amountToMove * 4;
                            this.cash -= rent;
                            (spaces[space].owner).cash += rent;
                        } else if (spaces[space].owner.util == 2) {
                            rent = amountToMove * 10;
                            this.cash -= rent;
                            (spaces[space].owner).cash += rent;
                        }
                        output(this.name + " payed "
                                + spaces[space].owner.name + " $"
                                + rent);
                    } else {
                        this.cash -= spaces[space].rent;
                        (spaces[space].owner).cash += spaces[space].rent;
                        output(this.name + " payed "
                                + spaces[space].owner.name + " $"
                                + spaces[space].rent);
                    }
                }
            } else {
                cash = cash - spaces[space].rent;
            }
        }
    }

    /**
     * went to jail
     */
    public void goToJail() {
        output("Go to jail!");
        jailed = true;
        space = 10;
        turns = 0;
    }

    /**
     *
     * @param text is whatever the text is
     */
    public void output(String text) {
        Icon picture = new ImageIcon(IMAGE_FILE);
        JOptionPane.showMessageDialog(
                null,
                text,
                TITLE,
                JOptionPane.INFORMATION_MESSAGE,
                picture);

    }

    /**
     * ask the buyer if he wants it
     */
    private void propose() {
        String name = spaces[space].name;
        int price = spaces[space].price;
        output(name, price);
    }

    /**
     * ask the buyer
     *
     * @param name of the property
     * @param price of the property
     */
    private void output(String name, int price) {
        Icon picture = new ImageIcon(IMAGE_FILE);
        String message = "Would you like to buy " + name + " for $"
                + price + "?";
        String[] options = {"YES", "NO"};
        int choice = JOptionPane.showOptionDialog(
                null,
                message,
                TITLE,
                0,
                0,
                picture,
                options,
                0);
        if (choice == 0 && cash >= spaces[space].price) {
            spaces[space].buy();
            if (spaces[space].isRailroad == true) {
                railroads++;
            }
            if (spaces[space].isUtility == true) {
                util++;
            }
        } else {
            output("Too Poor!");
        }

    }

    private void showDice(int roll1, int roll2) {
        Board.dice[roll1 - 1].setLocation(320, 450);
        Board.dice[roll2 - 1].setLocation(580, 450);
        Board.dice[roll1 - 1].setVisible(true);
        Board.dice[roll2 - 1].setVisible(true);
    }

}
