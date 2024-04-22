package soptrithm.week_2;

/*
 * int[][][] tomatoes = new int[h][m][n]
 * 처음에 읽을 때 1인 토마토는 큐에 모으고, 0인 토마토에 대해서는 개수를 저장한다.
 * 큐에서 모든 토마토를 꺼내서 근처 토마토를 익힌다.
 * 익힌 토마토의 tomatoes 값을 변경하고, 0 토마토 개수를 줄인다.
 * */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _7569_토마토 {

    static int H;
    static int M;
    static int N;
    static int[][][] tomatoes;
    static int numberOfZero = 0;

    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        String[] metaLine = reader.readLine().split(" ");
        H = Integer.parseInt(metaLine[2]);
        M = Integer.parseInt(metaLine[0]);
        N = Integer.parseInt(metaLine[1]);
        tomatoes = new int[H][N][M];
        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] line = reader.readLine().split(" ");

                for (int k = 0; k < M; k++) {
                    int value = Integer.parseInt(line[k]);

                    if (value == 0)
                        ++numberOfZero;
                    else if (value == 1)
                        queue.offer(new Tomato(i, j, k));

                    tomatoes[i][j][k] = value;
                }
            }
        }

        result.append(bfs(queue));
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int bfs(Queue<Tomato> queue) {
        int days = 0;

        while (!queue.isEmpty()) {
            if (numberOfZero == 0)
                return days;

            Queue<Tomato> nextQueue = new LinkedList<>();
            addNearTomatoes(queue, nextQueue);

            ++days;
//            print(days);
            queue = nextQueue;
        }

        return -1;
    }

    private static void print(int days) {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    System.out.printf("%3d", tomatoes[i][j][k]);
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("days = " + days);
        System.out.println();
    }

    private static void addNearTomatoes(Queue<Tomato> queue, Queue<Tomato> nextQueue) {
        for (Tomato tomato : queue) {
            for (int i = 0; i < 6; i++) {
                Tomato nearTomato = new Tomato(tomato.z + dz[i], tomato.y + dy[i], tomato.x + dx[i]);

                if (isValidTomato(nearTomato.z, nearTomato.y, nearTomato.x)) {
                    nextQueue.offer(nearTomato);
                    tomatoes[nearTomato.z][nearTomato.y][nearTomato.x] = 1;

                    --numberOfZero;
                }
            }
        }
    }

    private static boolean isValidTomato(int z, int y, int x) {
        return 0 <= z && z < H
                && 0 <= y && y < N
                && 0 <= x && x < M
                && tomatoes[z][y][x] == 0;
    }
}

class Tomato {
    int z;
    int y;
    int x;

    public Tomato(int z, int y, int x) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Tomato{" +
                "x=" + x +
                ", z=" + z +
                ", y=" + y +
                '}';
    }
}