package soptrithm.week_6;

/*
 * 이 문제도 누적합이라고 한다.
 * 누적합은 순서가 유지될 때 많이 쓰는 것 같은데 지금은 순서가 뒤죽박죽인데 어떻게 해야할지 모르겠다...
 * [1, 2, 3, 4]를 예로 들면 누적합은 [1, 3, 6, 10]이다.
 * 그런데 우리가 필요한 건 정확하게는 [0, 1, 3, 6]이고,
 * 임의의 1 이상 인덱스 k에 대해 arr[k] * prefixSum[k]를 전체 합에 더해주면 된다.
 * */

import java.io.*;

public class _13900_순서쌍의_곱의_합 {

    static int n;
    static int[] arr;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        prefixSum = new int[n];

        String[] input = reader.readLine().split(" ");

        arr[0] = Integer.parseInt(input[0]);
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
            prefixSum[i] = arr[i - 1] + prefixSum[i - 1];
        }

        result.append(sum());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static long sum() {
        long total = 0;

        for (int i = 0; i < n; i++) {
            total += (long) prefixSum[i] * arr[i];
        }

        return total;
    }
}
