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

    public Person(String name) {
        super(name);
    }

    @Override
    public String adressClient() {
        boolean female= super.client.endsWith("ova");
        String adress = (female)?"Pani":"Pan";
        return String.format("%s %s", adress, super.client);
    }
    
    /*
    public static void main(String[] args) {
        Person p=new Person("Svecova");
        System.out.println(p.adressClient());
    }
    */
}
