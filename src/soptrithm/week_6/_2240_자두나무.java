package soptrithm.week_6;

/*
* dp 방법을 생각해내기가 어려웠다.
* 2차원 배열로 dp[현재 시간][위치로 오기까지 이동한 거리]로 풀었다.
* 그리고 위치로 오기까지 이동한 거리가 홀수인지 짝수인지로 현재 위치를 파악할 수 있었다.
* */

import java.util.*;
import java.io.*;

public class _2240_자두나무 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] tree = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        int pos = 1;
        int[][] dp = new int[T + 1][W + 1];
        int answer = 0;

        // 시간 순으로
        for (int t = 1; t <= T; t++) {
            int treePos = tree[t];

            // 현재 시간에 이동한 횟수 순으로
            for (int w = 0; w <= W; w++) {
                // 이동 안했을 때
                if (w == 0) {
                    pos = 1;
                    // 현재 위치(1)와 열매 위치가 같을 때
                    if (treePos == pos) {
                        dp[t][w] = dp[t - 1][w] + 1;
                    }
                    // 다를 때
                    else {
                        dp[t][w] = dp[t - 1][w];
                    }

                    continue;
                }

                // 이동 했을 때
                // 짝수번째 이동 -> 1번 나무 밑
                if(w % 2 == 0) {
                    pos = 1;
                    // 현재 위치와 나무가 일치
                    if(pos == treePos) {
                        dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                    }
                    // 위치 불일치
                    else {
                        dp[t][w] = Math.max(dp[t-1][w-1] + 1, dp[t-1][w]);
                    }
                }
                // 홀수번째 이동 -> 2번 나무 밑
                else {
                    pos = 2;
                    // 현재 위치와 나무가 일치
                    if(pos == treePos) {
                        dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                    }
                    // 위치 불일치
                    else {
                        dp[t][w] = Math.max(dp[t-1][w-1] + 1, dp[t-1][w]);
                    }
                }

                answer = Math.max(answer, dp[t][w]);
            }

        }

        System.out.println(answer);
    }
}
