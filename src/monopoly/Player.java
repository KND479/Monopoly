package monopoly;

import static monopoly.Monopoly.spaces;
import static monopoly.Monopoly.board;
import javax.swing.JOptionPane;
import static monopoly.Monopoly.TITLE;
import static monopoly.Monopoly.IMAGE_FILE;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Players.java - to create players
 *
 * @author William Gore & Raden Pablo
 * @since 23-May-2019
 */
public class Player {

    private int turns;
    public int cash;
    public String name;
    public int people;
    private int space;
    private boolean jailed;
    public int railroads = 0;

    /**
     *
     */
    public Player() {
        cash = 1000000;
        name = "Bank";
    }

    public Player(String name) {
        jailed = false;
        this.name = name;
        space = 0;
        cash = 1500;
    }

    /**
     * To create dices
     */
    public void takeTurn() {
        System.out.println("turn start " + name + "\n$" + cash);
        if (jailed == false) {
            int doubles = 0;
            boolean isDouble = roll();
            System.out.println(isDouble);
            while (isDouble == true && doubles < 2) {
                isDouble = roll();
                doubles++;
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
            } else {
                System.out.println("Stay in jail!");
            }
        }
        if (cash == 0) {
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

    private boolean roll() {
        int dice1 = random(1, 6);
        int dice2 = random(1, 6);
        int move = dice1 + dice2;
        System.out.println("Space " + space);
        System.out.println("dice1 " + dice1 + "\ndice2 " + dice2);
        if (jailed == false) {
            move(move);
            checkSpace();
        }
        if (dice1 == dice2) {
            return true;
        }
        return false;
    }

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

    public void checkSpace() {
        String message = name + " landed on " + spaces[space].name;
        output(message);
        if (space == 30) {
            goToJail();
        } else if (spaces[space].isProperty == true) {
            if (spaces[space].owned == false) {
                propose();
            } else if (spaces[space].owned == true) {
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
                    System.out.println(this.name + " payed "
                            + spaces[space].owner.name + " $"
                            + rent);
                } else {
                    this.cash -= spaces[space].rent;
                    (spaces[space].owner).cash += spaces[space].rent;
                    System.out.println(this.name + " payed "
                            + spaces[space].owner.name + " $"
                            + spaces[space].rent);
                }
            }
        } else {
            cash = cash - spaces[space].rent;
        }
    }

    public void goToJail() {
        output("Go to jail!");
        jailed = true;
        space = 10;
        turns = 0;
    }

    private void output(String text) {
        Icon picture = new ImageIcon(IMAGE_FILE);
        JOptionPane.showMessageDialog(
                null,
                text,
                TITLE,
                JOptionPane.INFORMATION_MESSAGE,
                picture);

    }

    private void propose() {
        String name = spaces[space].name;
        int price = spaces[space].price;
        output(name, price);
    }

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
        } else {
            System.out.println("Too Poor!");
        }
    }
}
