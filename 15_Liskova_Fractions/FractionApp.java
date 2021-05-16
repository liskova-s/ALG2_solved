/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraction;

import static Fraction.FractionTools.antisum;
import static Fraction.FractionTools.divide;
import static Fraction.FractionTools.getDenominatorFromArray;
import static Fraction.FractionTools.getNumeratorFromArray;
import static Fraction.FractionTools.multiply;
import static Fraction.FractionTools.stringInterpret;
import static Fraction.FractionTools.sum;

/**
 *
 * @author sarka
 */
public class FractionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Fraction calculator

        //testing 1:
        Fraction f1 = new Fraction(12, 24); // 1/2
        Fraction f2 = new Fraction(0.1, 0.3);// 1/3

        /*
        //testing 2: //exception
        Fraction f1= new Fraction(1,0); // 1/0
        Fraction f2 = new Fraction(0.1,0.3);// 1/3
         */
        System.out.println("Fraction tools - calculator");
        System.out.println("");
        System.out.format("Selected fractions: %s and %s%n", f1.toString(), f2.toString());
        f1.simplify();
        f2.simplify();
        System.out.format("Simple form: %s and %s%n", f1.toString(), f2.toString());
        System.out.println("");

        System.out.println("Fraction tools preview:");
        System.out.println("Sum: " + sum(f1, f2).toString());
        System.out.println("Difference: " + antisum(f1, f2).toString());
        System.out.println("Multiple: " + multiply(f1, f2).toString());
        System.out.println("Divided: " + divide(f1, f2).toString());

    }

}
