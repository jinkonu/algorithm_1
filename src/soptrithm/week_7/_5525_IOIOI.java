package soptrithm.week_7;

import java.io.*;

public class _5525_IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 이 문제는 그리디 알고리즘으로 생각해도 될 것 같다.
        * I로 시작할 경우 패턴을 찾을 때까지 나아간다.
        * */
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        char[] input = reader.readLine().toCharArray();

        int total = 0;
        for (int i = 0; i < m; i++) {
            if (input[i] == 'I') {
                int j = i + 1;

                // 번갈아 나오는 패턴이 반복될 때까지 j를 전진시킨다.
                while (j < m) {
                    if ((j - i) % 2 == 1 && input[j] == 'O')
                        ++j;
                    else if ((j - i) % 2 == 0 && input[j] == 'I')
                        ++j;
                    else
                        break;
                }

                for (int k = j - i; k >= 2 * n + 1; k -= 2) {
                    ++total;
                }

                i = j - 1;
            }
        }

        result.append(total);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
