package low_2.bruteForce_4;

/*
2023년 9월 22일 금요일
(1)
    brute force 문제다.
(2)
    부등식에 맞는 순열을 찾아서 최댓값이면 최댓값 StringBuilder에, 최솟값이면 최솟값 StringBuilder에 넣어준다.
 */

import java.io.*;

import static java.lang.Integer.*;

public class Inequality_2529 {
    static int k;
    static boolean[] inequality;
    static long max = Long.MIN_VALUE;
    static long min = Long.MAX_VALUE;
    static StringBuilder maxStr = new StringBuilder();
    static StringBuilder minStr = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        k = parseInt(br.readLine());
        inequality = new boolean[k];
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            if (line[i].equals("<")) inequality[i] = true;
        }

        recursive(new boolean[10], new int[k + 1], 0);
        result.append(maxStr).append("\n").append(minStr);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(boolean[] visited, int[] arr, int index) {
        if (index > k) {
            StringBuilder str = new StringBuilder();
            long sum = 0;

            for (int i = 0; i <= k; i++) {
                str.append(arr[i]);
                sum += arr[i] * Math.pow(10, k - i);
            }

            if (sum < min) {
                minStr = str;
                min = sum;
            }
            if (sum > max) {
                maxStr = str;
                max = sum;
            }
        }

        else if (index == 0) {                  // 첫 엔트리 넣기
            if (inequality[0]) {                // "<"로 시작
                for (int i = 0; i < 9; i++) {
                    arr[index] = i;
                    visited[i] = true;
                    recursive(visited, arr, index + 1);
                    visited[i] = false;
                }
            }

            else {
                for (int i = 1; i < 10; i++) {  // ">"로 시작
                    arr[index] = i;
                    visited[i] = true;
                    recursive(visited, arr, index + 1);
                    visited[i] = false;
                }
            }
        }

        else {
            for (int i = 0; i < 10; i++)
                if (!visited[i]) {
                    if ((inequality[index - 1] && i > arr[index - 1]) || (!inequality[index - 1] && i < arr[index - 1])) {
                        arr[index] = i;
                        visited[i] = true;
                        recursive(visited, arr, index + 1);
                        visited[i] = false;
                    }
                }
        }
    }
}
