package soptrithm.week_1;

/*
*
* 일반 소수 구하는 것과 동일하게 적용했다.
* 2n까지 구한 후, n부터 2n까지만 boolean[]을 순회한다.
* */

import java.io.*;

public class _4948_베르트랑_공준 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int n;

        while (true) {
            n = Integer.parseInt(reader.readLine());
            if (n == 0) break;

            boolean[] isNotPrime = getPrime(n);

            int total = 0;
            for (int i = n + 1; i <= 2 * n; i++)
                if (!isNotPrime[i]) ++total;

            result.append(total).append("\n");
        }


        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void getPrime2(boolean[] isNotPrime) {
        int end = (int) Math.sqrt((double) isNotPrime.length - 1);

        for (int i = 1; i <= end; i++) {
            int currentNumber = i * 2;

            for (int j = currentNumber; j <= isNotPrime.length - 1; j += currentNumber) {
                isNotPrime[currentNumber] = true;
            }
        }
    }

    private static boolean[] getPrime(int n) {
        boolean[] isNotPrime = new boolean[2 * n + 1];
        int end = (int) Math.sqrt((double) isNotPrime.length - 1);

        for (int i = 2; i <= end; i++) {
            for (int j = i * 2; j <= 2 * n; j += i) {
                isNotPrime[j] = true;
            }
        }

        return isNotPrime;
    }
}
