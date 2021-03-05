
package Fraction;

/**
 *
 * @author sarka
 */
 public class Fraction {

     //data
     private int num;
     private int denom;

     public Fraction(double num, double denom) {         //converting numerator and denominator into integer form
         this.num = integerSwitch(num, denom)[0];
         this.denom = integerSwitch(num, denom)[1];

     }

     private static int[] integerSwitch(double num, double denom) {
         int[] integerSwitch = new int[2];
         boolean end = false;

         while (!end) {
             if ((num * 10) % 10 == 0 && (denom * 10) % 10 == 0) {
                 integerSwitch[0] = (int) num;
                 integerSwitch[1] = (int) denom;
                 end = true;
             } else {
                 num = num * 10;
                 denom = denom * 10;
             }
         }
         if (denom == 0) {
             throw new IllegalArgumentException("Denominator equals 0");
         }
         return integerSwitch;
     }

     public Fraction(String fract) {
         String[] f = fract.split("/");
         this.num = integerSwitch(Double.parseDouble(f[0]), Double.parseDouble(f[1]))[0];
         this.denom = integerSwitch(Double.parseDouble(f[0]), Double.parseDouble(f[1]))[1];
     }

     //methods
     public int getNumerator() {
         return num;
     }

     public int getDenominator() {
         return denom;
     }

     public String fractionToString() {
         return num + "/" + denom;
     }

     public int[] getSimplestFraction() {
         int[] simplestFraction = new int[2];
         int gcd = getGCD(num, denom);
         if (gcd > 1) {
             simplestFraction[0] = num / gcd;
             simplestFraction[1] = denom / gcd;
         } else {
             simplestFraction[0] = num;
             simplestFraction[1] = denom;
         }
         return simplestFraction;
     }

     public int getNumOfSF() {
         int[] simplestFraction = getSimplestFraction();
         return simplestFraction[0];
     }

     public int getDenomOfSF() {
         int[] simplestFraction = getSimplestFraction();
         return simplestFraction[1];
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
         num = getNumOfSF();
         denom = getDenomOfSF();
     }

 }
