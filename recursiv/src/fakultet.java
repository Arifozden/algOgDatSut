public class fakultet {
    public static void main(String[] args) {
        int verdi=9;
        System.out.println(verdi+"! = "+factorial(verdi));
    }
    static int factorial(int n){
        if(n==1){
            return 1;
        }else {
            return n*factorial(n-1);
        }

    }
}
