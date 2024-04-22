package soptrithm.week_3;

/*
 * n = 90일 경우 피보나치 값이 너무 커진다.
 * BigInteger를 사용해보겠다.
 * */

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _2748_피보나치_수_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int n = Integer.parseInt(reader.readLine());
        List<BigInteger> pibonaccis = new ArrayList<BigInteger>();

        pibonaccis.add(BigInteger.ZERO);
        pibonaccis.add(BigInteger.ONE);

        dp(pibonaccis, n);
        result.append(pibonaccis.get(n));
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dp(List<BigInteger> pibonaccis, int n) {
        while (pibonaccis.size() <= n + 1) {
            BigInteger pibonacci = pibonaccis.get(pibonaccis.size() - 1).add(pibonaccis.get(pibonaccis.size() - 2));
            pibonaccis.add(pibonacci);
        }
    }
}
