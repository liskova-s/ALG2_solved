/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calender;

import java.util.Scanner;

/**
 *
 * @author sarka
 */
public class CalenderApp {

    public static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calender c = new Calender(18, 5, 2021);
        System.out.println("Welcome to calender.");
        System.out.println("Switch months by '<' '>', exit program by 'exit'.");
        boolean end = false;

        while (!end) {
            System.out.println(c.showCalender());
            switch (sc.next()) {
                case "<":
                    c.pageMonthSet(-1);
                    break;
                case ">":
                    c.pageMonthSet(1);
                    break;
                case "exit":
                    end = true;
                    break;
                default:
                    break;
            }

        }
    }

}
