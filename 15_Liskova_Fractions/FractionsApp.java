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
        //Fraction f = new Fraction("2/4");
        Fraction f = new Fraction(16.2, 45);
        //Fraction s = new Fraction(1,3);
        //Fraction r = new Fraction (2,4);

        /*System.out.println("Fraction tools preview:");
        System.out.println("Sum: "+stringInterpret(getNumeratorFromArray(sum(s,r)),getDenominatorFromArray(sum(s,r))));
        System.out.println("Difference: "+stringInterpret(getNumeratorFromArray(antisum(s,r)),getDenominatorFromArray(antisum(s,r))));
        System.out.println("Multiple: "+stringInterpret(getNumeratorFromArray(multiply(s,r)),getDenominatorFromArray(multiply(s,r))));
        System.out.println("Divided: "+stringInterpret(getNumeratorFromArray(divide(s,r)),getDenominatorFromArray(divide(s,r))));
        */
        
        //return numerator:
        System.out.println("Numerator: " + f.getNumerator());

        //return denominator:
        System.out.println("Denominator: " + f.getDenominator());

        //String interpretation:
        System.out.println("String interpretation: " + f.fractionToString());

        //Simplify fraction:
        f.simplify();
        System.out.println("Simplest form: " + f.fractionToString());

        //Create new simplified fraction
        /*
        Fraction s = new Fraction(f.getNumOfSF(), f.getDenomOfSF());
        System.out.println("Simplest form: "+s.fractionToString());*/
    }


}
