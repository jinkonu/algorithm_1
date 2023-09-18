package low_2.bruteForce_3;

/*
2023년 9월 18일 월요일
(1)
    brute force 문제다.
    사전 순으로 다음 순열을 적어야 한다.
(2)
    처음에는 모든 순열을 다 찾고, 입력값 순열의 다음 순열을 집어서 출력하려 했으나 시간 초과가 발생했다.
    그래서 접근 방식을 바꿨다.
(3)
    사전 순 수열을 보면, 다음 순열에서 수열이 바뀌는 구간이 정해져 있다.
    그 구간은, 맨 오른쪽에서부터 처음으로 오름차순을 보이는 두 수열까지다.
    그래서 그 구간의 왼쪽으로는 입력값을 베끼고, 오른쪽은 다음 순열을 계산해서 집어넣었다.
    다음 순열도 사실, 그 순열의 가장 왼쪽을 지키고 있던 수의 다음으로 큰 수를 집어넣고 나머지를 사전 순으로 채워넣으면 된다.
    (위 문장을 나중의 내가 해석하지 못할 가능성이 높을 것 같지만 현재로서는 그렇게 말할 수밖에 없을 것 같다.)
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class NextSequence_10972 {
    static StringBuilder result;
    static int N;
    static List<Integer> sequence = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < N; i++)
            sequence.add(Integer.parseInt(line[i]));

        int start = findStart();

        if (start == -1)
            result.append("-1");

        else {
            List<Integer> nextSequence = new ArrayList<>();
            boolean[] allocated = new boolean[N + 1];

            // 순서가 유지되는 수열까지 미리 nextSequence에 포함시키기
            for (int i = 0; i < start; i++) {
                nextSequence.add(sequence.get(i));
                allocated[sequence.get(i)] = true;
            }

            // 순서가 바뀌는 수열의 첫 수를 찾아서 넣기 -> 사전 순으로
            for (int i = sequence.get(start) + 1; i <= N; i++)
                if (!allocated[i]) {
                    nextSequence.add(i);
                    allocated[i] = true;
                    break;
                }

            // 나머지 수열 채우기
            for (int i = 1; i <= N; i++)
                if (!allocated[i])
                    nextSequence.add(i);

            // 출력
            for (Integer i : nextSequence) {
                result.append(i).append(" ");
            }
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
            if (sequence.get(i) < sequence.get(i + 1)) return i;

        return i;
    }
}
