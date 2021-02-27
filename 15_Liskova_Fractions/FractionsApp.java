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
public class FractionApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fraction f = new Fraction(12.568, 2);

        //return numerator:
        System.out.println(f.getNumerator());

        //return denominator:
        System.out.println(f.getDenominator());

        //String interpretation:
        System.out.println(f.fractionToString());

        //Simplify fraction:
        Fraction s = new Fraction(f.getNumOfSF(), f.getDenomOfSF());
        System.out.println(s.fractionToString());
    }

}
