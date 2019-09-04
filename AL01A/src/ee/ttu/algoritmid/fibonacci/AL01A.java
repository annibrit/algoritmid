
package ee.ttu.algoritmid.fibonacci;

public class AL01A {

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */

    static String iterativeF(long n)
    {
        long a = 0, b = 1, c;
        if (n == 0)
            return ""+a;
        for (long i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return ""+b;
    }

    public static void main (String args[])
    {
        long n = 9;
        System.out.println(iterativeF(n));
    }


}