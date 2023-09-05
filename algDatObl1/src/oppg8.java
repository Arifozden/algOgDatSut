import java.util.Arrays;

import static java.lang.Math.min;

public class oppg8 {
    public static int[] indekssortering(int[] a) {

        if (a.length == 0) return a;

        int[] temp = Arrays.copyOf( a, a.length );

        int[] indekser = new int[a.length];

        int maks = maksverdi( temp );
        int k = 0;

        for (int i = a.length; i > 1; i--) {
            int m = min( temp );
            indekser[k] = m;
            temp[m] = 2147483647;   //maks value for int
            k++;
        }
        indekser[temp.length - 1] = maks;

        for (int s : a) {
            System.out.print( s + " " );
        }
        return indekser;
    }

    private static int min(int[] temp) {
        return 0;
    }

    private static int maksverdi(int[] temp) {
        return 1;
    }
}
