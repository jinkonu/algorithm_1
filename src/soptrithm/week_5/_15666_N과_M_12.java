package soptrithm.week_5;

/*
 *
 * 1 <= N, M <= 8
 * N개의 수 중 n <= 10_000
 * DFS로 순회하면 되지 않을까?
 * */

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class _15666_N과_M_12 {

    static int n;
    static int m;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        Set<Integer> numberSet = new HashSet<>();
        input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++)
            numberSet.add(Integer.parseInt(input[i]));
        numbers = numberSet.stream().mapToInt(i -> i).sorted().toArray();

        dfs(0, 0, "");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int depth, int lastIndex, String seq) {
        if (depth == m) {
            System.out.println(seq);
            return;
        }

        for (int i = lastIndex; i < numbers.length; i++) {
            dfs(depth + 1, i, seq + numbers[i] + " ");
        }
    }
}
