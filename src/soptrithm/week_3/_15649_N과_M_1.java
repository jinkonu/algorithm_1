package soptrithm.week_3;

import java.io.*;

public class _15649_N과_M_1 {

    static int n;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * nCr의 경우의 수를 모두 구해야 하는 문제다.
        * DFS와 유사하게 진행한다.
        * 현재까지 모은 수열 numbers[]의 크기가 r과 동일할 경우 탐색을 중단한다.
        * 현재까지 모은 수열 numbers[]에 있는 k가 아닌 모든 1-n 사이의 수에 대해 numbers[]에 추가하여 메서드를 계속 호출한다.
        * */

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);

        int[] numbers = new int[r];
        boolean[] visited = new boolean[n + 1];

        dfs(0, visited, "");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int size, boolean[] visited, String result) {
        if (size == r)
            System.out.println(result.substring(1));

        else {
            for (int i = 1; i <= n; i++)
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(size + 1, visited, result + " " + i);
                    visited[i] = false;
                }
        }
    }

    private static void print(int[] numbers) {
        for (Integer number : numbers)
            System.out.printf("%d ", number);

        System.out.println();
    }
}
