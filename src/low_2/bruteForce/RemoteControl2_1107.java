package low_2.bruteForce;

/*
2023년 9월 7일 목요일
(1)
    brute force 문제다.
    코너 케이스 찾는 것이 빡셌다. (입력값이 0, 0인 경우 혹은 0, 10, 0~9인 경우 등)
    그리고 처음 접근법을 잘못 생각해서 좀 헤맸다.
(2)
    첫번째 케이스는 100에서 +, -로 접근하는 것이 빠를 때
    두번째 케이스는 숫자를 바꾸되, 필요한 것 중에서 고장난 것이 없을 때
    세번째 케이스는 숫자를 바꾸고, 필요한 것 중에서 고장난 것이 있을 때
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

public class RemoteControl2_1107 {
    static int minButtonNum;
    static int N;
    static List<Integer> usable = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        List<Integer> unusable = new ArrayList<>();
        int diff = 0;
        String strN = String.valueOf(N);
        boolean allContainFlag = true;

        if (M != 0) {
            String[] line = br.readLine().split(" ");

            for (String str : line)
                unusable.add(Integer.parseInt(str));

            usable.removeAll(unusable);
        }

        diff = abs(N - 100);                    // 100에서 +나 -로 잡는 경우

        for (int i = 0; i < strN.length(); i++)
            if (!usable.contains(Integer.parseInt(strN.substring(i, i + 1)))) {
                allContainFlag = false;
            }

        if (allContainFlag)                     // N을 형성하는 모든 키가 정상적으로 작동하는 경우
            diff = min(diff, strN.length());

        else if (diff > 0 && !usable.isEmpty()) {                    // N을 형성하기 위해 근삿값에서 시작해서 +나 -로 잡아야 하는 경우
            minButtonNum = Integer.MAX_VALUE;

            recursive(0, strN.length() + 1, 0);
            recursive(0, strN.length(), 0);
            if (strN.length() > 1) recursive(0, strN.length() - 1, 0);

            diff = min(diff, abs(minButtonNum - N) + String.valueOf(minButtonNum).length());
        }

        result.append(diff);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    public static void recursive(int i, int len, int currNum) {
        if (i == len) {
            if (abs(N - currNum) <= abs(N - minButtonNum)) {
                minButtonNum = currNum;
            }
        }

        else {
            for (Integer j : usable) {
                recursive(i + 1, len, currNum * 10 + j);
            }
        }
    }
}
