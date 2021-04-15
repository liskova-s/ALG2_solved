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
public class Account {
    private double cash=0;
    private String currency;
    Account(){
        
    }
    Account(double cash, String currency){
        this.cash=cash;
        this.currency=currency;
    }
    
    public void insertMoney(double cash){
        this.cash+=cash;
    }
    public void getMoney(double cash){
        this.cash-=cash;
    }
    public double getResidue(){
        return cash;
    }
    
    @Override
    public String toString(){
        return String.format("Account residue: %f %s",cash, currency);
    }
    //__________________________________________________
  
}
