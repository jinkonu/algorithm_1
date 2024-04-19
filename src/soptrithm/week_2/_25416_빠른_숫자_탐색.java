package soptrithm.week_2;

/*
 * 미로 탐색 문제와 거의 동일하다.
 * BFS로 상하좌우 순으로 나아간다.
 * 만약 더이상 갈 곳이 없으면 -1을 출력한다.
 * 만약 도착했다면 여태까지 건너간 횟수를 출력한다.
 * */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class _25416_빠른_숫자_탐색 {

    static int[][] board = new int[5][5];
    static int[] x = new int[]{-1, 1, 0, 0};
    static int[] y = new int[]{0, 0, -1, 1};
    static Student reachPoint;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        for (int i = 0; i < 5; i++) {
            String[] input = reader.readLine().split(" ");

            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(input[j]);
                if (board[i][j] == 1)
                    reachPoint = new Student(0, i, j);
            }
        }

        String[] input = reader.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        Student start = new Student(0, x, y);

        bfs(start);
        result.append(min);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs(Student start) {
        Queue<Student> queue = new LinkedList<>();
        queue.add(start);
        board[start.x][start.y] = -1;

        while (!queue.isEmpty()) {
            Student curr = queue.poll();

            if (isReached(curr)) {
                min = Math.min(min, curr.distance);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int newX = curr.x + x[i];
                int newY = curr.y + y[i];

                if (isValid(newX, newY)) {
                    queue.add(new Student(curr.distance + 1, newX, newY));
                    board[newX][newY] = -1;
                }
            }
        }

        if (isNotAvailable())
            min = -1;
    }

    private static boolean isNotAvailable() {
        return min == Integer.MAX_VALUE;
    }

    private static boolean isReached(Student currPoint) {
        return reachPoint.x == currPoint.x && reachPoint.y == currPoint.y;
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < 5 && 0 <= y && y < 5
                && board[x][y] != -1;
    }
}

class Student {
    int x;
    int y;
    int distance;

    public Student(int distance, int x, int y) {
        this.distance = distance;
        this.x = x;
        this.y = y;
    }
}
