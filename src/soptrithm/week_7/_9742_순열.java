package soptrithm.week_7;

/*
* 순서를 빠르게 찾으려고 했지만
* 결국은 그냥 첫번째 순열부터 n개까지 찾는 게 정답이었다..
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9742_순열 {

    private static int totalCount, num;
    private static boolean visit[]; // 중복 방지 위해 방문했는지 체크하는 배열
    private static char[] chars; // 값을 담을 배열
    private static String answer;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            String str = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            totalCount = 0;
            chars = new char[str.length()];
            visit = new boolean[str.length()];

            dfs(str, 0);

            if (totalCount < num) answer = "No permutation";
            System.out.println(str + " " + num + " = " + answer);
        }
    }

    private static void dfs(String str, int cnt) {
        if (cnt == str.length()) {
            totalCount++;
            if (totalCount == num) answer = new String(chars);

            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!visit[i]) {
                visit[i] = true;
                chars[cnt] = str.charAt(i);
                dfs(str, cnt + 1);
                visit[i] = false;
            }
        }
    }
}