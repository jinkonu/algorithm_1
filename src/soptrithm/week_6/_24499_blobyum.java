package soptrithm.week_6;

/*
 * 누적합이 가장 먼저 떠오르는 해법이다.
 * N = 8, K = 3, arr = {1, 2, 3, 4, 5, 6, 7, 8} -> 1, 3, 6, 10, 15, 21, 28, 36
 * 0-2, 1-3, ..., 6-0, 7-1 -> 2, 3 - 1, ..., 7 - 5 + 0, 7 - 6 + 1
 * 567, 670, 701, 012
 * 4567, 5670, 6701, 7012, 0123
 * */

import java.io.*;

public class _24499_blobyum {

    static int n;
    static int k;
    static int[] prefixSum;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        prefixSum = new int[n];

        input = reader.readLine().split(" ");
        prefixSum[0] = Integer.parseInt(input[0]);
        for (int i = 1; i < n; i++) {
            prefixSum[i] = Integer.parseInt(input[i]) + prefixSum[i - 1];
        }

        findMax();
        result.append(max);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void findMax() {
        max = prefixSum[k - 1];

        // 한 바퀴 돌기 전
        for (int i = k; i < n; i++) {
            int sum = prefixSum[i] - prefixSum[i - k];

            max = Math.max(max, sum);
        }

        // 한 바퀴 돌아야만 하는 때
        for (int i = 0; i < k - 1; i++) {
            int sum = prefixSum[n - 1];
            sum -= prefixSum[n - k + i];
            sum += prefixSum[i];

            max = Math.max(max, sum);
        }
    }
}
