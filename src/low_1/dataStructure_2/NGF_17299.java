package low_1.dataStructure_2;

/*
2023년 8월 20일
(1)
    NEG의 문제 해결 방식과 매우 유사하다.
    다만, 일치하는 값을 찾을 때 오큰수가 아닌 오등큰수를 사용한다는 점이 다르다.
    그래서 단순히 입력값에 있는 숫자가 아니라, 그 숫자의 빈도를 저장하고 있을 자료구조가 필요하다.
(2)
    빈도 저장 자료구조 int[] freq는 해당 index에 빈도 수를 저장하고 있다.
    그런데 freq의 index는 입력값이기 때문에 배열의 크기를 가능한 입력값만큼 키워야 한다.
    가능한 입력값은 1 <= X <= 1,000,000였다.
    1,000,000이 index로 들어가려면 freq의 크기는 1,000,001이 되어야 한다.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class NGF_17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START

        int inputSize = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] seq = new int[inputSize];
        int[] freq = new int[1_000_000 + 1];
        Stack<Integer> stack = new Stack<>();

        int inputTmp;
        for (int i = 0; i < inputSize; i++) {
            inputTmp = Integer.parseInt(input[i]);
            seq[i] = inputTmp;              // update sequence of input
            ++freq[inputTmp];               // update frequency
        }

        int[] nextGreater = new int[inputSize];
        Arrays.fill(nextGreater, -1);   // 초기 값은 -1로 설정

        for (int i = 0; i < inputSize; i++) {
            while (!stack.isEmpty() && freq[seq[stack.peek()]] < freq[seq[i]]) {
                nextGreater[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < inputSize; i++) {
            result.append(nextGreater[i]).append(" ");
        }

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
