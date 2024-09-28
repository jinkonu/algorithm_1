package dp;

import java.io.*;

public class _11049_행렬_곱셈_순서 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * dp[i] = i번째까지의 행렬 곱셈에 대해 최소 연산의 수
        * */

        int n = Integer.parseInt(reader.readLine());
        long[] arr = new long[n];

        if (n == 1) {
            result.append(0);
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            String[] line = reader.readLine().split(" ");
            arr[i] = Long.parseLong(line[0]);
        }
        arr[n - 1] = Long.parseLong(reader.readLine().split(" ")[1]);

        long[] dp = new long[n];
        long min = Long.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
