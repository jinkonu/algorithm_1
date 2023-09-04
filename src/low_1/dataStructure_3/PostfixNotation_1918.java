package low_1.dataStructure_3;

/*
2023년 8월 20일 일요일
(1)
    중위 표기식을 후위 표기식으로 변경하는 로직은 이전에도 짜본 적 있다.
    그런데 정확한 로직이 기억나지 않았고, 그때는 C로 짰었기 때문에 쉽게 풀지는 못했다.
(2)
    +, -와 *, / 사이의 우선순위를 표현하기 위해 HashMap 자료구조를 활용했다.
(3)
    연산자 X를 만났을 때에는 스택에 넣기 전에,
    스택 안에 있는 X보다 우선순위가 높은 top 엔트리를 후위 표기식에 추가해줘야 한다.
(4)
    닫는 괄호를 만났을 때에는,
    스택 안에 있는 top 엔트리를 전부 비워줘야 한다.
 */

import java.io.*;
import java.util.*;

public class PostfixNotation_1918 {
    static Map<Character, Integer> priority = new HashMap<>();
    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);

        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            // operator
            if (priority.containsKey(c))
                result.append(operator(c));

            else if (c == '(')
                stack.add(c);

            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();                                    // '(' 걷어내기
            }

            // operand
            else
                result.append(c);
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String operator(char c) {
        StringBuilder string = new StringBuilder();

        while (!stack.isEmpty() && stack.peek() != '(' && compare(stack.peek(), c))
            string.append(stack.pop());

        stack.add(c);
        return string.toString();
    }

    private static boolean compare(char c1, char c2) {
        return priority.get(c1) >= priority.get(c2);
    }
}
