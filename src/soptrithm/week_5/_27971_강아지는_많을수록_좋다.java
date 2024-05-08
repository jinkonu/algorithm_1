package soptrithm.week_5;

/*
* BFS로 해결하려 했으나 94%에서 계속 실패했다.
* 실패를 거듭하다 포기하고 dp 답안을 보고 참고했다.
* */

import java.io.*;
import java.util.StringTokenizer;

public class _27971_강아지는_많을수록_좋다 {

    static int n;
    static int m;
    static int a;
    static int b;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        if (A > B) {
            int swap = A;
            A = B;
            B = swap;
        }
        int[] dp = new int[N + 1];
        dp[0] = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            for (int j = s; j <= e; j++) {
                dp[j] = -1;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (dp[i] == -1)
                continue;

            // A보다 작으면 A 혹은 B의 합으로 도달할 수 없으므로 -1
            if (i < A) {
                dp[i] = -1;
            }

            // A와 B 사이에 있는 경우에 A의 합으로 도달할 수도 있으므로 dp[i] = dp[i - A] + 1
            else if (i < B) {
                if (dp[i - A] == -1)
                    dp[i] = -1;
                else
                    dp[i] = dp[i - A] + 1;
            }

            // A도 B도 뺐을 때 경우의 수가 없으므로 -1
            else if (dp[i - A] == -1 && dp[i - B] == -1)
                dp[i] = -1;

            // B로 뺐을 때만 경우의 수가 있으므로
            else if (dp[i - A] == -1)
                dp[i] = dp[i - B] + 1;

            // A로 뺐을 때만 경우의 수가 있으므로
            else if (dp[i - B] == -1)
                dp[i] = dp[i - A] + 1;

            // A와 B 둘 다 가능하므로
            else
                dp[i] = Math.min(dp[i - A], dp[i - B]) + 1;
        }
        System.out.println(dp[N]);

    }
}