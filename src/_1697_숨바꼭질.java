import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _1697_숨바꼭질 {

    static int N;
    static int K;
    static boolean[] visited;
    static int time;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // BFS를 활용하자.
        String[] inputs = reader.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        K = Integer.parseInt(inputs[1]);
        visited = new boolean[200_001];

        bfs();
        result.append(time);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs() {
        Queue<HideAndSeek> queue = new LinkedList<>();
        queue.add(new HideAndSeek(N, 0));

        while (!queue.isEmpty()) {
            HideAndSeek current = queue.poll();
            visited[current.point] = true;

            if (current.point == K) {
                time = current.time;
                return;
            }

            int[] possibles = {current.point - 1, current.point + 1, current.point * 2};
            for (int possible : possibles) {
                if (isValid(possible)) {
                    queue.add(new HideAndSeek(possible, current.time + 1));
                }
            }
        }
    }

    private static boolean isValid(int point) {
        return point >= 0 && point < 200_000 && !visited[point];
    }
}

class HideAndSeek {

    int point;
    int time;

    public HideAndSeek(int point, int time) {
        this.point = point;
        this.time = time;
    }
}
