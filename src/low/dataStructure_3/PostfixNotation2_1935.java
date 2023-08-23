package low.dataStructure_3;

/*
2023년 8월 20일
(1)
    후위 표기식을 계산해서 결과값을 내는 문제다.
(2)
    식에서는 변수로 나와있고, 밑에 하나씩 대응하는 수가 등장한다.
    그래서 double[] 배열에 값을 담아놨다.
    어차피 변수가 등장하는 순서와 double[]에 들어있는 순서가 동일하므로, input 문자열에서 변수가 등장할 때마다 한 칸씩 옮겨가면서 스택애 push했다.
(3)
    연산자가 등장할 때마다 stack의 top에 있는 두 수를 꺼내서 연산을 진행하고 다시 push하면 된다.
    다만, 진짜 top에 있는 수가 식의 우항이어야 하지만 pop()을 하는 순서 상 왼쪽에 있을 수밖에 없게 된다.
    이 부분은 빼기와 나누기에서만 맞춰주면 되므로, 각각 -를 곱하고 1/n으로 곱하면서 처리해줬다.
 */

import java.io.*;
import java.util.Stack;

public class PostfixNotation2_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br   = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result= new StringBuilder();

        // LOGIC START
        int inputSize       = Integer.parseInt(br.readLine());
        double[] operand    = new double[inputSize];
        char[] input        = br.readLine().toCharArray();
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < inputSize; i++)
            operand[i] = Double.parseDouble(br.readLine());

        // CALCULATION
        int index = 65;
        for (char c : input) {
            switch (c) {
                // operator
                case '+' -> {
                    double addVal = stack.pop() + stack.pop();
                    stack.push(addVal);
                }
                case '-' -> {
                    double subVal = stack.pop() - stack.pop();
                    stack.push(-subVal);
                }
                case '*' -> {
                    double mulVal = stack.pop() * stack.pop();
                    stack.push(mulVal);
                }
                case '/' -> {
                    double divVal = stack.pop() / stack.pop();
                    stack.push(1 / divVal);
                }

                // operand
                default -> {
                    stack.push(operand[c - index]);
                }
            }
        }

        // LOGIC FINISH
        System.out.printf("%.2f", stack.pop());
        br.close();
    }
}
