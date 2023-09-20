public class Main {
    public static void main(String[] args) {
        int value = 15;
        int return_value = recursiveFunction(value);
        System.out.println("main : "+ return_value);

    }
    static int recursiveFunction(int value){
        System.out.println("Recursive function : " + value);
        if(value<=5){
            return -9;
        }else {
            return recursiveFunction(value-1);
        }
    }
}

