/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fraction;

/**
 *
 * @author sarka
 */
public class FractionTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction("1/2");
        Fraction f3 = new Fraction("1 2");
        Fraction F = new Fraction("324/16");
        Fraction f4 = new Fraction("-24/12");

        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(f3.toString());

        System.out.format("Tested fraction: %s%n", F.toString());
        System.out.println("");
        System.out.format("Numerator: %d%n", F.getNumerator());
        System.out.format("Denominator: %d%n", F.getDenominator());
        System.out.format("Value: %f%n", F.getValue());
        F.simplify();
        System.out.format("Simplest form: %s%n", F.toString());
        System.out.println("");
        System.out.format("Fraction representation of -24/12: %s%n", f4.toString());

    }

}
