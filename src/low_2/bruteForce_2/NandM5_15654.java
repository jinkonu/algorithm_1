package low_2.bruteForce_2;

/*
2023년 9월 12일 화요일
(1)
    brute force 문제다.
    성능이 너무 안 나와서 다른 사람의 것을 확인했다.
(2)
    recursive() 쓰는 것은 동일한데 선택적으로 arr[]를 채울 때가 다르다.
    나는 "!arr.contains(sequence[i])"로 수열에 이미 값이 있는지 확인했지만, boolean[]을 쓰는 게 더 빠른 것 같다.
    그리고 List를 정렬할 때 Comparator.naturalOrder()를 호출하는 것이 Integer::CompareTo 호출하는 것보다 훨씬 빠르다.
(2)
    참고로, recursive()의 else 문에서 recursive()를 다시 호출한 이후 visited[i]를 false로 재변경해야 한다.
    그래야 건너뛰지 않고 제대로 [0 1 2] [1 2 3] 이런 식으로 수열을 쌓을 수 있다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NandM5_15654 {
    static StringBuilder result;
    static int N;
    static int M;
    static List<Integer> sequence;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        sequence = new ArrayList<>();
        arr = new int[M];

        for (int i = 0; i < N; i++)
            sequence.add(Integer.parseInt(line2[i]));

        sequence.sort(Comparator.naturalOrder());

        recursive(new boolean[N], 0);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(boolean[] visited, int index) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (int i = 0; i < N; i++)
                if (!visited[i]) {
                    arr[index] = sequence.get(i);
                    visited[i] = true;
                    recursive( visited, index + 1);
                    visited[i] = false;
                }
        }
    }
}
