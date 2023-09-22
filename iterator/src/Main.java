import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int [] a = {8,3,15,55,632,12,66,8,9,11};

        ArrayList<Integer> myList = new ArrayList<>();
        for (int i=0 ; i< a.length;i++){
            myList.add(a[i]);
        }
        myList.forEach(x-> System.out.println(x));

    }
}
/*
//hva er iteratør?
interface Iterator <T> {
boolean hasNext();
T next();
default void remove();
default void forEachRemaining(Consumer <T> c);
}
--split
 */