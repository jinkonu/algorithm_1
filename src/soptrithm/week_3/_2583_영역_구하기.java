package soptrithm.week_3;

/*
 * boolean[][] isBlocked = new boolean[M][N]
 * 2번째 줄부터 x1 y1 x2 y2가 주어진다.
 * isBlocked[y1][x1] ~ isBlocked[y2][x2]까지 true
 * 나머지는 isBlocked를 처음부터 순회하면서, if (!isBlocked[i][j]) then dfs(i, j)
 * dfs()를 호출하는 횟수, 각 넓이 모아두자.
 * */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _2583_영역_구하기 {

    static int m;
    static int n;
    static int k;

    static boolean[][] isBlocked;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        String[] metaLine = reader.readLine().split(" ");
        m = Integer.parseInt(metaLine[0]);
        n = Integer.parseInt(metaLine[1]);
        k = Integer.parseInt(metaLine[2]);

        isBlocked = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            String[] line = reader.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]);
            int y1 = Integer.parseInt(line[1]);
            int x2 = Integer.parseInt(line[2]);
            int y2 = Integer.parseInt(line[3]);

            block(x1, y1, x2, y2);
        }

        int count = 0;
        List<Integer> areas = new ArrayList<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (!isBlocked[i][j]) {
                    areas.add(dfs(i, j));
                    ++count;
                }
        areas.sort(Integer::compareTo);

        result.append(count).append("\n");
        for (Integer area : areas)
            result.append(area).append(" ");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int dfs(int y, int x) {
        isBlocked[y][x] = true;
        int total = 1;

        for (int i = 0; i < 4; i++)
            if (isValid(y + dy[i], x + dx[i]))
                total += dfs(y + dy[i], x + dx[i]);

        return total;
    }

    private static boolean isValid(int y, int x) {
        return     y >= 0 && y < m
                && x >= 0 && x < n
                && !isBlocked[y][x];
    }

    private static void print() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isBlocked[i][j])
                    System.out.printf("X ");
                else
                    System.out.printf("O ");
            }
            System.out.println();
        }
    }

    private static void block(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++)
            for (int j = x1; j < x2; j++)
                isBlocked[i][j] = true;
    }
}
