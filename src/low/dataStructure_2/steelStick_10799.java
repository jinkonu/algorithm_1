package low.dataStructure_2;

/*
2023년 8월 19일 토요일
 */

import java.io.*;
import java.util.Stack;

public class steelStick_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int result = 0;

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(' && input[i + 1] == ')') {
                result += stack.size();
                ++i;
                continue;
            }

            if (input[i] == '(')
                stack.push('(');

            if (input[i] == ')') {
                stack.pop();
                result += 1;
            }
        }

        bw.write(result);
        bw.flush();
    }
}
