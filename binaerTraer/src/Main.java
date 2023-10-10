public class Main<T> {
    private class Node<T>{
        Node <T> venstre;
        Node <T> hoyre;
        T verdi;

        public Node(T verdi){
            this.verdi=verdi;
            venstre=null;
            hoyre=null;
        }

        public Node(T verdi, Node<T> venstre, Node<T> hoyre){
            this.verdi=verdi;
            this.venstre=venstre;
            this.hoyre=hoyre;
        }
    }

    Node<T> rot;
    int antall;


    public Main(){
        rot=null;
        antall=0;
    }

    public void leggInn(int indeks, T verdi){
        //ide: legg inn verdien på en gitt indeks
        //if(indeks!=1 && rot==null) throw new IndexOutOfBoundsException();
        //if(indeks==1)
        //String binærverdi= Integer.toBinaryString(indeks);
        char [] binærverdi= Integer.toBinaryString(indeks).toCharArray();

        Node<T> currentNode=rot;
        for (int i = 1; i < binærverdi.length; ++i) {
            if(binærverdi[i]=='0') currentNode=currentNode.venstre;
            else currentNode=currentNode.hoyre;
            if(currentNode==null) throw new IndexOutOfBoundsException("Prøver å gjøre noe ikke lov");
        }

        if(binærverdi[binærverdi.length-1]=='0'){
            currentNode.venstre = new Node<T>(verdi);
        }
        else {
            currentNode.hoyre=new Node<T>(verdi);
        }

    }

}
//binærtrær

//rot har indeks 1
//venstrebarn 2.k
//høyrebarn 2.k+1

//plassering av noder

//implementasjon - se livekoding

//Bredde først && Dybde først

//rekkefølge

//nivå traversering (nivå orden)