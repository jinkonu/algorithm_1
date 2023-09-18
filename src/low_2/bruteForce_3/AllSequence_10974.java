package low_2.bruteForce_3;

/*
2023년 9월 18일 화요일
(1)
    brute force 문제다.
(2)
    사전 순서대로 1 ~ N의 순열을 출력하기만 하면 돼서 어려울 것이 없다.
 */

import java.io.*;

public class AllSequence_10974 {
    static StringBuilder result;
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        printSequence(0);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void printSequence(int index) {
        if (index == N) {
            for (int i = 0; i < N; i++)
                result.append(arr[i]).append(" ");

            result.append("\n");
        }

        else {
            for (int i = 0; i < N; i++)
                if (!visited[i]) {
                    arr[index] = i + 1;
                    visited[i] = true;
                    printSequence(index + 1);
                    visited[i] = false;
                }
        }
    }
}
