package low_2.graph_2;

/*
2023년 10월 9일 월요일
(1)
    bfs를 통해 여러 점 집합 중에서 두 점 집합 간의 최소 거리를 구하는 문제다.
    나는 각 점 집합을 Stack으로 모아두고, 모든 Stack을 nC2로 두 개씩 잡아서
    Stack 내 모든 두 점 쌍에 대해 거리를 차로 구했다.
    그런데 성능이 너무 나오지 않아서 다른 사람의 답안을 참고해봤다.
(2)
    하나의 섬을 형성하는 동안 인덱스가 행렬에서 벗어나지는 않지만 섬이 아닌 바다에 해당하는 점을 border 큐에 모은다.
    섬을 다 형성하고 나서, border 큐를 가지고 가장 가까운 섬을 찾는다.
    border에 해당하는 점들에서 섬을 찾을 때까지 한 칸씩 전진한다.
    근데 막상 답안대로 했는데 틀렸다고 하는 이유를 모르겠다...
 */

import java.io.*;
import java.util.*;

import static java.lang.Integer.*;

public class MakeBridge_2146 {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair = (Pair) obj;

            return this.x == pair.x && this.y == pair.y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public static int sub(Pair p1, Pair p2) {
            return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        }
    }

    static int N;
    static boolean[][] country;
    static boolean[][] i_visited;
    static boolean[][] o_visited;
    static Queue<Pair> border;
    static Queue<Pair> queue;
    static int[] dx = new int[] {-1, 1, 0, 0};
    static int[] dy = new int[] {0, 0, -1, 1};
    static int min = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        country = new boolean[N][N];
        i_visited = new boolean[N][N];
        o_visited = new boolean[N][N];
        border = new LinkedList<>();
        queue = new LinkedList<>();


        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");

            for (int j = 0; j < N; j++)
                if (line[j].equals("1")) country[i][j] = true;
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (country[i][j] && !i_visited[i][j]) {
                    i_visited[i][j] = true;
                    queue.offer(new Pair(i, j));

                    while (!queue.isEmpty()) {
                        Pair p = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            Pair adj = new Pair(p.x + dx[k], p.y + dy[k]);

                            if (invalid(adj)) continue;
                            if (!country[adj.x][adj.y]) {
                                if (!o_visited[adj.x][adj.y]) {
                                    border.offer(adj);
                                    o_visited[adj.x][adj.y] = true;
                                }
                                continue;
                            }

                            i_visited[adj.x][adj.y] = true;
                            queue.offer(adj);
                        }
                    }

                    min = Math.min(min, findBridge(border));
                    border.clear();
                }

        System.out.print(min);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int findBridge(Queue<Pair> border) {
        boolean[][] checked = new boolean[N][N];
        int val = 0;
        Queue<Pair> tmp = new LinkedList<>();

        outer :
        while (!border.isEmpty()) {
            val++;

            for (int i = 0; i < border.size(); i++) {
                Pair dot = border.poll();

                for (int j = 0; j < 4; j++) {
                    Pair adj = new Pair(dot.x + dx[j], dot.y + dy[j]);

                    if (invalid(adj) || checked[adj.x][adj.y]) continue;
                    if (country[adj.x][adj.y]) break outer;

                    checked[adj.x][adj.y] = true;
                    border.offer(adj);
                }
            }
        }
        return val;
    }

    private static void print(boolean[][] checked) {
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked.length; j++)
                System.out.print(checked[i][j] + " ");
            System.out.println();
        }
    }

    private static boolean invalid(Pair pair) {
        int i = pair.x;
        int j = pair.y;

        return i < 0 || i >= N || j < 0 || j >= N || i_visited[i][j];
    }
}
