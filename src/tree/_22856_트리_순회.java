package tree;

import java.io.*;

public class _22856_트리_순회 {

    static int N;
    static int moves = 0;
    static int[][] tree;
    static boolean[] visited;
    static int visitedCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // dfs로 찾으면 될 거 같다.
        // 움직이면서 횟수를 static으로 관리해서 더해가면 될 거 같다.
        // inorder traversal이 어떻게 이뤄지는지 생각하면서 문제를 풀어야 한다.
        // inorder traversal은 좌측에서 시작된 건 다시 올라가야 하지만, 우측에서 시작된 건 올라가면 안된다.
        N = Integer.parseInt(reader.readLine());

        tree = new int[N + 1][2];
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            String[] inputs = reader.readLine().split(" ");

            int a = Integer.parseInt(inputs[0]);
            int b = Integer.parseInt(inputs[1]);
            int c = Integer.parseInt(inputs[2]);

            if (b != -1) {
                tree[a][0] = b;
            }

            if (c != -1) {
                tree[a][1] = c;
            }
        }

        dfs(1, -1, true);
        dfs(1, -1, false);
        result.append(moves);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void dfs(int current, int parent, boolean toLeft) {
        int left = tree[current][0];
        int right = tree[current][1];

        if (left != 0 && !visited[left]) {
            ++moves;
            dfs(left, current, true);
        }

        if (!visited[current]) {
            ++visitedCount;
            visited[current] = true;

            if (visitedCount == N || current == 1) {
                return;
            }

            if (parent != -1) {
                if (current == tree[parent][0] || toLeft) {
                    ++moves;
                }
            }
        }

        if (right != 0 && !visited[right]) {
            ++moves;
            dfs(right, current, toLeft);
        }
    }
}
