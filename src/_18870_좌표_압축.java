import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _18870_좌표_압축 {

    static int n;
    static int[] numbers;
    static Set<Integer> uniques;
    static List<Integer> sorted;
    static Map<Integer, Integer> found;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 0부터 n까지 모든 i에 대하여, numbers[i]보다 작은 수의 개수를 구해야 한다.
        // 사실상 정렬했을 때 인덱스가 무엇이냐와 동일하긴 하다...
        // 중복을 제거해야 한다.
        n = Integer.parseInt(reader.readLine());
        numbers = new int[n];
        uniques = new HashSet<>();
        found = new HashMap<>();

        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(inputs[i]);
            uniques.add(numbers[i]);
        }

        sorted = uniques.stream()
                .sorted()
                .collect(Collectors.toUnmodifiableList());

        for (int i = 0; i < n; i++) {
            result.append(find(numbers[i])).append(" ");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int find(int number) {
        int left = 0;
        int right = sorted.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) == number) {
                return mid;
            }
            else if (sorted.get(mid) < number) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
