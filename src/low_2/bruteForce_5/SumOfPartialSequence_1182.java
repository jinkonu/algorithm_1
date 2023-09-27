package low_2.bruteForce_5;

/*
2023년 9월 25일 월요일
(1)
    brute force 문제이다.
    처음에는 순열을 만들어가면서 sum을 구했는데,
    그 방식보다 입력 수열의 매 인덱스마다 더할지 말지 두 개로 나눠서 2 ^ N으로 접근하는 것이 빨랐다.
(2)
    문제는 findPS()는 문제 유형에 맞게 비트마스크를 구현했지만 너무 느렸다는 것이고,
    반대로 다른 답안을 참고한 findPS2()는 비트마스크 코빼기도 안보이지만 성능이 괜찮다는 것이다.
(3)
    그런데 생각해보면, bit이라는 변수는 수열을 만들어가면서 중복되지 않기 위해 만들었다.
    문제는, 어차피 0부터 N - 1까지 올라가는 와중에 수열끼리 중복될 일이 없다는 것이다...
 */

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class SumOfPartialSequence_1182 {
    static int N;
    static int S;
    static List<Integer> sequence = new ArrayList<>();
    static Set<Integer> bitSet = new HashSet<>();
    static int bit;
    static int sum;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        N = parseInt(line1[0]);
        S = parseInt(line1[1]);

        for (int i = 0; i < N; i++)
            sequence.add(parseInt(line2[i]));

//        findPS(0, 0);
//        result.append(bitSet.size());
        findPS2(0, 0, false);
        result.append(cnt);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void findPS2(int sum, int index, boolean changed) {
        if (sum == S && changed) ++cnt;
        if (index < N) {
            findPS2(sum, index + 1, false);
            findPS2(sum + sequence.get(index), index + 1, true);
        }
    }

    private static void findPS(int sum, int index) {
        if (index == N) {
            if (sum == S && bit > 0) bitSet.add(bit);
            return;
        }

        // 해당 인덱스의 수를 순열에서 선택하지 않음
        findPS(sum, index + 1);

        // 해당 인덱스의 수를 순열에서 선택함
        bit |= 1 << index;
        findPS(sum + sequence.get(index), index + 1);
        bit &= ~(1 << index);
    }
}
