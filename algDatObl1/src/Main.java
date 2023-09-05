import java.util.NoSuchElementException;

public class Main {
    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int [] verdier ) {
        if(verdier.length <= 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        for(int i = 0; i < verdier.length-1; i++){
            if(verdier[i] > verdier[i+1]){
                int bytt = verdier[i];
                verdier[i] = verdier[i+1];
                verdier[i+1] = bytt;

            }
        }
        return verdier[verdier.length-1];
    }

    public static int ombyttinger(int [] verdier ) {
        if(verdier.length <= 0){
            throw new NoSuchElementException("Tabellen er tom");
        }
        int antall = 0;
        for(int i = 0; i < verdier.length-1; i++){
            if(verdier[i] > verdier[i+1]){
                int bytt = verdier[i];
                verdier[i] = verdier[i+1];
                verdier[i+1] = bytt;
                antall++;

            }
        }
        return antall;
    }
}