package low_2.bruteForce_3;

/*
2023년 9월 19일 화요일
(1)
    간단한 brute force 문제다.
(2)
    가능한 모든 n!개의 순열에 대해 sum을 비교해서 최솟값을 구하면 된다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MaximizeDifference_10819 {
    static int N;
    static List<Integer> sequence = new ArrayList<>();
    static int max;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            sequence.add(Integer.parseInt(line[i]));

        bruteForce(0);
        result.append(max);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void bruteForce(int index) {
        if (index == N) {
            int sum = 0;

            for (int i = 0; i < N - 1; i++)
                sum += Math.abs(arr[i] - arr[i + 1]);

            if (sum > max)
                max = sum;
        }

        else {
            for (int i = 0; i < N; i++)
                if (!visited[i]) {
                    arr[index] = sequence.get(i);
                    visited[i] = true;
                    bruteForce(index + 1);
                    visited[i] = false;
                }
        }
    }
}
