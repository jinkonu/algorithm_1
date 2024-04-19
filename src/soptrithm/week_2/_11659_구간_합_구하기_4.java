package soptrithm.week_2;

/*
 * 누적합 문제다.
 * [3]은 [0] ~ [3]까지의 합을 누적해서 가지고 있는다.
 * i=1&j=3에 대해 [3]을 낸다.
 * i=2&j=3에 대해 [3]-[1]을 낸다.
 * i=3&j=3에 대해 [3]-[2]을 낸다.
 * */

import java.io.*;

public class _11659_구간_합_구하기_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] metaLine = reader.readLine().split(" ");
        int N = Integer.parseInt(metaLine[0]);
        int M = Integer.parseInt(metaLine[1]);

        String[] numberLine = reader.readLine().split(" ");
        long[] prefixSum = new long[N + 1];

        for (int i = 1; i <= N; i++)
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(numberLine[i - 1]);

        for (int i = 0; i < M; i++) {
            String[] line = reader.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            result.append(prefixSum[y] - prefixSum[x - 1]).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
