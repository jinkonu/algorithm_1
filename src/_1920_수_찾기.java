import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1920_수_찾기 {

    static int n;
    static int m;
    static long[] numbers;
    static long[] finds;
    static Map<Long, Integer> founds = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 2^31이므로 long 타입을 써야 한다.
        // 이분탐색은 정렬이 필수다.
        // 이미 확인한 수는 빠르게 처리하기 위해 Map 구조를 활용한다.
        n = Integer.parseInt(reader.readLine());
        numbers = new long[n];

        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(numbers);

        m = Integer.parseInt(reader.readLine());
        finds = new long[m];

        inputs = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            finds[i] = Integer.parseInt(inputs[i]);
        }

        for (int i = 0; i < m ; i++) {
            long toFind = finds[i];
            result.append(founds.getOrDefault(toFind, find(toFind))).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int find(long number) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == number) {
                founds.put(number, 1);
                return 1;
            }
            else if (numbers[mid] < number) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        founds.put(number, 0);
        return 0;
    }
}
