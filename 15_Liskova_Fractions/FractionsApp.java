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
         //Fraction f = new Fraction("2/4");
         Fraction f = new Fraction(16.2, 45);

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
