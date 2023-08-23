package low.math_1;

/*
2023년 8월 23일 수요일
(1)

 */

import java.io.*;

public class Remainder_10430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int C = Integer.parseInt(input[2]);

        result.append((A + B) % C).append("\n");
        result.append(((A % C) + (B % C)) % C).append("\n");
        result.append((A * B) % C).append("\n");
        result.append(((A % C) * (B % C)) % C);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
