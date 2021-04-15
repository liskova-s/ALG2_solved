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
public class Company extends Client {

    private String name;
    private ArrayList<Account> accounts = new ArrayList<Account>();

    Company(String name) {
        this.name = name;
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
    public void estabAccount(double cash) {
        Account a = new Account(cash, super.currency);
        accounts.add(a);
    }

    @Override
    public String adressClient() {
        return String.format("Firma %s", name);
    }

    @Override
    public String getName() {
        return name;
    }
}
