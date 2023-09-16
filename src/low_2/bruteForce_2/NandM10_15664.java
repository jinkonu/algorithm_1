package low_2.bruteForce_2;

/*
2023년 9월 16일 토요일
(1)
    15663번 문제와 거의 유사하다.
    그래서 참고했다.
(2)
    15663번 문제와 차이는 recursive()에서 else 문에 등장한다.
    arr[index - 1] <= sequece.get(i)를 통과하는 수만 수열의 다음 수로 참고하고 있다.
    그런데 index가 0일 때를 고려하기 위해 index == 0을 or 조건으로 추가했다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.*;

public class NandM10_15664 {
    static StringBuilder result;
    static int N;
    static int M;
    static List<Integer> sequence = new ArrayList<>();
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        N = parseInt(line1[0]);
        M = parseInt(line1[1]);

        for (int i = 0; i < N; i++)
            sequence.add(parseInt(line2[i]));

        sequence.sort(Comparator.naturalOrder());

        visited = new boolean[N];
        arr = new int[M];

        recursive(0);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int index) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (int i = 0; i < N; i++)
                if (index == 0 || (!visited[i] && arr[index - 1] <= sequence.get(i))) {
                    visited[i] = true;
                    if (arr[index] != sequence.get(i)) {
                        arr[index] = sequence.get(i);
                        recursive(index + 1);
                    }
                    visited[i] = false;
                }

            arr[index] = 0;
        }
    }
}
