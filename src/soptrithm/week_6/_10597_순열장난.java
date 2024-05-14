package soptrithm.week_6;

/*
* dfs와 백트래킹을 사용한다는 사실은 알았지만
* 어딘가에서 어긋나서 결국 문제를 해결하는 데 실패했다.
* */

import java.io.*;

public class _10597_순열장난 {

    static String s;
    static boolean[] visited;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        s = reader.readLine();
        len = s.length();
        visited = new boolean[51];
        dfs(0, 0, "");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int idx, int n, String ans) {
        if (idx == len) {
            for (int i = 1; i <= n; i++) {
                if (!visited[i])
                    return;
            }

            System.out.println(ans.trim());
            System.exit(0);
            return;
        }

        String tmp = s.substring(idx, idx + 1);
        int num = Integer.parseInt(tmp);

        if (!visited[num]) {
           visited[num] = true;
           dfs(idx + 1, Math.max(num, n), ans + " " + tmp);
           visited[num] = false;
        }

        if (idx < len - 1) {
            tmp = s.substring(idx, idx + 2);
            num = Integer.parseInt(tmp);

            if (num < 51 && !visited[num]) {
                visited[num] = true;
                dfs(idx + 2, Math.max(num, n), ans + " " + tmp);
                visited[num] = false;
            }
        }
    }
}
