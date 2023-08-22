import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        int [] vals={16,3,8,9,2,7,6};
        int maks_verdi = vals [0];
        for (int i=1;i< vals.length;++i){
            int verdi = vals[i];
            if(verdi>maks_verdi){
                maks_verdi=verdi;
            }
        }
        System.out.println(maks_verdi);
    }
}