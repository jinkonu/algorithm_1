import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _1926_그림 {

    static int n;
    static int m;
    static int[][] matrix;
    static boolean[][] visited;
    static int number;
    static int max;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // BFS를 쓰되, 현재 그림의 크기를 유지해야 한다.
        String[] inputs = reader.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);
        matrix = new int[n][m];
        visited = new boolean[n][m];
        number = 0;
        max = 0;

        for (int i = 0; i < n; i++) {
            inputs = reader.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        result.append(number).append("\n").append(max);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs(int y, int x) {
        int size = 0;
        Queue<Picture> queue = new LinkedList<>();
        queue.add(new Picture(y, x, 1));

        while (!queue.isEmpty()) {
            Picture picture = queue.poll();
            visited[picture.y][picture.x] = true;
            size = Math.max(size, picture.size);

            for (int i = 0; i < 4; i++) {
                Picture next = new Picture(picture.y + dy[i], picture.x + dx[i], picture.size + 1);

                if (isValid(next)) {
                    queue.add(next);
                }
            }
        }

        ++number;
        max = Math.max(max, size);
    }

    private static boolean isValid(Picture picture) {
        return 0 <= picture.y && picture.y < n
                && 0 <= picture.x && picture.x < m
                && matrix[picture.y][picture.x] == 1
                && !visited[picture.y][picture.x];
    }
}

class Picture{

    int y;
    int x;
    int size;

    public Picture(int y, int x, int size) {
        this.y = y;
        this.x = x;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "y=" + y +
                ", x=" + x +
                '}';
    }
}