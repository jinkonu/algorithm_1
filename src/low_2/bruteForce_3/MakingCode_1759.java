package low_2.bruteForce_3;

/*
2023년 9월 20일 수요일
(1)
    brute force 문제다.
    남아 있는 문자 중에서 조건을 만족하지 못하면 더이상 서치하지 않도록 하려고 했으나,
    너무 복잡해서 포기했다...
 */

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class MakingCode_1759 {
    static StringBuilder result;
    static int L;
    static int C;
    static List<Character> chars;
    static char[] code;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        L = parseInt(line1[0]);
        C = parseInt(line1[1]);
        chars = new ArrayList<>();
        code = new char[L];

        for (int i = 0; i < C; i++)
            chars.add(line2[i].charAt(0));

        chars.sort(Comparator.naturalOrder());

        encode(0);
        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void encode(int index) {
        if (index == L) {
            int vowel = 0;
            int conso = 0;

            for (int i = 0; i < L; i++){
                if ("aeiou".indexOf(code[i]) >= 0) ++vowel;
                else ++conso;
            }

            if (vowel >= 1 && conso >= 2) {
                for (int i = 0; i < L; i++)
                    result.append(code[i]);

                result.append("\n");
            }
        }

        else if (index == 0) {
            for (int i = 0; i < C; i++) {
                code[index] = chars.get(i);
                encode(index + 1);
            }
        }

        else if (index < L)
            for (int i = chars.indexOf(code[index - 1]) + 1; i < C; i++) {
                code[index] = chars.get(i);
                encode(index + 1);
            }
    }
}
