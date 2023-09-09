import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int a = 12;
        int b = 10;
        int tmp;

        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

}