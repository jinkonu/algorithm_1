package low_1.dataStructure_1;

/* 2023년 8월 17일 목요일
(1)
    loop에 이름을 달아줘서 inner loop 안에서 outer loop에 대한 제어를 걸어줄 수 있었다.
 */

import java.util.Scanner;

public class ValidParenthesisString_9012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int comNum = Integer.parseInt(sc.nextLine());
        StringBuilder result = new StringBuilder();

        outer :
        for (int i = 0; i < comNum; i++) {
            int open = 0;
            int close = 0;

            char[] line = sc.nextLine().toCharArray();
            for (int j = 0; j < line.length; j++) {
                if (line[j] == '(') ++open;
                else if (line[j] == ')') ++close;

                if (open < close) {
                    result.append("NO").append("\n");
                    continue outer;
                }
            }

            if (open == close) result.append("YES").append("\n");
            else result.append("NO").append("\n");
        }

        System.out.println(result);
    }
}
