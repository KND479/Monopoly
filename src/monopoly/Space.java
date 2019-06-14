package monopoly;

import static monopoly.Monopoly.board;

import static monopoly.Monopoly.bank;
import static monopoly.Monopoly.players;
import static monopoly.Monopoly.turn;

/**
 *
 * @author Will Gore & Raden Pablo
 */
public class Space {
    // properties

    public String name;
    public boolean isProperty;
    public int price;
    public int rent;
    public boolean owned = false;
    public boolean isRailroad;
    private String colour;
    public Player owner;
    public boolean isUtility;
    public boolean isCC;
    public int x;
    public int y;

    /**
     * creates non-buyable properties like GO
     *
     * @param rent how much money needed to pay
     * @param name the name of the properties
     */
    public Space(int rent, String name, int x, int y) {
        this.x = x;
        this.y = y;
        owner = bank;
        this.name = name;
        isProperty = false;
        this.rent = rent;
        isRailroad = false;
    }

    /**
     * creates buyable properties
     *
     * @param price of the properties
     * @param rent of the properties
     * @param colour of the properties
     * @param name of the properties
     */
    public Space(int price, int rent, String colour, String name, int x, int y) {
        this.x = x;
        this.y = y;
        owner = bank;
        this.price = price;
        this.rent = rent;
        this.colour = colour;
        this.name = name;
        isRailroad = false;
        isProperty = true;
        owned = false;
    }

    /**
     * pays the rent
     *
     * @param name the properties name
     */
    public Space(String name, int x, int y) {
        this.x = x;
        this.y = y;
        isCC = true;
        owned = true;
        owner = bank;
        this.name = name;
    }

    /**
     * Creates railroads
     *
     * @param isRailroad if they landed on the railroad
     * @param price of the railroad
     * @param name of the railroad
     */
    public Space(boolean isRailroad, int price, String name, int x, int y) {
        this.x = x;
        this.y = y;
//        owned = false;
        this.isProperty = true;
        this.name = name;
        this.price = price;
        this.isRailroad = true;
    }

    /**
     * Creates utilities
     *
     * @param name of the property
     * @param price of the property
     */
    public Space(String name, int price, int x, int y) {
        this.x = x;
        this.y = y;
        isUtility = true;
        isProperty = true;
        this.name = name;
        this.price = price;
    }

    /**
     *
     * @param jailed if they are in jailed
     * @param name of the person
     */
    public Space(boolean jailed, String name, int x, int y) {
        this.name = name;
    }

    /**
     * when you accepted to buy
     */
    public void buy() {
        owned = true;
        owner = players[turn];
        players[turn].cash -= price;
        System.out.println(players[turn].name + " bought " + this.name
                + " for $" + price);
    }
}
