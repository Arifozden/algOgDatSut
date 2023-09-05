import java.util.NoSuchElementException;

public class oppg10 {
    public static boolean inneholdt(String a, String b) {

        //Den tomme strengen er inneholdt i alle andre strenger.
        // Ikke noe annet enn den tomme strengen kan vaere
        // inneholdt i en tom streng:

        if("".equals(a)){
            return true;
        } else if("".equals(b)){
            return false;
        }

        // sorterer begge strengene til char array med quicksort algoritme:
        char[] charArray1 = sorterStringTilChar(a);
        char[] charArray2 = sorterStringTilChar(b);

        // sjekker om streng a er inneholdt i streng b og lagrer resultatet i
        // variabelen resultat:
        boolean resultat = erInneholdt(charArray1, charArray2,
                charArray1.length, charArray2.length);

        return resultat;
    }

    public static boolean erInneholdt(char[] a, char[] b, int lengdeA, int lengdeB) {

        int i = 0;
        int j = 0;

        // vi sammenligner arrayene a og b saa lenge vi er innenfor lengden av begge.
        while(i < lengdeA && j < lengdeB) {

            // Saa lenge foerste char i a er stoerre enn foerste char i b
            // traverserer vi bare videre i b:
            if(a[i] > b[j]) {
                j++;
            }
            // Hvis foerste char i a og b er lik, gaar vi videre til neste char
            // i baade a og b og sammenligner denne.
            else if(a[i] == b[j]){
                i++;
                j++;
            }
            // Dersom foerste char i a er mindre enn foerste char i b kan ikke
            // a lenger vaere inneholdt i b og vi returnerer false.
            else if (a[i] < b[j]) {
                return false;
            }
        }
        // Hvis vi har sammenlignet de to arrayene saa langt uten aa returnere false,
        // returnerer testen true dersom det ikke gjenstaar flere chars i a som
        // ikke er matchet i b.
        if (i < lengdeA) {
            return false;
        }
        else {
            return true;
        }

    }

    public static char[] sorterStringTilChar(String a){

        // vi konverterer stringen til et char-array.
        char[] charArray = a.toCharArray();

        // vi finner foerste og siste posisjon i arrayet.
        int foerste = 0, siste = a.length() -1;

        // Vi sorterer arrayet med en quicksort-algoritme.
        quickSort(charArray, foerste, siste);

        return charArray;

    }


// QuickSort-algoritme hentet fra begynnelse paa implementasjon under forelesning,
// supplert fra pensumlitteratur og internett siden vi ikke ble ferdig under
// forelesning.

    public static void quickSort(char[] values, int left, int right){


        int i = left;
        int j = right;
        char temp;

        int pivot = (left + right) / 2;

        while (i <= j) {
            while(values[i] < values[pivot]){
                i++;
            }
            while(values[j] > values[pivot]){
                j--;
            }

            if(i <= j) {
                temp = values[i];
                values[i] = values[j];
                values[j] = temp;
                i++;
                j--;
            }
        }
        if(left < j){
            quickSort(values, left, j);
        }
        if(i < right){
            quickSort(values, i, right);
        }
    }




//---------------------------------------------------------------------------------------//


    //Her brukte jeg hjelpe metoder fra kompendiet:

    public static void fratilKontroll(int tablengde, int fra, int til) {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ( "fra(" + fra + ") er negativ!" );

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ( "til(" + til + ") > tablengde(" + tablengde + ")" );

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ( "fra(" + fra + ") > til(" + til + ") - illegalt intervall!" );
    }


    public static int min(int[] a, int fra, int til) {

        if (a == null) throw new NullPointerException
                ( "parametertabellen a er null!" );

        fratilKontroll( a.length, fra, til );

        if (fra == til) throw new NoSuchElementException
                ( "fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!" );

        int m = fra;             // indeks til minste verdi i a[fra:til>
        int minsverdi = a[fra];  // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (a[i] < minsverdi) {
                m = i;               // indeks til minste verdi oppdateres
                minsverdi = a[m];    // minste verdi oppdateres
            }

        return m;  // posisjonen til minst verdi i a[fra:til>
    }

    public static int maksverdi(int[] a, int fra, int til) {

        if (a == null) throw new NullPointerException
                ( "parametertabellen a er null!" );

        fratilKontroll( a.length, fra, til );

        if (fra == til) throw new NoSuchElementException
                ( "fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!" );

        int m = fra;             // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];  // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
            if (a[i] > maksverdi) {
                m = i;               // indeks til største verdi oppdateres
                maksverdi = a[m];    // største verdi oppdateres
            }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maksverdi(int[] a)  // bruker hele tabellen
    {
        return maksverdi( a, 0, a.length );  // kaller metoden over
    }


    public static int min(int[] a)  // bruker hele tabellen
    {
        return min( a, 0, a.length );  // kaller metoden over
    }
}

