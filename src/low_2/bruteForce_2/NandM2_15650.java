package low_2.bruteForce_2;

/*
2023년 9월 9일 토요일
(1)
    brute force 문제다.
    15649번부터 시작되는 N과M 문제 시리즈의 두번째 문제다.
(2)
    stack을 써서 스택 안에 없는 임의의 수를 push하면서 M 길이의 수열을 만든다.
    가장 밑에 있는 숫자가 수열의 처음이므로, pop()이 아닌 remove()를 호출한다.
 */

import java.io.*;
import java.util.Stack;

public class NandM2_15650 {
    static StringBuilder result;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        result = new StringBuilder();

        // LOGIC START
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        for (int i = 1; i <= N - M + 1; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(i);

            recursive(stack);
        }

        result.deleteCharAt(result.length() - 1);
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void recursive(Stack<Integer> stack) {
        if (stack.size() == M) {
            while (!stack.isEmpty()) result.append(stack.remove(0)).append(" ");
            result.append("\n");
        }

        else {
            for (int i = stack.peek() + 1; i <= N; i++) {
                Stack<Integer> newStack = new Stack<>();
                newStack.addAll(stack);
                newStack.add(i);

                recursive(newStack);
            }
        }

    }
}
