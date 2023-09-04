package low.dynamicProgramming_2;

/*
2023년 9월 4일 월요일
(1)
    dp 문제다. 비슷한 유형으로 1912번이 있다.
    그런데 잘 풀지를 못했다. 그래서 결국 다른 사람의 것을 베껴다가 제출했다.
(2)
    진짜 문제는, 내가 왜 틀린지를 알지 못한다는 것이다.
    int[] dp는 0에서부터 i번째까지 확인했을 때, sequence[i]를 포함하면서 최적의 수열의 합을 담은 배열이다.
    sequence[i]가 0 이상이라면 dp[i - 1]에 자신을 그대로 합치면 된다.
    (이어지려면 i-1도 포함해야 하고, i-1이 쌓아온 최적의 dp 값을 쓰면 되기 때문에)
    sequence[i]가 음수라면, j = i-1부터 0까지 내려가면서 sequence[j] + dp[j]가 음수가 되는 구간 바로 앞에서 수열을 끊어주면 된다.
    (sequence[j]가 음수이면서, 그 자신을 수열에서 빼지 못한다면 dp[j]가 음수가 되어서 필요가 없어지기 때문이다)
    대신에, dp[j]까지 훑으면서 찾은 최소 sequence[j] 음수 값을 만약 발견한다면 이 값을 수열에서 제외하고, sequence[i]는 dp[i]에 그대로 반영해야 한다.
(3)
    질문 게시판에서 반례를 찾아보니, 수열에 음수밖에 없다면 최소 음수 하나를 가진 수열로 해야할 것 같아서
    line : 69-73에 for loop를 넣게 되었다.
(4)
    아무튼 위와 같은 과정으로 풀었고, 반례도 질문 게시판에서 찾아서 돌려봤지만 전부 맞았다.
    그래서 결론은, 답을 모르겠다 ...
 */

import java.io.*;

import static java.lang.Math.*;

public class SequentialAdd2_13398 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] sequence = new int[n];
        int[] dp = new int[n];
        int ans = 0;

        for (int i = 0; i < n; i++)
            sequence[i] = Integer.parseInt(line[i]);

        dp[0] = max(0, sequence[0]);
        for (int i = 1; i < n; i++) {
            dp[i] = max(0, sequence[i]);

            if (sequence[i] >= 0)                   // 해당 인덱스의 값이 0 이상이면 계속해서 이어가기만 하면 됨
                dp[i] += dp[i - 1];

            else {                                  // 해당 인덱스의 값이 0 미만이면 제외를 못시켰을 때의 dp[j]가 0미만이기 전까지만 이어가면 됨
                int minVal = sequence[i];

                for (int j = i - 1; j >= 0; j--) {
                    if (dp[j] + sequence[j] < 0) break;

                    dp[i] += sequence[j];
                    if (sequence[j] < minVal) minVal = sequence[j];
                }

                dp[i] += sequence[i];               // 최소 음수를 수열에서 빼주기 위해 자신을 우선 더해준다.
                dp[i] -= minVal;                    // 최소 음수를 수열에서 빼준다.
            }

            if (ans < dp[i]) ans = dp[i];
        }

        if (ans == 0) {
            ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++)
                ans = max(ans, sequence[i]);
        }

        result.append(ans);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
