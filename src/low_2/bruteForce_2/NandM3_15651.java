package low_2.bruteForce_2;

/*
2023년 9월 11일 월요일
(1)
    brute force 문제다.
    처음엔 recursive 메서드의 파라미터로 String을 사용했는데 너무 느렸다.
    아무래도 String은 매번 새롭게 생성하기 때문에 그런 것 같다.
(2)
    그래서 int[] 배열을 공유해서 사용하는 방식으로 바꿨더니 훨씬 빨라졌다.
    어차피 recursive2()는 DFS 방식으로,
    left == M까지 가서 수열을 다 찍은 다음에 다음 수열이 배열을 사용하기 때문에 문제가 없는 것으로 보인다.
 */

import java.io.*;

public class NandM3_15651 {
    static int N;
    static int M;
    static StringBuilder result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        arr = new int[M];

        recursive2(0);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(int left, String seq) {
        if (left == 0)
            result.append(seq.substring(1)).append("\n");

        else {
            for (int i = 1; i <= N; i++)
                recursive(left - 1, seq + " " + i);
        }
    }

    private static void recursive2(int left) {
        if (left == M) {
            for (int i = 0 ; i < M; i++)
                result.append(arr[i]).append(" ");
            result.append("\n");
        }

        else
            for (int i = 1; i <= N; i++) {
                arr[left] = i;
                recursive2(left + 1);
            }
    }
}
