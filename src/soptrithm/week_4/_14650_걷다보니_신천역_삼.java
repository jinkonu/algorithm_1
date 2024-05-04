package soptrithm.week_4;

/*
 * dfs로 풀어보려고 했는데
 * 수학적으로 정해진 게 있는 것 같아서
 * 2 * 3^(n-2)로 풀었다.
 * */

import java.io.*;

public class _14650_걷다보니_신천역_삼 {

    static int n;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        n = Integer.parseInt(reader.readLine());

        if (n == 1)
            count = 0;
        else
            count = (int) (2 * Math.pow(3, n - 2));

        result.append(count);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}