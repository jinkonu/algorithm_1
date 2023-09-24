package low_2.bruteForce_4;

/*
2023년 9월 24일 일요일
(1)
    brute force 문제다.
    재귀적으로 어떻게 풀어낼지 도저히 방법을 못 찾아서 다른 답변을 참고했다.
    원래는 input[i][i]부터 앞으로 올라가면서 dp 방식으로 올라가려 했는데, 그렇게 하질 못했다.
(2)
    현재 방식을 보면, list[0]에 -10부터 넣고 맞으면 list[1]에 -10, 틀리면 list[0]에 -9를 넣는 방식으로
    모든 경우의 수를 따져가면서 하고 있다.
(3)
    참고로, 스택을 쓰면 좀 더 빠르지 않을까 하여 리스트 대신 써봤지만 오히려 너무 느려서 리스트를 유지하기로 했다.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Guess_1348 {
    static StringBuilder result;
    static int n;
    static int[][] input;
    static int[] output;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        output = new int[n];

        String line = br.readLine();
        int walk = 0;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                input[i][j] = parser(line.charAt(walk++));

        recursive(0);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int index) {
        if (index == n) {
            for (int i = 0; i < n; i++)
                result.append(list.get(i)).append(" ");
        }

        else {
            for (int i = -10; i <= 10; i++) {
                list.add(i);

                if (possible(index) && result.length() == 0)
                    recursive(index + 1);

                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean possible(int index) {
        int sum = 0;

        for (int i = index; i >= 0; i--) {
            sum += list.get(i);

            if (input[i][index] > 0  && sum <= 0) return false;
            if (input[i][index] < 0  && sum >= 0) return false;
            if (input[i][index] == 0 && sum != 0) return false;
        }

        return true;
    }

    public static int parser(char c) {
        return switch (c) {
            case '+' ->  1;
            case '-' -> -1;
            default  ->  0;
        };
    }
}
