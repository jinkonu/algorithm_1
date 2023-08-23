package low.math_1;

/*
2023년 8월 23일 수요일
(1)
    이 문제는 팩토리얼에 관한 문제기는 하지만, 뒤의 0의 개수를 구한다는 점에서 다르게 접근했다.
    뒤에 0이 붙으려면 10, 즉 2와 5가 한 짝씩 필요하다.
    2는 충분하므로, N!이 가지고 있는 5의 지수를 출력하면 된다.
    그렇다고 N!을 직접 계산하면 수가 너무 커지므로, i = 1부터 i = N까지 반복하면서 5의 지수를 추가해갔다.
 */

import java.io.*;

public class FactorialZeroNum_1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int input = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 1; i <= input; i++) {
            if (i % 5 == 0) {
                count += five(i);
            }
        }

        result.append(count);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static int five(int i) {
        if (i % 5 == 0) return five(i / 5) + 1;
        else return 0;
    }
}
