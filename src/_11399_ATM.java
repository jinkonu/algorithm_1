import java.io.*;
import java.util.Arrays;

public class _11399_ATM {

    static int n;
    static int[] numbers;
    static int total = 0;
    static int preSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 그리디 알고리즘을 사용한다.
        // 값이 작은 것부터 줄세운다.
        // 누적합을 통해 총합을 구한다.
        // 1 2 3 4 4
        // 1, 3, 6, 9, 13
        // 1 + 3 + 6 + 9 + 13 = 33
        n = Integer.parseInt(reader.readLine());
        numbers = new int[n];

        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            preSum += numbers[i];
            total += preSum;
        }

        result.append(total);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
