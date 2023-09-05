public class oppg5 {
    public static void main(String[] args) {

    }
    public static void rotasjon(char[] a) {

        int n = a.length;
        if (n<2) return;
        char b = a[n-1];
        for (int i = n - 1; i >= 1; i--) {
            a[i] = a[i-1];
        }
        a[0] = b;
    }
}
