public class oppg6 {
    public static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (n<2) {
            return; }
        k %= n;
        char[] b = new char[Math.abs(k)];
        int c = 0;

        // mot høyre
        if (k > 0) {
            for (int i = n - k; i < n; i++) {
                b[c++] = a[i];
            }
            for (int i = n - k - 1; i >= 0; i--) {
                a[k + i] = a[i];
                if (i < k) {
                    a[i] = b[i];
                }
            }
            // mot venstre
        } else if (k<0) {
            k = Math.abs(k);
            // Fra i = 0, mens i er mindre enn antall rotasjoner,
            // 1 øker for hver gang. Vi kopierer
            for(int i = 0; i<k; i++){
                b[i] = a[i];
            }

            for(int i = 0; i <= n-k-1; i++){
                a[i] = a[k+i];
            }

            for(int i = 0; i < b.length; i++){
                a[n-i-1] = b[k - i - 1];
            }
        }
    }

}
