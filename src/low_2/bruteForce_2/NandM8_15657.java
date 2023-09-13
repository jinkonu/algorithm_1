package low_2.bruteForce_2;

/*
2023년 9월 13일 수요일
(1)
    brute force 문제이다.
    15656번 문제와 유사하지만, 비내림차순을 유지해야 한다는 점이 다르다.
(2)
    recursive()는 for loop의 i를 sequence.indexOf(arr[index - 1])을 통해ㅏ,
    즉 마지막으로 arr에 들어간 수의 sequence에서의 인덱스 값을 얻어서 진행했지만 메서드를 지속적으로 호출하는 것보다
    메서드를 재귀적으로 호출하는 과정에서 파라미터로 이 인덱스 값을 넣어주는 게 좀 더 빠르지 않을까 하여 recursive2()로 리팩토링했다.
    결과적으론 8ms 정도로 유의미한 차이를 가져가진 못했다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NandM8_15657 {
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

//        recursive(0, arr);
        recursive2(0, 0, arr);
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
            int i;

            if (index == 0) i = 0;
            else i = sequence.indexOf(arr[index - 1]);

            for (; i < N; i++) {
                arr[index] = sequence.get(i);
                recursive(index + 1, arr);
            }
        }
    }

    private static void recursive2(int index, int lastNumIdx, int[] arr) {
        if (index == M) {
            for (int i = 0; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else {
            for (int i = lastNumIdx; i < N; i++) {
                arr[index] = sequence.get(i);
                recursive2(index + 1, i, arr);
            }
        }
    }
}
