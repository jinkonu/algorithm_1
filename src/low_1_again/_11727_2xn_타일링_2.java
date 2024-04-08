package low_1_again;

/*
* dp의 핵심은 중복된 계산을 피하는 데에 있다.
* 이 문제는 n으로부터 1과 0까지 빼가면서 내려간다.
* 그런데 n이 높은 수라면, 2나 3같이 낮은 숫자가 나오는 케이스가 몇 백개 몇 만개씩으로 나온다.
* 그런데 각각의 2나 3 케이스를 기억하지 않고, 일일이 계산하는 데에서 문제가 발생한다.
* 따라서, 배열을 통해 dp[2]와 dp[3]이 얼마인지 계산해두면 병렬적인 케이스에서 계산 중복을 피할 수 있다.
*
* */

import java.io.*;

public class _11727_2xn_타일링_2 {

    static int mod = 10_007;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int n = Integer.parseInt(reader.readLine());
        dp = new int[n + 1];

        int cases = tiling(n);

        result.append(cases);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    static int tiling(int x) {
         if (x <= 1)
             return 1;

         if (dp[x] != 0)
             return dp[x];

         dp[x] = (2 * tiling(x - 2) + tiling(x - 1)) % mod;
         return dp[x];
    }
}
