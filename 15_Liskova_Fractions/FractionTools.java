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
public class FractionTools {

    public static Fraction sum(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
        int denomC = a.getDenominator() * b.getDenominator();
        Fraction c = new Fraction(numC, denomC);
        c.simplify();
        return c;
    }

    public static Fraction antisum(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();
        int denomC = a.getDenominator() * b.getDenominator();
        Fraction c = new Fraction(numC, denomC);
        c.simplify();
        return c;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getNumerator();
        int denomC = a.getDenominator() * b.getDenominator();
        Fraction c = new Fraction(numC, denomC);
        c.simplify();
        return c;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getDenominator();
        int denomC = a.getDenominator() * b.getNumerator();
        Fraction c = new Fraction(numC, denomC);
        c.simplify();
        return c;
    }
}
