package low_2.bruteForce_2;

/*
2023년 9월 12일 화요일
(1)
    brute force 문제다.
    15654번 문제와 크게 다르지 않고,
    다만 recursive()의 else 문에서 arr[index - 1]이 현재 가라키고 있는 i의 sequence[] 값보다 작을 경우만
    arr[]에 추가해서 오름차순을 유지했다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class NandM6_15655 {
    static int N;
    static int M;
    static List<Integer> sequence;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // LOGIC START
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        N = parseInt(line1[0]);
        M = parseInt(line1[1]);
        sequence = new ArrayList<>();

        for (int i = 0; i < N; i++)
            sequence.add(parseInt(line2[i]));

        sequence.sort(Comparator.naturalOrder());

        recursive(new boolean[N], new int[M], 0);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(boolean[] visited, int[] arr, int index) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (int i = 0; i < N; i++)
                if (!visited[i]) {
                    if (index == 0 || arr[index - 1] < sequence.get(i)) {
                        arr[index] = sequence.get(i);
                        visited[i] = true;
                        recursive(visited, arr, index + 1);
                        visited[i] = false;
                    }
                }
        }
    }
}
