package low.dynamicProgramming_1;

import java.io.*;

public class CardPurchase2_16194 {
    static int[] cardPacks;
    static int[] bestCases;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        cardPacks = new int[N + 1];
        bestCases = new int[N + 1];
        for (int i = 1; i <= N; i++)
            cardPacks[i] = Integer.parseInt(input[i - 1]);

        bestCases[1] = cardPacks[1];
        for (int i = 2; i <= N; i++)
            bestCases[i] = dp(i);

        result.append(bestCases[N]);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int dp(int i) {
        int best = Integer.MAX_VALUE;
        for (int j = i; j >= 1; j--) {
            int retVal = cardPacks[j] + bestCases[i - j];
            if (retVal < best) best = retVal;
        }
        return best;
    }
}
