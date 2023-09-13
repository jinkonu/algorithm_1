package low_2.bruteForce_2;

/*
2023년 9월 13일 수요일
(1)
    brute force 문제다.
    15655번 문제와 매우 유사한데, 대신 중복을 허용한다.
(2)
    recursive()가 느려서 다른 사람의 답을 보고 recursive2()를 만들었는데 더 느리다.
    아무래도 재귀함수의 로직이 아니라 sequence를 정렬하는 과정에서 차이가 난 것 같다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NandM7_15656 {
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

        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        sequence = new ArrayList<>();
        int[] arr = new int[M];

        for (int i = 0; i < N; i++)
            sequence.add(Integer.parseInt(line2[i]));

        sequence.sort(Comparator.naturalOrder());

        recursive(0, arr);
//        recursive2(1, arr);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int index, int[] arr) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (int i = 0; i < N; i++) {
                arr[index] = sequence.get(i);
                recursive(index + 1, arr);
            }
        }
    }

    private static void recursive2(int index, int[] arr) {
        for (int i = 0; i < N; i++) {
            arr[index - 1] = sequence.get(i);

            if (index == M) {
                for (int j = 0; j < M; j++)
                    result.append(arr[j]).append(" ");
                result.append("\n");
            }
            else recursive2(index + 1, arr);
        }
    }
}
