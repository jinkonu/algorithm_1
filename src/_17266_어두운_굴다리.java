import java.io.*;
import java.util.Arrays;

public class _17266_어두운_굴다리 {

    private static int n;
    private static int m;
    private static int[] lamps;
    private static int[] distances;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 가로등을 기준으로 나뉘는 m + 1개의 구간 중 최대값을 기준으로 최소 길이를 찾을 수 있을 것 같다.
        // 다만, [0], [m]의 구간을 제외하고는 (distance / 2) + 1로 길이를 구해야 한다.
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        lamps = new int[m];
        distances = new int[m + 1];

        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            lamps[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(lamps);

        distances[0] = lamps[0];
        distances[m] = n - lamps[m - 1];
        for (int i = 1; i < m; i++) {
            int distance = lamps[i] - lamps[i - 1];

            if (distance % 2 == 0) {
                distances[i] = distance / 2;
            }

            if (distance % 2 == 1) {
                distances[i] = distance / 2 + 1;
            }
        }

        Arrays.sort(distances);
        result.append(distances[m]);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
