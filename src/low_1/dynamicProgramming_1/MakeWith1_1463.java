package low_1.dynamicProgramming_1;

/*
2023년 8월 26일 토요일
(1)
    DP로 들어왔다.
    3으로 나누기, 2로 나누기, 1 빼기 세 가지 케이스를 가지고 최적의 1 만드는 방법을 찾아야 한다.
(2)
    1로 뺀다고 최악의 수가 아니다.
    DP는 모든 가능성을 열어둬야 하기 때문에 재귀호출로 했다.
    다만, 호출된 메서드끼리 공유하는 minOp을 두고, minOp을 넘어버리면 더 이상 가치없는 연산이므로 반환했다.
 */

import java.io.*;

public class MakeWith1_1463 {
    static int minOp = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(br.readLine());
        recursive(N, 0);

        result.append(minOp);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int n, int op) {
        if (n == 1 && op < minOp) {
            minOp = op;
            return;
        }

        if (op >= minOp) return;

        if (n % 3 == 0) recursive(n/3, op + 1);
        if (n % 2 == 0) recursive(n/2, op + 1);
        recursive(n - 1, op + 1);
    }
}
