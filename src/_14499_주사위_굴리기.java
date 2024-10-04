import java.io.*;

public class _14499_주사위_굴리기 {

    static int N;
    static int M;
    static int x;
    static int y;
    static int K;
    static int[][] map;
    static int[] orders;
    static int[][] dice;

    static int[] dy = {0, 0, 0, -1, 1};
    static int[] dx = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 주사위 동쪽 : [1][x] 라인 오른쪽으로 한 칸씩
        // 주사위 서쪽 : [1][x] 라인 왼쪽으로 한 칸씩
        // 주사위 남쪽 : [x][1] 라인 아래쪽으로 한 칸씩
        // 주사위 북쪽 : [x][1] 라인 위쪽으로 한 칸씩
        String[] inputs = reader.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        x = Integer.parseInt(inputs[3]);
        y = Integer.parseInt(inputs[2]);
        K = Integer.parseInt(inputs[4]);
        map = new int[N][M];
        orders = new int[K];
        dice = new int[4][3];

        for (int i = 0; i < N; i++) {
            inputs = reader.readLine().split(" ");

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        inputs = reader.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(inputs[i]);
        }

        move(result);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void move(StringBuilder result) {
        Point point = new Point(y, x);

        for (int order : orders) {
            Point next = new Point(point.y + dy[order], point.x + dx[order]);

            if (isReachable(next.y, next.x)) {
                point = next;
                roll(order);
                exchange(point.y, point.x);
                result.append(dice[1][1]).append("\n");
            }
        }
    }

    private static void exchange(int y, int x) {
        if (map[y][x] == 0) {
            map[y][x] = dice[3][1];
        }
        else {
            dice[3][1] = map[y][x];
            map[y][x] = 0;
        }
    }

    private static void roll(int order) {
        int temp;

        switch (order) {
            case 1: {
                temp = dice[1][2];
                dice[1][2] = dice[1][1];
                dice[1][1] = dice[1][0];
                dice[1][0] = dice[3][1];
                dice[3][1] = temp;
                break;
            }
            case 2: {
                temp = dice[1][0];
                dice[1][0] = dice[1][1];
                dice[1][1] = dice[1][2];
                dice[1][2] = dice[3][1];
                dice[3][1] = temp;
                break;
            }
            case 3: {
                temp = dice[0][1];
                dice[0][1] = dice[1][1];
                dice[1][1] = dice[2][1];
                dice[2][1] = dice[3][1];
                dice[3][1] = temp;
                break;
            }
            case 4: {
                temp = dice[3][1];
                dice[3][1] = dice[2][1];
                dice[2][1] = dice[1][1];
                dice[1][1] = dice[0][1];
                dice[0][1] = temp;
                break;
            }
        }
    }

    private static boolean isReachable(int y, int x) {
        return 0 <= y && y < N
                && 0 <= x && x < M;
    }
}

class Point {

    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

//private static void print() {
//    for (int i = 0; i < 4; i++) {
//        for (int j = 0; j < 3; j++) {
//            System.out.print(dice[i][j] + " ");
//        }
//        System.out.println();
//    }
//}