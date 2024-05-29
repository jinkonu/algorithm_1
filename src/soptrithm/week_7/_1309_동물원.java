package soptrithm.week_7;

import java.io.*;

public class _1309_동물원 {

    static int n;
    static int mod = 9901;
    static int[] numbers = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
         * dp 문제로 기억한다.
         * 매번 선택은 넣지 않거나, 왼쪽, 오른쪽 세 가지 가능하다.
         * 이전 선택에서 넣었다면 두 가지 가능하다.
         * 재귀 함수로 풀었더니 시간 초과가 발생하는데, 반복문으로 대체해야 할듯 싶다.
         * */

        n = Integer.parseInt(reader.readLine());
        result.append(dp());
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int dp() {
        for (int i = 0; i < 3; i++)
            numbers[i] = 1;

        for (int i = 1; i < n; i++) {
            int number0 = (numbers[0] + numbers[1] + numbers[2]) % mod;
            int number1 = (numbers[0] + numbers[2]) % mod;
            int number2 = (numbers[0] + numbers[1]) % mod;

            numbers[0] = number0;
            numbers[1] = number1;
            numbers[2] = number2;
        }

        return (numbers[0] + numbers[1] + numbers[2]) % mod;
    }
}
