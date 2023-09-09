package low_2.bruteForce_1;

/*
2023년 9월 4일 월요일
(1)
    brute force 문제이다.
    그래서 모든 케이스를 찾아야 한다.
(2)
    생각나는 방법이 없어서 for문을 중첩으로 돌려서 모든 i, j 쌍을 만들었다.
    전체 합 total에서 i, j 인덱스의 값만 빼서 100이 되면 나머지를 출력하도록 했다.
 */

import java.io.*;
import java.util.Arrays;

public class SevenDwarfs_2309 {
    static int[] dwarfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        dwarfs = new int[9];
        int total = 0;

        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            total += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        outer :
        for (int i = 0; i < 9; i++)
            for (int j = i + 1; j < 9; j++) {
                if (total - (dwarfs[i] + dwarfs[j]) == 100) {
                    for (int k = 0; k < 9; k++)
                        if (k != i && k != j)
                            result.append(dwarfs[k]).append("\n");
                    break outer;
                }
            }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
