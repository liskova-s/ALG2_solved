/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author sarka
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person Pekar = new Person("Pekar");
        Person Svecova = new Person("Svecova");
        Company Skoda = new Company("Skoda");
        ArrayList<Client> clients = new ArrayList<>(Arrays.asList(Pekar, Svecova, Skoda));

        Pekar.estabAccount(1000);
        Pekar.estabAccount(500);
        Svecova.estabAccount(1200);
        Skoda.estabAccount(120);

        printList(clients);

        System.out.println("___________________________________");
        System.out.println("Disposal-sorted (using Comparable):");
        Collections.sort(clients);
        printList(clients);
        
        /*
        System.out.println("___________________________________");
        System.out.println("Disposal-sorted (using CashComparator):");
        Collections.sort(clients, Client.CashComparator);
        printList(clients);
         */

        System.out.println("___________________________________");
        System.out.println("Name-sorted (using Namecomparator):");
        Collections.sort(clients, Client.NameComparator);
        printList(clients);

    }

    public static void printList(ArrayList<Client> clients) {
        for (Client x : clients) {
            System.out.format("%s: %.2f %s %n", x.adressClient(), x.getTotalResidual(), x.currency);
        }
    }
}
