package soptrithm.week_8;

import java.io.*;

public class _12841_정보대_등산 {

    static long n;
    static long[] cross = new long[100001];
    static long[] leftPrefixSum = new long[100001];
    static long[] rightPrefixSum = new long[100001];

    static long minCross = -1;
    static long minDistance = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 0번 지점에서 건널 경우 : leftPrefixSum[0] + cross[0] + (rightPrefixSum[n] - rightPrefixSum[0])
        * k번 지점에서 건널 경우 : leftPrefixSum[k] + cross[k] + (rightPrefixSum[n] - rightPrefixSum[k])
        * */
        n = Long.parseLong(reader.readLine());

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cross[i] = Long.parseLong(input[i]);
        }

        input = reader.readLine().split(" ");
        for (int i = 1; i < n; i++) {
            leftPrefixSum[i] += Long.parseLong(input[i - 1]) + leftPrefixSum[i - 1];
        }

        input = reader.readLine().split(" ");
        for (int i = 1; i < n; i++) {
            rightPrefixSum[i] += Long.parseLong(input[i - 1]) + rightPrefixSum[i - 1];
        }

        findMinDistance();
        result.append(minCross).append(" ").append(minDistance);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void findMinDistance() {
        for (int i = 0; i < n; i++) {
            long distance = leftPrefixSum[i] + cross[i] + (rightPrefixSum[(int) n - 1] - rightPrefixSum[i]);

            if (minDistance > distance) {
                minDistance = distance;
                minCross = i + 1;
            }
        }
    }
}
