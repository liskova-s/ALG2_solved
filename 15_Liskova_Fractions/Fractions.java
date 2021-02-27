
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
        boolean end = false;
        while (!end) {
            if ((num * 10) % 10 == 0 && (denom * 10) % 10 == 0) {
                this.num = (int) num;
                this.denom = (int) denom;
                end = true;
            } else {
                num = num * 10;
                denom = denom * 10;
            }
        }
        //System.out.println(this.num);
        //System.out.println(this.denom);

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
        int [] simplestFraction = new int[2];
        int gcd = getGCD(num, denom);
        if (gcd > 1) {
            simplestFraction[0]= num / gcd;
            simplestFraction[1] = denom / gcd;
        } else{
         simplestFraction[0]= num;
         simplestFraction[1] = denom;
        }
        return simplestFraction;
    }

    public int getNumOfSF(){
        int [] simplestFraction = getSimplestFraction();
        return simplestFraction[0];
    }

    public int getDenomOfSF(){
        int [] simplestFraction = getSimplestFraction();
        return simplestFraction[1];
    }

    private int getGCD(int x, int y) {
        int r;
        while(y!=0){
            r=x%y;
            x=y;
            y=r;
        }
        return x;
    }

}
