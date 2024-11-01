import java.io.*;
import java.util.*;

public class _9375_패션왕_신해빈 {

    static int t;
    static int n;
    static Map<String, Integer> closet;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // nCr로 모든 조합을 구해야 한다고 생각했다.
        // 그러나 그냥 {전체 조합 *= (모든 조합에 대해 해당 조합 개수 + 1) - 1}하면 되는 것이었다...

        t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(reader.readLine());
            closet = new HashMap<>();

            for (int j = 0; j < n; j++) {
                String[] inputs = reader.readLine().split(" ");
                String type = inputs[1];

                closet.put(type, closet.getOrDefault(type, 0) + 1);
            }

            result.append(calculateCombinations()).append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        reader.close();
        writer.close();
    }

    private static int calculateCombinations() {
        int total = 1;

        for (int count : closet.values()) {
            total *= (count + 1); // 각 의상 종류별로 입는 경우 + 입지 않는 경우
        }

        return total - 1; // 아무것도 입지 않는 경우를 제외
    }
}
