package low_2.bruteForce_3;

/*
2023년 9월 20일 수요일
(1)
    brute force 문제이다.
(2)
    lotto()의 else 문에서 for loop를 필요한 부분까지만 돌리도록 하는 것이 더 빠를 것 같아서 아래 버전에서 다르게 수정해봤다.
    그러나 그 버전이 더 느린 관계로 이 버전을 그대로 쓰겠다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Lotto_6603 {
    static StringBuilder result;
    static int N;
    static List<Integer> sequence;
    static int[] arr;
    static final int LOTTO_NUM = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");

        while (parseInt(line[0]) != 0) {
            N = parseInt(line[0]);
            sequence = new ArrayList<>();
            arr = new int[LOTTO_NUM];

            for (int i = 0; i < N; i++)
                sequence.add(parseInt(line[i + 1]));

            sequence.sort(Comparator.naturalOrder());

            lotto(0);
            result.append("\n");

            line = br.readLine().split(" ");
        }

        result.delete(result.length() - 2, result.length());
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void lotto(int index) {
        if (index == LOTTO_NUM) {
            for (int i = 0; i < LOTTO_NUM; i++)
                result.append(arr[i]).append(" ");

            result.append("\n");
        }

        else if (index == 0) {
            for (int i = 0; i < N - LOTTO_NUM + 1; i++) {
                arr[index] = sequence.get(i);
                lotto(index + 1);
            }
        }

        else {
            int i = sequence.indexOf(arr[index - 1]) + 1;
            for (; i < N; i++) {
                arr[index] = sequence.get(i);
                lotto(index + 1);
            }
        }
    }
}
