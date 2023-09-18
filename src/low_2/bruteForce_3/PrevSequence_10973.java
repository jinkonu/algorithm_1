package low_2.bruteForce_3;

/*
2023년 9월 18일 화요일
(1)
    brute force 문제이다.
(2)
    10972번 문제와 알고리즘 상 findStart()의 for 문 내 if 절에서 부등호가 반대인 것을 제외하곤 동일하다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PrevSequence_10973 {
    static int N;
    static List<Integer> sequence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++)
            sequence.add(Integer.parseInt(line[i]));

        int start = findStart();

        if (start == -1)
            result.append("-1");

        else {
            boolean[] allocated = new boolean[N + 1];

            for (int i = 0; i < start; i++) {
                result.append(sequence.get(i)).append(" ");
                allocated[sequence.get(i)] = true;
            }

            for (int i = sequence.get(start) - 1; i > 0; i--)
                if (!allocated[i]) {
                    result.append(i).append(" ");
                    allocated[i] = true;
                    break;
                }

            for (int i = N; i > 0; i--)
                if (!allocated[i])
                    result.append(i).append(" ");
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int findStart() {
        int i = N - 2;

        for (; i >= 0; i--)
            if (sequence.get(i) > sequence.get(i + 1)) return i;

        return i;
    }
}
