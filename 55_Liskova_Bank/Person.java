/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;

/**
 *
 * @author sarka
 */
public class Person extends Client {

    private String name;
    private String gender;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    Person(String name) {
        this.name = name;

        if (name.length() <= 3) {
            gender = "M";
        } else {
            String substr = name.substring(name.length() - 3);
            if (substr.equals("ova")) {
                gender = "F";
            } else {
                gender = "M";
            }
        }
    }

    @Override
    public void estabAccount(double cash) {
        Account a = new Account(cash, super.currency);
        accounts.add(0, a);
    }

    @Override
    public double getTotalResidual() {
        double sum = 0;
        for (Account a : accounts) {
            sum += a.getResidue();
        }
        return sum;
    }

    @Override
    public String adressClient() {
        if (gender.equals("M")) {
            return String.format("Pan %s", name);
        } else {
            return String.format("Pani %s", name);
        }
    }

    @Override
    public String getName() {
        return name;
    }

}
