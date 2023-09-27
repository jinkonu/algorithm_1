import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        boolean[][] x = new boolean[1][1];
        boolean[][] y = x;

        x[0][0] = true;

        System.out.println(y[0][0]);
    }

}