package soptrithm.week_3;

import java.io.*;

public class _1057_토너먼트 {

    static int n;
    static int x;
    static int y;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * N X Y로 입력이 주어진다.
        * X에 대하여 짝수이면 -1, 홀수이면 +1을 해서 Y와 같아질 경우, 탐색을 중단한다.
        * 같아지지 않을 경우,
        * N, X, Y에 대하여 짝수면 1/2, 홀수면 1/2 + 1을 해준다.
        * 반복한다.
        * */
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        x = Integer.parseInt(input[1]);
        y = Integer.parseInt(input[2]);

        result.append(tournament());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int tournament() {
        int round = 1;

        while (n >= 2) {
            if (isMetEachOther())
                return round;

            n = fight(n);
            x = fight(x);
            y = fight(y);

            ++round;
        }

        return -1;
    }

    private static int fight(int k) {
        if (k % 2 == 0)
            return k / 2;
        else
            return k / 2 + 1;
    }

    private static boolean isMetEachOther() {
        if (x % 2 == 0)
            return x - 1 == y;
        else
            return x + 1 == y;
    }
}
