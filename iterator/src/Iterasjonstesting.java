import java.util.ArrayList;
import java.util.Iterator;

public class Iterasjonstesting {
    public static void main(String[] args) {
        ArrayList<String> tabellListe = new ArrayList<>();
        tabellListe.add("Hei");
        tabellListe.add("Hallo");
        tabellListe.add("God dag!");

        Iterator<String> it = tabellListe.iterator();
        while (it.hasNext()){
            String verdi = it.next();
            System.out.println(verdi);
        }

        tabellListe.forEach(i-> System.out.println(i));

        for(String verdi : tabellListe){
            System.out.println(verdi);
        }

        it = tabellListe.iterator();
        it.forEachRemaining((verdi)-> System.out.println(verdi));
        it.forEachRemaining(System.out::println);
    }

}
