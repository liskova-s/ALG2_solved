/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankApp;

import bank.Client;
import bank.Company;
import bank.Person;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author sarka
 */
public class BankApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Client pekar = new Person("Pekar");
        Person svecova = new Person("Svecova");
        Company skoda= new Company("Skoda");
        
        pekar.estabAccount(1000);
        pekar.estabAccount(500);
        svecova.estabAccount(1200);
        skoda.estabAccount(120);
        
        
        List<Client> clients = new ArrayList<>(Arrays.asList(pekar, svecova, skoda)); //nezvetsitelny list
        //List<Client> clients = new ArrayList();
        //clients.add(pekar);
        //clients.add(svecova);
        //clients.add(skoda);
        printList(clients);
        /*
        for (Client client: clients){
            System.out.println(client.adressClient()+" "+ client.getTotalResidual());
        }*/
        
        
        

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

    public static void printList(List<Client> clients) {
        for (Client x : clients) {
            System.out.format("%s: %.2f CZK %n", x.adressClient(), x.getTotalResidual());
        }
    }
}
