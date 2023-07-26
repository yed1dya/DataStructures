package recursion;
/*************************************************************************
 *  Compilation:  javac Euclid.java
 *  Execution:    java Euclid p q
 *  
 *  Reads two command-line arguments p and q and computes the greatest
 *  common divisor of p and q using Euclid's algorithm.
 *
 *  Remarks
 *  -----------
 *    - may return the negative of the gcd if p is negative
 *
 *************************************************************************/

public class Euclid{

    // recursive implementation
    public static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }

    // non-recursive implementation
    public static int gcd2(int p, int q) {
    	int r = 1;
        while (r != 0) {
            r = p % q;
            p = q;
            q = r;
        }
        return p;
    }

    public static void main(String[] args) {
        int p = 42;
        int q = 31;
        int d  = gcd(p, q);
        int d2 = gcd2(p, q);
        System.out.println("gcd(" + p + ", " + q + ") = " + d);
        System.out.println("gcd(" + p + ", " + q + ") = " + d2);
    }
}



