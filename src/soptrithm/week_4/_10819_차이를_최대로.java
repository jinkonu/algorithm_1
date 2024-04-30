package soptrithm.week_4;

/*
 * 하나씩 다 해보는 수밖에 없는 것 같다...
 * 백트래킹의 개념이 없는 것 같아서 헤맸지만,
 * max = Math.max(max, total);
 * 위 코드가 백트래킹이었다...
 * */

import java.io.*;

public class _10819_차이를_최대로 {

    static int n;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;
    static int max = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        n = Integer.parseInt(reader.readLine());
        numbers = new int[n];
        arr = new int[n];
        visited = new boolean[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        bruteForce(0);
        result.append(max);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bruteForce(int size) {
        if (size == n) {
            int total = 0;

            for (int i = 1; i < n; i++)
                total += Math.abs(arr[i] - arr[i - 1]);

            max = Math.max(max, total);
        }

        else {
            for (int i = 0; i < n; i++)
                if (!visited[i]) {
                    visited[i] = true;
                    arr[size] = numbers[i];
                    bruteForce(size + 1);
                    visited[i] = false;
                }
        }
    }
}
