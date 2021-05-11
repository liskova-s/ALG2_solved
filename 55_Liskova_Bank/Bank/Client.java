/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author sarka
 */
public abstract class Client implements CashComparator, NameComparator, Comparable<Client> {

    protected String client;
    public String currency = "CZK";
    private List<Account> accounts;

    public Client(String name){
        this.client=name;
        accounts = new ArrayList();
    }
    public void estabAccount(double cash){
        this.accounts.add(new Account(cash));
    }

    public double getTotalResidual(){
        double sum=0;
        for (Account a:accounts){
            sum+=a.getResidue();
        }
        return sum;
    }

    public abstract String adressClient();

    @Override
    public int compareTo(Client c){
        return (int)(-this.getTotalResidual() +c.getTotalResidual());
    }
    
    public String getName(){
        return client;
    }
}
