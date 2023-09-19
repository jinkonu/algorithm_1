package low_2.bruteForce_3;

/*
2023년 9월 19일 화요일
(1)
    brute force 문제인 줄 알았는데 dynamic programming으로 풀어야 한다.
    brute force로 했더니 너무 느렸다.
    dp로 풀려고 했지만 간단한 방식이 도저히 떠오르지 않아 다른 사람의 것을 참고해서 작성했다.
(2)
    우선 dp[N][statusFullBit]은 비트마스크를 사용한 방식이다.
    첫번째 인덱스는 가장 마지막으로 도달한 노드고, 두번째 인덱스는 그 자신을 포함해서 방문한 노드의 비트값이다.
    이 비트값은, 예를 들어 {0, 1, 2, 3}의 그래프를 기준으로 {0, 2}까지 가봤다면 그 값은 0101로 십진수로는 5가 될 것이다.
(3)
    dp[0][0001]에서 시작한다.
    그러면 다음으로 갈 곳은 {1, 2, 3} 모두 가능하다. (만약 0에서 1, 2, 3 모두 갈 수 있다면)
    그러면 tsp(1, 0011) + cost[0][1], tsp(2, 0101) + cost[0][2], tsp(3, 1001) + cost[0][3] 중에서 최솟값이 dp[0][0001]을 먹는다.
(4)
    tsp(1, 0011)로 들어가면, 다시 {2, 3}이 가능하다. (만약 1에서 2, 3 모두 갈 수 있다면)
    그러면 tsp(2, 0111) + cost[1][2], tsp(3, 1011) + cost[1][3] 중에서 최솟값이 dp[1][0011]을 먹는다.
(5)
    위와 같은 방식으로 0에서 시작해서 0으로 돌아오는 최소 비용을 구할 수 있다.
    문제는, 0이 아닌 노드에서 시작하는 경우까지 이 dp가 커버할 수 있다는 점이다.
    예를 들어, {0 -> 1 -> 2 -> 3 -> 0}은 {1 -> 2 -> 3 -> 0 -> 1}의 비용과 동일하다.
    이처럼 이번 문제는 사이클을 이루기 때문에 0에서 시작한 것으로 다른 노드에서 시작한 최소 비용까지 커버할 수 있다고 한다.
 */

import java.io.*;
import java.util.Arrays;

import static java.lang.Integer.*;

public class TSP2_10971 {
    static int N, statusFullBit, INF = 987654321;
    static int[][] cost, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        statusFullBit = (1 << N) - 1;
        cost = new int[N][N];
        dp = new int[N][statusFullBit];

        // cost 입력값 받기
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                cost[i][j] = parseInt(line[j]);
        }

        // dp 모든 엔트리 -1로 채우기
        for (int i = 0; i < N; i++)
            Arrays.fill(dp[i], -1);

        result.append(tsp(0, 1));
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int tsp(int x, int check) {
        // 모든 도시를 돌았을 경우
        if (check == statusFullBit) {
            if (cost[x][0] == 0) return INF;    // 경로가 존재하지 않으면 INF로 검색 무효화
            else return cost[x][0];             // 경로가 존재하면 비용 반환
        }

        // 이미 방문한 도시일 경우
        if (dp[x][check] != -1) return dp[x][check];

        // 해당 도시에 출석 표시
        dp[x][check] = INF;

        // 방문하지 않은 도시 찾기
        for (int i = 0; i < N; i++) {
            // next : i 도시 방문
            int next = check | (1 << i);

            // 경로가 없거나 이미 i 도시를 방문한 경우 continue
            if (cost[x][i] == 0 || (check & (1 << i)) != 0) continue;

            // dp 구하기
            dp[x][check] = Math.min(dp[x][check], tsp(i, next) + cost[x][i]);
        }

        return dp[x][check];
    }
}
