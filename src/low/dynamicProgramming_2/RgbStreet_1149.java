package low.dynamicProgramming_2;

/*
2023년 8월 30일 수요일
(1)
    dp를 활용하는 문제다.
    그렇지만 첫 시도 때는 recursive 메서드를 정의해서 호출하다가 "시간초과" 당했다.
(2)
    그래서 dp를 살릴 수 있는 방식으로 바꿨다.
    N개의 집을 칠해야 하지만, "그 중 k번째 집까지만 칠한다면?"이라는 질문 하에
    k = 2부터 k = N까지 이어가면서 k - 1번째까지의 선택을 참조해가면 된다.
    그 와중에 색깔만 겹치지 않도록 주의한다.
 */

import java.io.*;

import static java.lang.Math.*;

public class RgbStreet_1149 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        long answer = Long.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++)
                cost[i][j] = Integer.parseInt(line[j]);
        }

        for (int i = 1; i < N; i++) {
            cost[i][0] += min(cost[i - 1][1], cost[i - 1][2]);
            cost[i][1] += min(cost[i - 1][0], cost[i - 1][2]);
            cost[i][2] += min(cost[i - 1][0], cost[i - 1][1]);
        }

        for (long l : cost[N - 1])
            if (l < answer) answer = l;

        result.append(answer);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
