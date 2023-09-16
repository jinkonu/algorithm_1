package low_2.bruteForce_2;

/*
2023년 9월 16일 토요일
(1)
    input 수열에 중복 수가 있다는 점을 감안해야 하는 문제다.
    HashMap 등을 사용해서 중복 수끼리 관리를 할까 하다가 도저히 해결하지 못해서 다른 사람의 답을 봤다.
(2)
    핵심은 "if (arr[index] != sequence.get(i))"에 있었다.
    arr[] 수열을 만들어가면서, 이미 동일한 자리에 같은 수가 들어갔다면 이 if 문을 통과하지 못한다.
(3)
    그리고 어째서인지 78번째 줄을 보면 "arr[index] = 0"로 비워주고 있지만 이유를 알 수가 없다.
    이미 recursive()도 재귀적으로 호출했고, for 문도 벗어난 상태인데 왜 0으로 초기화해야 정상적으로 작동하는지 알고 싶다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.*;

public class NandM9_15663 {
    static StringBuilder result;
    static int N;
    static int M;
    static List<Integer> sequence;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

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

    public static void recursive(boolean[] visited, int[] arr, int index) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");

            result.append("\n");
        }

        else {
            for (int i = 0; i < N; i++)
                if (index == 0 || !visited[i]) {
                    visited[i] = true;
                    if (arr[index] != sequence.get(i)) {
                        arr[index] = sequence.get(i);
                        recursive(visited, arr, index + 1);
                    }
                    visited[i] = false;
                }

            arr[index] = 0;
        }
    }
}
