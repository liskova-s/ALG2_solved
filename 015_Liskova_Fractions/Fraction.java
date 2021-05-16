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
public class Fraction {

    //data
    private int num;
    private int denom;
    private double value;

    //constructors:
    public Fraction(double num, double denom) {
        if (denom != 0) {
            value = (double) num / (double) denom;
        }
        int[] switched = integerSwitch(num, denom);
        this.num = switched[0];
        this.denom = switched[1];
    }

    public Fraction(String fract) {
        String[] f = fract.split("/");
        if (f.length != 2) {
            f = fract.split(" ");
        }
        int[] switched = integerSwitch(Double.parseDouble(f[0]), Double.parseDouble(f[1]));
        this.num = switched[0];
        this.denom = switched[1];
        value = (double) num / (double) denom;
    }

    private static int[] integerSwitch(double num, double denom) {
        int multiplyN = 0;
        int multiplyD = 0;
        int[] integerFract = new int[2];

        if (denom == 0) {
            throw new IllegalArgumentException("Denominator equals 0");
        } else {
            while ((num * 10) % 10 != 0) {
                num = 10 * num;
                multiplyN++;
            }
            integerFract[0] = (int) num;

            while ((denom * 10) % 10 != 0) {
                denom = denom * 10;
                multiplyD++;
            }
            integerFract[1] = (int) denom;

            if (multiplyN > multiplyD) {
                int mult = (int) Math.pow(10, multiplyN - multiplyD);
                integerFract[1] *= mult;
            }
            if (multiplyN < multiplyD) {
                int mult = (int) Math.pow(10, multiplyD - multiplyN);
                integerFract[0] *= mult;
            }
            return integerFract;
        }
    }

    //methods
    public int getNumerator() {
        return num;
    }

    public int getDenominator() {
        return denom;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (num % denom == 0) {
            return String.format("%d", num / denom);
        }
        return num + "/" + denom;
    }

    private int getGCD(int x, int y) {
        int r;
        while (y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public void simplify() { //not static, depends on object(instance) Fraction
        int gcd = getGCD(num, denom);
        if (gcd > 1) {
            num = num / gcd;
            denom = denom / gcd;
        } else {
            num = num;
            denom = denom;
        }
    }

}
