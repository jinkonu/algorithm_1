package soptrithm.week_4;

/*
 * i번째 칸에 대해,
 * 좌측 혹은 우측에 사자를 넣을 경우 -> 전에 안 넣었었으면 둘 다 가능 + 넣었었으면 하나만 가능
 * 안 넣을 경우 -> 전에 안 넣은 경우 + 넣은 경우
 * 비슷하게 접근했으나, dfs처럼 n까지 다가가서 +1 할 필요 없이, 그때 그때 zero, leftOrRight를 쌓아가면 될 일이었다.
 * */

import java.io.*;

public class _1309_동물원 {

    static int n;
    static int cases = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        n = Integer.parseInt(reader.readLine());
        int div = 9901;

        int zero = 1;
        int leftOrRight = 2;

        for (int i = 1; i < n; i++) {
            int tmp = leftOrRight;
            leftOrRight = (zero * 2 + leftOrRight) % div;
            zero = (tmp + zero) % div;
        }

        result.append((zero + leftOrRight) % div);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
