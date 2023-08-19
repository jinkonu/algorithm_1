package low.dataStructure_2;

/*
2023년 8월 19일 토요일
(1)
    stack의 LIFO 성질을 활용해서 뒤집을 문자열은 뒤집고,
    뒤집지 않을 문자열은 바로 append하도록 했다.
 */

import java.io.*;
import java.util.Stack;

public class flipWord_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        Stack<Character> stack = new Stack<Character>();
        char[] input = br.readLine().toCharArray();

        int i = 0;

        while (i < input.length) {
            // parenthesis -> until close
            if (input[i] == '<') {
                while (input[i] != '>') {
                    result.append(input[i]);
                    i++;
                }
                result.append(input[i++]);          // for '>'
            }

            // no parenthesis -> until blank
            else {
                while (input[i] != ' ') {           // push
                    stack.push(input[i++]);

                    if (i == input.length || input[i] == '<')
                        break;
                }
                while (!stack.empty()) {            // pop and append
                    result.append(stack.pop());
                }
                if (i < input.length && input[i] == ' ') {
                    result.append(input[i++]);      // for blank
                }
            }
        }

        bw.write(result.toString());
        bw.flush();
    }
}
