
package ee.ttu.algoritmid.fibonacci;

public class AL01A {

    /**
     * Compute the Fibonacci sequence number.
     * @param n The number of the sequence to compute.
     * @return The n-th number in Fibonacci series.
     */


    public static String iterativeF(long n) {
        if (n <= 1) return "1";
        else return iterativeF(n-1) + iterativeF(n-2);
        //return "";
    }

    public static void main(String args[])
    {
        long n = 9;
        System.out.println(iterativeF(n));
    }


}