package soptrithm.week_2;

import java.io.*;
import java.util.Arrays;

public class _17390_이건_꼭_풀어야_해 {

    static int[] numbers;
    static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 정렬과 누적합이 함께 있는 문제다.
        * 정렬 이후에 누적합을 적용하면 될 것 같다.
        * */
        String[] metaLine = reader.readLine().split(" ");
        int N = Integer.parseInt(metaLine[0]);
        int Q = Integer.parseInt(metaLine[1]);

        numbers = new int[N + 1];
        prefixSum = new int[N + 1];

        String[] inputLine = reader.readLine().split(" ");
        for (int i = 0; i < N; i++)
            numbers[i + 1] = Integer.parseInt(inputLine[i]);
        Arrays.sort(numbers);

        for (int i = 1; i <= N; i++)
            prefixSum[i] = prefixSum[i - 1] + numbers[i];

        for (int i = 0; i < Q; i++) {
            String[] line = reader.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);

            result.append(prefixSum[y] - prefixSum[x - 1]).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
