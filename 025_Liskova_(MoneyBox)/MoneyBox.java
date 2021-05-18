/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg25_liskova_moneybox;

/**
 *
 * @author sarka
 */
public class MoneyBox {

    private int one;
    private int two;
    private String owner;

    MoneyBox(String owner) {
        one = 0;
        two = 0;
        this.owner = owner;
    }

    MoneyBox(String owner, int one, int two) {
        this.one = one;
        this.two = two;
        this.owner = owner;
    }

    public void setOwner(String newOwner) {
        this.owner = newOwner;
    }

    public int getSum() {
        return one + 2 * two;
    }

    public void insertOne() {
        this.one += this.one;
    }

    public void insertOneArg(int a) {
        this.one = this.one + a;
    }

    public void insertTwo() {
        this.two = this.two + 2;
    }

    public void insertTwoArg(int a) {
        this.two = this.two + 2 * a;
    }

    public void insertCoins(int one, int two) {
        this.one = this.one + one;
        this.two = this.two + 2 * two;
    }

    public String currentStatus() {
        return owner + " has in the money box: " + getSum() + " CZK - " + one + "x1 CZK, " + two + "x2 CZK";
    }

    public String isThereEnoughFor(double prize, String item) {
        if (getSum() < prize) {
            return owner + " does not have enough money for a " + item + ".";
        } else {
            return owner + " has enough money for a " + item + ".";
        }
    }

    public String getOwner() {
        return owner;
    }

    public static String whoHasMoreMoney(MoneyBox a, MoneyBox b) {
        if (a.getSum() > b.getSum()) {
            return a.owner + " has more money than " + b.getOwner() + ".";
        } else {
            if (a.getSum() == b.getSum()) {
                return "Both have the same amount of money.";
            } else {
                return b.getOwner() + " has more money than " + a.getOwner() + ".";
            }
        }
    }

}
