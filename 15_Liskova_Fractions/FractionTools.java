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

    public static int[] sum(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getDenominator() + b.getNumerator() * a.getDenominator();
        int denomC = a.getDenominator() * b.getDenominator();
        Fraction c = new Fraction(numC, denomC);
        return c.getSimplestFraction();
    }

    public static int[] antisum(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getDenominator() - b.getNumerator() * a.getDenominator();
        int denomC = a.getDenominator() * b.getDenominator();
        Fraction c = new Fraction(numC, denomC);
        return c.getSimplestFraction();
    }

    public static int[] multiply(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getNumerator();
        int denomC = a.getDenominator() * b.getDenominator();
        Fraction c = new Fraction(numC, denomC);
        return c.getSimplestFraction();
    }

    public static int [] divide(Fraction a, Fraction b) {
        int numC = a.getNumerator() * b.getDenominator();
        int denomC = a.getDenominator() * b.getNumerator();
        Fraction c = new Fraction(numC, denomC);
        return c.getSimplestFraction();
    }
    public static int getNumeratorFromArray(int [] array){
        return array[0];
    }

    public static int getDenominatorFromArray(int [] array){
        return array[1];
    }

    public static String stringInterpret(int a, int b){
        if(a==0){
            return 0+"";
        }
        if(a==b && a==1){
            return 1+"";
        }
        return a+"/"+b;
    }

}
