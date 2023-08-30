package low.dynamicProgramming_1;

/*
2023년 8월 27일 일요일
(1)
    dynamic programming을 이용해서 푸는 일종의 knapsack 문제다.
(2)
    bottom to top 형식으로 카드 1개를 고를 때부터 int[] bestCases를 채워나갔다.
    카드 k개를 고를 때에는 bestCases의 1부터 k-1을 참고해서 만들 수 있다.
    그래서 귀납적으로 N까지 갈 수 있다.
 */

import java.io.*;

public class CardPurchase_11052 {
    static int[] bestCases;
    static int[] cardPacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        cardPacks = new int[N + 1];
        bestCases = new int[N + 1];
        for (int i = 1; i <= N; i++)
            cardPacks[i] = Integer.parseInt(inputs[i - 1]);

        bestCases[1] = cardPacks[1];
        for (int i = 2; i <= N; i++)
            bestCases[i] = recursive(i);

        result.append(bestCases[N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int recursive(int givenCards) {
        int best = 0;
        for (int i = givenCards; i >= 1; i--) {
            int result = cardPacks[i] + bestCases[givenCards - i];

            if (best < result)
                best = result;
        }

        return best;
    }
}
