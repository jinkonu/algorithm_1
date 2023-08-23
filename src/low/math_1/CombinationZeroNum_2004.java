package low.math_1;

import java.io.*;

import static java.lang.Math.min;
import static java.lang.Math.pow;

public class CombinationZeroNum_2004 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int tmp = 1;
        int five = 0; int two = 0;

        while (pow(5, tmp) <= n) {
            five += (n / (int)pow(5, tmp));

            if (pow(5, tmp) <= m) {
                five -= (m / (int)pow(5, tmp));
            }

            if (pow(5, tmp) <= (n - m)) {
                five -= ((n - m) / (int)pow(5, tmp));
            }

            ++tmp;
        }

        tmp = 1;

        while (pow(2, tmp) <= n) {
            two += (n / (int)pow(2, tmp));

            if (pow(2, tmp) <= m)
                two -= (m / (int)pow(2, tmp));

            if (pow(2, tmp) <= (n - m))
                two -= ((n - m) / (int)pow(2, tmp));

            ++tmp;
        }

        result.append(min(two, five));
        // LOGIC FINISH
        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
