/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg25_liskova_moneybox;

import static pkg25_liskova_moneybox.MoneyBox.whoHasMoreMoney;

/**
 *
 * @author sarka
 */
public class MoneyBoxApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MoneyBox a = new MoneyBox("Alice", 18, 35);
        MoneyBox b = new MoneyBox("Bob");
        b.insertOneArg(2);
        b.insertTwoArg(3);
        b.insertCoins(5,10);
        System.out.println("Alice: sum = "+a.getSum()+" CZK");
        System.out.println("Bob: sum = "+b.getSum()+" CZK");
        System.out.println(a.currentStatus());
        System.out.println(b.currentStatus());
        System.out.println("");
        System.out.println(a.isThereEnoughFor(39, "hamburger"));
        System.out.println(b.isThereEnoughFor(39, "hamburger"));
        System.out.println(whoHasMoreMoney(a,b));
        
    }

}
