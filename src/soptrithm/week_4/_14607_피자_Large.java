package soptrithm.week_4;

/*
 * 높이가 n(n > 1)인 피자탑을 분리할 수 있는 경우의 수는 n/2 가지다.
 * 그래서 1부터 n/2까지 dp를 진행해야 할 것 같다.
 *
 * dp로 진행했지만, n의 최댓값이 10억이므로 메모리 초과가 발생한다.
 * 해답을 보니 간단하게 n(n-1)/2라는 식으로 귀결된다...
 * 허무하군.
 * */

import java.io.*;

public class _14607_피자_Large {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        n = Integer.parseInt(reader.readLine());

        result.append(op(n));
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static long op(long x) {
        return x * (x - 1) / 2;
    }
}
