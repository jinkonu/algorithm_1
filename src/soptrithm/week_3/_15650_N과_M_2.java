package soptrithm.week_3;

/*
 * dfs를 활용해서 nCr의 경우의 수를 찾는다.
 * 먼저 찾은 수보다 더 큰 크기의 수만 추가해야 한다.
 * */

import java.io.*;

public class _15650_N과_M_2 {

    static int N;
    static int M;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N + 1];

        for (int i = 1; i <= N - M + 1; i++) {
            visited[i] = true;
            dfs(i, 1, String.valueOf(i));
            visited[i] = false;
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int last, int size, String result) {
        if (size == M)
            System.out.println(result);

        for (int i = last + 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, size + 1, result + " " + i);
                visited[i] = false;
            }
        }
    }
}
