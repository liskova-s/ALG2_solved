/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

import java.util.Comparator;

/**
 *
 * @author sarka
 */
public class ComparatorByRunTime implements Comparator<Runner> {

    @Override
    public int compare(Runner o1, Runner o2) {
        //spise pro primitivni datove typy
        //return o1.runningTime().toSecondOfDay()-o2.runningTime().toSecondOfDay();
        //referencni datove typy automaticky implementuji comparable:
        return o1.runningTime().compareTo(o2.runningTime());
    }

}
