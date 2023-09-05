import java.util.Arrays;

public class oppg9 {
    public static int[] tredjeMin(int[] a) {
        int n = a.length;
        if (n < 3) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 3!");

        int[] førsteTreiA = Arrays.copyOfRange(a,0,3);

        int[]    index = oppg8.indekssortering(førsteTreiA);

        int m = index[0];
        int nm = index[1];
        int nnm = index[2];

        int forsteMinsteVerdi = a[m];
        int andreMinsteVerdi = a[nm];
        int tredjeMinsteVerdi = a[nnm];

        for (int i = 3; i < n; i++) {

            if (a[i] < tredjeMinsteVerdi) { //Hvis a[i] er mindre enn trejminste så skal neste setning kjøres

                if (a[i] < andreMinsteVerdi) {  //Hvis a[i] er mindre enn nestminste verdi så skal neste setning kjøres

                    if (a[i] < forsteMinsteVerdi) {  //Hvis a[i] er mindre en minst verdi så skal ny verdi settes

                        nnm = nm;
                        tredjeMinsteVerdi = andreMinsteVerdi;

                        nm = m;
                        andreMinsteVerdi = forsteMinsteVerdi;

                        m = i;
                        forsteMinsteVerdi = a[m];

                    } else {
                        nnm = nm;
                        tredjeMinsteVerdi = andreMinsteVerdi;

                        nm = i;
                        andreMinsteVerdi = a[nm];
                    }
                } else {

                    nnm = i;
                    tredjeMinsteVerdi = a[nnm];
                }
            }
        }
        return new int[]{m, nm, nnm};//returnerer tabell med inndekser
    }
}
