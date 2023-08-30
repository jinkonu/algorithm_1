package low.dynamicProgramming_2;

/*
2023년 8월 30일 수요일
(1)
    단순한 dp 문제였지만, dp로 풀어내는 방식을 찾는 데 시간이 조금 걸렸다.
    각주를 보면 알겠지만, 결국 생각해낸 건 맨 위부터 내려가면서 전 칸에 무엇을 선택했느냐에 따라 i - 1 인덱스를 참고해서 i를 꾸려나가는 방식이었다.
(2)
    그러나 생각보다 퍼포먼스가 너무 안 나와서 찾아보니,
    첫 칸에는 사자를 안 넣는 zero가 1, 사자를 넣는 leftOrRight가 2의 경우의 수로 출발해서 간단한 for loop만 돌려도 되었다.
    현재 칸의 leftOrRight는 zero * 2 + leftOrRight,
    현재 칸의 zero는 zero + leftOrRight(tmp)다.
 */

import java.io.*;

public class Zoo_1309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int div = 9901;
        int N = Integer.parseInt(br.readLine());
//        int[][] cases = new int[N + 1][3];      // 0은 제외, 1은 왼쪽, 2는 오른쪽에 삽입
//
//        cases[1][0] = 1;
//        cases[1][1] = 1;
//        cases[1][2] = 1;
//
//        for (int i = 2; i <= N; i++) {
//            cases[i][0] = (cases[i - 1][0] + cases[i - 1][1] + cases[i - 1][2]) % div;  // 위에서 안넣었으면 다음 칸에서도 안넣어도 됨
//            cases[i][1] = (cases[i - 1][0] + cases[i - 1][2]) % div;                    // 위에서 왼쪽에 넣은 경우
//            cases[i][2] = (cases[i - 1][0] + cases[i - 1][1]) % div;                    // 위에서 오른쪽에 넣은 경우
//        }
//
//        result.append((cases[N][0] + cases[N][1] + cases[N][2]) % div);
        // LOGIC FINISH
        int leftOrRight = 2;  // 왼쪽이나 오른쪽에 사자를 집어넣음
        int zero = 1;       // 사자를 집어넣지 않음
        int tmp;            // 스왑용 변수

        for (int i = 1; i < N; i++) {
            tmp         = leftOrRight;
            leftOrRight   = (zero * 2 + leftOrRight) % div;
            zero        = (zero + tmp) % div;
        }

        result.append((leftOrRight + zero) % div);
        // LOGIC FINISH
        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
