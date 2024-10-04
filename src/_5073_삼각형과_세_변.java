import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _5073_삼각형과_세_변 {

    static int[] lines = new int[3];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // int[3] lines: 하나라도 다르면 Scalence, 세 개 모두 같으면 Equilateral, else Isosceles
        // 이후 invalid 확인
        String[] inputs = reader.readLine().split(" ");

        while (true) {
            if (inputs[0].equals("0")) {
                break;
            }

            for (int i = 0; i < 3; i++) {
                int number = Integer.parseInt(inputs[i]);
                lines[i] = number;
                set.add(number);
            }

            Arrays.sort(lines);
            if (lines[2] >= lines[0] + lines[1]) {
                result.append("Invalid").append("\n");
            }

            else {
                switch (set.size()) {
                    case 1 -> result.append("Equilateral").append("\n");
                    case 2 -> result.append("Isosceles").append("\n");
                    case 3 -> result.append("Scalene").append("\n");
                }
            }

            inputs = reader.readLine().split(" ");
            set.clear();
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
