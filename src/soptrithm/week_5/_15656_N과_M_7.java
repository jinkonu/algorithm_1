package soptrithm.week_5;

/*
 * 같은 수 여러 번 고를 수 있다.
 * 사전 순으로 나열하지 않아도 된다.
 * dfs로 수열을 모으겠다.
 * */

import java.io.*;
import java.util.Arrays;

public class _15656_N과_M_7 {

    static int n;
    static int m;

    static int[] numbers;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        numbers = new int[n];

        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);

        dfs(0, new int[m]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int depth, int[] arr) {
        if (depth == m) {
            for (int number : arr)
                result.append(number).append(" ");

            result.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = numbers[i];
            dfs(depth + 1, arr);
        }
    }
}
