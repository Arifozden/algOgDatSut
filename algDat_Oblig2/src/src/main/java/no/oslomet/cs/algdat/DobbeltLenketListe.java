package src.main.java.no.oslomet.cs.algdat;

import java.util.*;

public class DobbeltLenketListe<T> implements Liste<T> {
    // Innebygd (Trenger ikke endres)

    /**
     * Node class
     *
     * @param <T>
     */
    private static final class Node<T> {
        private T verdi;
        private Node<T> forrige, neste;

        private Node(T verdi, Node<T> forrige, Node<T> neste) {
            this.verdi = verdi; this.forrige = forrige; this.neste = neste;
        }
        private Node(T verdi) {this(verdi, null, null);}
    }

    private Node<T> hode;
    private Node<T> hale;
    private int antall;
    private int endringer;

    public void fraTilKontroll(int fra, int til) {
        if (fra < 0) throw new IndexOutOfBoundsException("fra("+fra+") er negativ.");
        if (til > antall) throw new IndexOutOfBoundsException("til("+til+") er større enn antall("+antall+")");
        if (fra > til) throw new IllegalArgumentException("fra("+fra+") er større enn til("+til+") - Ulovlig intervall.");
    }

    // Oppgave 0
    public static int gruppeMedlemmer() {
        return 3; // Returner hvor mange som er i gruppa deres
    }

    // Oppgave 1 - tekin
    public DobbeltLenketListe() {

        hode = null;
        hale = null;
        antall = 0;
        endringer = 0;
    }

    public DobbeltLenketListe(T[] a) { //så den genererer en dobbelt lenket liste
        // Kaster unntak for null tabell
        if(a == null){ throw new NullPointerException("Tabell a er null!"); }

        a = fjernNullVerdier(a);             // Fjerner alle null-verdier
        if(a.length == 0) { return; }         // Hopper ut av metoden hvis listen er tom

        Node<T> aktuell = new Node<>(a[0]);  // Opretter første node, og gir den verdi
        antall++;                            // Opdaterer antall noder
        hode = aktuell;                      // Setter hode lik første node

        for (int i = 1; i < a.length; i++) {
            Node<T> neste = new Node<>(a[i]);    // Opretter ny node
            antall++;                            // Opdaterer antall noder
            aktuell.neste = neste;               // Setter aktuell sin neste peker
            neste.forrige = aktuell;             // Setter neste sin forrige peker
            aktuell = neste;                     // Setter aktuell lik neste
        }
        hale = aktuell;                          // Setter halen lik siste node
    }
    //Hjelpemetode
    private T[] fjernNullVerdier (T[] a) {
        int antallNullverdier = 0;              // Teller for antall nullverdier

        for(T verdi : a){
            if(verdi == null){                  // Tester hvor mange verdier som er null
                antallNullverdier++;
            }
        }

        if(antallNullverdier == 0){ return a; }     // Returnerer oprinnelig liste hvis det ikke er noe nullverdier

        T[] b = (T[]) new Object[a.length - antallNullverdier];     // Opretter returlisten

        int j = 0;  // indeks for returlisten

        // Legger til alle verdiene som ikke er null til returlisten
        for(int i = 0; i < a.length; i++) {
            if(a[i] != null){
                b[j] = a[i];
                j++;
            }
        }

        return b;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public boolean tom() {
        return antall() == 0;
    }

    // Oppgave 2 - ali riza
    @Override
    public String toString() {
        if (antall == 0) {
            return "[]";
        }
        StringBuilder stBuilder = new StringBuilder();
        stBuilder.append("[");
        Node<T> node = hode;
        while (node != null && node.verdi != null) {
            if (node == hale) {
                stBuilder.append(node.verdi);
            } else {
                stBuilder.append(node.verdi).append(", ");
            }
            node = node.neste;
        }
        stBuilder.append("]");
        return stBuilder.toString();


    }

    public String omvendtString() {
        if (antall == 0) {
            return "[]";
        }
        StringBuilder stBuilder = new StringBuilder();
        stBuilder.append("[");
        Node<T> node = hale;
        while (node != null && node.verdi != null) {
            if (node == hode) {
                stBuilder.append(node.verdi);
            } else {
                stBuilder.append(node.verdi).append(", ");
            }
            node = node.forrige;
        }
        stBuilder.append("]");
        return stBuilder.toString();


    }

    @Override
    public boolean leggInn(T verdi) {
        if(verdi==null){
            throw new NullPointerException("Ikke tillat med null-verdier");
        }

        if (antall == 0 ) {
            hode = hale = new Node<>(verdi);
        } else {
            Node<T> ny = new Node<>(verdi);
            ny.forrige = hale;
            hale.neste=ny;
            hale = ny;
        }
        antall++;
        endringer++;
        return true;

    }

    // Oppgave 3 - arif
    private Node<T> finnNode(int indeks) {
        Node<T> returNode;

        if(indeks < antall/2) {                 // Hvis indeksen er mindre enn antall / 2, søker fra hode
            returNode = hode;
            int i = 0;

            // Setter returnNode lik neste verdi helt til indeksen stemmer
            while (i < indeks) {
                returNode = returNode.neste;
                i++;
            }
        } else {                                // Hvis indeks er >= antall / 2, søker fra hale
            returNode = hale;
            int i = antall-1;

            // Setter returnNode lik forrige verdi helt til indeksen stemmer
            while (i > indeks) {
                returNode = returNode.forrige;
                i--;
            }
        }

        return returNode;

    }

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks, false);      // Sjekker om indeksen er ugyldig
        // Finner noden til indeks og putter verdien inn i en variabel
        return finnNode(indeks).verdi;                      // Returnerer noden til indeks

    }

    @Override
    public T oppdater(int indeks, T nyverdi) {
        //Om nyverdi er null kastes et unntak
        if(nyverdi == null) { throw new NullPointerException("Nyverdi kan ikke være null"); }
        indeksKontroll(indeks, false);          // Sjekker om indeksen er ugyldig
        Node<T> node = finnNode(indeks);                 // Finner noden til indeks og putter verdien inn i en variabel
        T retVerdi = node.verdi;                      // Lagrer nodens nåværende veri
        node.verdi = nyverdi;                            // Oppdaterer noden sin verdi
        endringer++;                                     // Øker antall endringer med 1
        return retVerdi;                              // Returnerer nodens verdi før den ble oppdatert


    }


    public Liste<T> subliste(int fra, int til) {
        fratilKontroll(antall, fra, til);            // Sjekker at fra og til argumentene er innenfor listen sin lengde
        Node<T> aktuell = hode;                      // Lagerer hodet
        for(int i = 0; i < fra; i++) {
            aktuell = aktuell.neste;                 // Flytter aktuell fra hode til fra
        }
        T[] sublisteInput = (T[]) new Object[til-fra]; // Oppretter sublisteInput

        int indeks = 0;

        for(int i = fra; i < til; i++) {
            sublisteInput[indeks] = aktuell.verdi;        // Fyller sublisteInput med verdiene til [fra-til> sine noder
            aktuell = aktuell.neste;
            indeks++;
        }
        DobbeltLenketListe<T> subliste = new DobbeltLenketListe<>(sublisteInput); // Oppretter sublisten, og fyller den
        return subliste;

    }
    //Hjelpemetode
    private void fratilKontroll(int antall, int fra, int til) {
        if (fra < 0) {                                // fra er negativ
            throw new IndexOutOfBoundsException("fra(" + fra + ") er negativ!");
        }
        if (til > antall) {                        // til er utenfor tabellen
            throw new IndexOutOfBoundsException("til(" + til + ") > antall(" + antall + ")");
        }
        if (fra > til) {                               // fra er større enn til
            throw new IllegalArgumentException("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");
        }
    }


    // Oppgave 4
    @Override
    public int indeksTil(T verdi) {
        if(antall == 0 || verdi == null) {
            return -1;
        }
        Node<T> aktuell = hode;
        for(int i = 0; i < antall; i++) {
            if(aktuell.verdi.equals(verdi)) {
                return i;
            }
            aktuell = aktuell.neste;
        }
        return -1;
    }

    @Override
    public boolean inneholder(T verdi) {
        int indeks = indeksTil(verdi);
        if(indeks == -1) {
            return false;
        }
        return true;
    }

    // Oppgave 5 - ali riza
    @Override
    public void leggInn(int indeks, T verdi) {
        if(indeks < 0 || antall < indeks){                  //Unntak
            throw new IndexOutOfBoundsException("Kan ikke ha negativ indeks og antall kan ikke være mindre enn indeks.");
        }

        if(antall == 0) {
            leggInn(verdi);
            return;
        }

        else if(indeks == 0){
            Node<T> ny = new Node<>(verdi);                 //Oppretter ny hode
            ny.neste = hode;                                //Setter ny sin neste-peker lik hode
            hode.forrige = ny;                              //Setter hode sin forrige-peker lik ny
            hode = ny;                                      //Setter hode lik ny

        }

        else if(indeks == antall){
            Node<T> ny = new Node<>(verdi);                 //Oppretter ny hale
            ny.forrige = hale;                              //Setter ny sin forrige-peker lik hale
            hale.neste = ny;                                //Setter hale sin neste-peker lik ny
            hale = ny;                                      //Setter hale lik ny
        }

        else if(indeks > antall/2){                         //legger inn node fra høyre
            Node<T> aktuell = hode;
            for(int i = 0; i < indeks-1; i++){
                aktuell = aktuell.neste;
            }

            Node<T> ny = new Node<>(verdi);
            ny.neste = aktuell.neste;
            ny.forrige = aktuell;
            aktuell.neste = ny;
            ny.neste.forrige = ny;
        }

        else{
            Node<T> aktuell = hale;                         //legger inn node fra venstre
            for(int i = antall; i > indeks; i--){
                aktuell = aktuell.forrige;
            }

            Node<T> ny = new Node<>(verdi);
            ny.neste = aktuell.neste;
            ny.forrige = aktuell;
            aktuell.neste = ny;
            ny.neste.forrige = ny;


        }
        antall++;
        endringer++;
    }

    // Oppgave 6
    @Override
    public T fjern(int indeks) {
        if(indeks < 0) { throw new IndexOutOfBoundsException("Indeksen kan ikke være et negativt tall"); }
        if(indeks >= antall) { throw new IndexOutOfBoundsException("Indeksen kan ikke være større enn antall noder i listen"); }

        T returverdi;

        if(antall == 1){                    // Hvis siste element skal fjernes
            returverdi = hode.verdi;
            hode = null;
            hale = null;
        }else if(indeks == 0) {             // Hvis den første noden skal fjernes
            returverdi = hode.verdi;
            hode.neste.forrige = null;
            hode = hode.neste;
        }else if(indeks == antall-1) {      // Hvis den siste noden skal fjernes
            returverdi = hale.verdi;
            hale.forrige.neste = null;
            hale = hale.forrige;
        }else {                             // Hvis en node mellom to andre skal fjernes
            Node<T> aktuell = hode;
            int i = 0;
            while(i < indeks) {
                aktuell = aktuell.neste;
                i++;
            }

            returverdi = aktuell.verdi;
            aktuell.forrige.neste = aktuell.neste;
            aktuell.neste.forrige = aktuell.forrige;
        }

        antall--;
        endringer++;
        return returverdi;
    }

    @Override
    public boolean fjern(T verdi) {
        if(verdi == null) { return false;}
        Node<T> aktuell = hode;

        int i = 1;
        while(!aktuell.verdi.equals(verdi) && i < antall) {
            aktuell = aktuell.neste;
            i++;
        }

        if(i == antall && !aktuell.verdi.equals(verdi)) {
            return false;
        }

        if(antall == 1){
            hode = null;
            hale = null;
        }else if(aktuell.forrige == null) {
            hode.neste.forrige = null;
            hode = hode.neste;
        }else if(aktuell.neste == null) {
            hale.forrige.neste = null;
            hale = hale.forrige;
        }else {
            aktuell.forrige.neste = aktuell.neste;
            aktuell.neste.forrige = aktuell.forrige;
        }

        antall--;
        endringer++;
        return true;
    }

    // Oppgave 7
    @Override
    public void nullstill() {
        int startAntall = antall;
        for(int i = 0; i < startAntall; i++) {
            fjern(0);
        }
    }

    // Oppgave 8
    private class DobbeltLenketListeIterator implements Iterator<T> {
        private Node<T> denne;
        private boolean kanFjerne;
        private int iteratorendringer;

        private DobbeltLenketListeIterator() {
            denne = hode;                   // Starter på første i lista
            kanFjerne = false;              // Settes true når next() kalles
            iteratorendringer = endringer;  // Teller endringer
        }

        private DobbeltLenketListeIterator(int indeks) {
            indeksKontroll(indeks,false);
            denne = hode;
            kanFjerne = false;
            iteratorendringer = endringer;
            for (int i = 0; i < indeks; i++) {
                next();
            }
        }

        @Override
        public boolean hasNext() {
            return denne != null;
        }

        @Override
        public T next() {
            if (iteratorendringer != endringer) {
                throw new ConcurrentModificationException("iteratorendringer er ikke lik endringer,");
            }
            if (!hasNext()) {
                throw new NoSuchElementException("Det er ikke flere node i lista");
            }
            //Objects.requireNonNull(denne,"");
            kanFjerne = true;
            T retVedi = denne.verdi;
            denne = denne.neste;
            return retVedi;

        }

        // Oppgave 9:
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public Iterator<T> iterator() {
        return new DobbeltLenketListeIterator();
    }

    public Iterator<T> iterator(int indeks) {
        indeksKontroll(indeks,false);
        return new DobbeltLenketListeIterator();
    }

    // Oppgave 10
    public static <T> void sorter(Liste<T> liste, Comparator<? super T> c) {
        throw new UnsupportedOperationException();
    }
}
