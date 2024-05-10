package soptrithm.week_5;

import java.io.*;
import java.util.Arrays;

public class _2512_예산 {

    static int n;
    static int budget;
    static int[] requests;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 1. 총합이 M보다 작거나 같을 경우 sorted[n - 1]
        * 2. 총합이 M보다 클 경우 int checked를 둔다.
        *       - 0부터 n-1 사이의 인덱스 k를 잡고, k 이전의 값들은 checked에 합한다.
        *       - (n - k) * sorted[k] < budget - checked면 k를 전진시킨다.
        *       - (n - k) * sorted[k] == budget - checked sorted[k]를 반환한다.
        *       - (n - k) * sorted[k] > budget - checked면 (total - checked) / (n - k)로 평균을 낸다.
        * */

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);

        requests = new int[n];
        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            requests[i] = Integer.parseInt(input[i]);
        Arrays.sort(requests);
        int total = Arrays.stream(requests).sum();

        input = reader.readLine().split(" ");
        budget = Integer.parseInt(input[0]);

        if (total <= budget)
            result.append(requests[n - 1]);

        else
            result.append(findMaxBudget());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int findMaxBudget() {
        int checked = 0;

        for (int i = 0; i < n; i++) {
            int x = (n - i) * requests[i];
            int y = budget - checked;

            if (x < y)
                checked += requests[i];
            else if (x == y)
                return requests[i];
            else
                return y / (n - i);
        }

        return 1;
    }
}
