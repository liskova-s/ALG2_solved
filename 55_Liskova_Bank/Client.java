/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 *
 * @author sarka
 */
public abstract class Client implements CashComparator, NameComparator, Comparable<Client> {

    protected String client;
    protected String currency = "CZK";

    public abstract void estabAccount(double cash);

    public abstract double getTotalResidual();

    public abstract String adressClient();

    public abstract String getName();

    @Override
    public abstract int compareTo(Client c);
}
