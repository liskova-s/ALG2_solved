/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg25_liskova_autobus;

import java.util.Scanner;

/**
 *
 * @author sarka
 */
public class AutobusApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Vytvořte třídu BusApp.java, která bude simulovat jízdu.
Vytvořte univerzitní autobus číslo 15, kterí patří společnosti DPMLJ a má 41 sedadel.
Nasimulujete jeho jízdu přes 5 zastávek. Na každé zastávce:
vypište číslo zastávky a informace o autobuse.
zeptejte se, kolik cestujících chce vystoupit a kolik chce nastoupit.
pokud chce vystoupit víc cestujících, než je v autobuse, nechte vystoupit všechny a vypište skutečný počet cestujících, kteří vystoupili.
pokud chce nastoupit víc cestujících, než je volných sedadel, nechte nastoupit tolik, kolik je volných sedadel a vypište skutečný počet lidí, kteří nastoupili.
na poslední zastávce ať vystoupí všichni.*/
        Scanner sc = new Scanner(System.in);

        Bus uniBus = new Bus(41, 15, "DPMLJ");
        final int STOPS = 5;
        for (int i = 0; i < STOPS; i++) {
            System.out.println("Station number: " + (i + 1));
            System.out.println(uniBus.toString());
            if (i == STOPS - 1) {
                uniBus.everybodyOff();
                System.out.println("End station.");
                System.out.println(uniBus.toString());
            } else {
                System.out.println("Passengers out:");
                uniBus.setPassengersOut(uniBus.checkOut(sc.nextInt()));
                System.out.println("Passengers in:");
                uniBus.setPassengersIn(uniBus.checkIn(sc.nextInt()));
                System.out.println(uniBus.toString());
                System.out.println("");

            }
        }
    }

}
