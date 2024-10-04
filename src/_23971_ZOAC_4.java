import java.io.*;

public class _23971_ZOAC_4 {

    static int H;
    static int W;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // (0, 0) ~ (N, M)까지 한번씩 최대 개수를 찾아보자.
        String[] inputs = reader.readLine().split(" ");
        H = Integer.parseInt(inputs[0]);
        W = Integer.parseInt(inputs[1]);
        N = Integer.parseInt(inputs[2]);
        M = Integer.parseInt(inputs[3]);

        int vertical = H / (N + 1);
        int horizontal = W / (M + 1);

        if (H % (N + 1) > 0)
            ++vertical;
        if (W % (M + 1) > 0)
            ++horizontal;

        if (vertical == 0 || horizontal == 0)
            result.append(1);
        else
            result.append(vertical * horizontal);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
