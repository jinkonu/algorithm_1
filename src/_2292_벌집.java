import java.io.*;

public class _2292_벌집 {

    static int N;
    static int count;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 1개 : 1 -> 1
        // 2개 : 2 ~ 7 -> 6
        // 3개 : 8 ~ 19 -> 12
        // 4개 : 20 ~ 37 -> 18
        // count를 두고 하면 될듯?
        N = Integer.parseInt(reader.readLine());
        count = 1;

        if (N == 1) {
            result.append(count);
        }
        else {
            sum = 1;

            while (N > sum) {
                sum += 6 * count;
                ++count;
            }

            result.append(count);
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
