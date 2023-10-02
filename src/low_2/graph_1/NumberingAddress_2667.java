package low_2.graph_1;

/*
2023년 10월 2일 월요일
(1)
    brute force에 속한다고 할 수 있는 문제다.
    아직 방문하지 않은 한 정점에서 시작해서 주변에 집이 있을 경우 그 집에서 다시 재귀 메서드를 호출하는 식이다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.*;

public class NumberingAddress_2667 {
    static int N;
    static boolean[][] house;
    static boolean[][] visited;
    static List<Integer> houseSets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = parseInt(br.readLine());
        house = new boolean[N][N];
        visited = new boolean[N][N];

        // 입력값 받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < N; j++)
                if ((line.charAt(j) - '0') == 1)
                    house[i][j] = true;
        }

        // 그래프 형성
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (house[i][j] && !visited[i][j]) {
                    houseSets.add(findGraph(i, j, 1));
                }

        // 오름차순 정렬 후 출력
        result.append(houseSets.size()).append("\n");

        houseSets.sort(Comparator.naturalOrder());
        for (Integer size : houseSets)
            result.append(size).append("\n");

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int findGraph(int i, int j, int sum) {
        visited[i][j] = true;

        if (i < N - 1 && house[i + 1][j] && !visited[i + 1][j]) sum = findGraph(i + 1, j, sum + 1);
        if (j < N - 1 && house[i][j + 1] && !visited[i][j + 1]) sum = findGraph(i, j + 1, sum + 1);
        if (i > 0 && house[i - 1][j] && !visited[i - 1][j]) sum = findGraph(i - 1, j, sum + 1);
        if (j > 0 && house[i][j - 1] && !visited[i][j - 1]) sum = findGraph(i, j - 1, sum + 1);

        return sum;
    }
}
