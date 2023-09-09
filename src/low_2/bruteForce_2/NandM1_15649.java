package low_2.bruteForce_2;

/*
2023년 9월 9일 토요일
(1)
    brute force 문제다.
    nPk에 따른 수열을 써내야 한다.
    boolean[] check로 각 수열마다 아직 가지고 있지 않은 수를 false로 체크하여,
    false인 수를 더하고 true로 바꾼 복사본을 재귀적으로 호출했다.
 */

import java.io.*;

public class NandM1_15649 {
    static StringBuilder result;
    static int N;
    static int[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        list = new int[N];
        boolean[] check = new boolean[N];

        if (N >= M) {
            for (int i = 1; i <= N; i++)
                list[i - 1] = i;

            recursive(M, check, "");
            result.deleteCharAt(result.length() - 1);
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int m, boolean[] list, String num) {
        if (m == 0)
            result.append(num).append("\n");

        else {
            for (int i = 0; i < N; i++) {
                if (!list[i]) {
                    boolean[] tmpList = new boolean[N];
                    System.arraycopy(list, 0, tmpList, 0, N);
                    tmpList[i] = true;

                    recursive(m - 1, tmpList, num + (i+1) + " ");
                }
            }
        }
    }
}
