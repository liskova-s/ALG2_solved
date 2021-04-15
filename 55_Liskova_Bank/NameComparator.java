/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Comparator;

/**
 *
 * @author sarka
 */
public interface NameComparator {

    public static Comparator<Client> NameComparator = (Client s1, Client s2) -> {
        String Name1 = s1.getName().toUpperCase();
        String Name2 = s2.getName().toUpperCase();

        //ascending order
        return Name1.compareTo(Name2);
    };
            
}
