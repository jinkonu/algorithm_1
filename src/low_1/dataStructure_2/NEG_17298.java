package low_1.dataStructure_2;

/*
2023년 8월 19일 토요일
(1)
    chatGPT의 힘을 빌려서 스택 버전으로 변경했다.
(2)
    내가 만든 버전은 입력 배열을 우선 정렬하고,
    내가 가리키고 있는 엔트리가 최댓값이면 -1을 붙이고 정렬 배열에서 그 값을 뺐다.
    내가 가리키고 있는 엔트리가 최댓값보다 작으면 오큰값을 찾기 위해 우측으로 하나씩 확인했다.
(2)
    지피티가 만들어준 버전에서는 스택을 사용한다.
    top에 있는 값이 현재값보다 작으면 pop()해서 오큰값으로 설정해주고, 이를 반복한다.
    스택이 비거나 top이 현재값보다 커지면 현재값을 push한다.
    이 방식은 sort도 필요없고, iteration 숫자고 input size와 동일하다는 장점이 있는 것 같다.
 */

import java.io.*;
import java.util.*;

public class NEG_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int inputNum = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] seq = new int[inputNum];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < inputNum; i++) {
            seq[i] = Integer.parseInt(input[i]);
        }

        int[] nextGreater = new int[inputNum];
        Arrays.fill(nextGreater, -1);  // 초기 값은 -1로 설정

        for (int i = 0; i < inputNum; i++) {
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]) {
                nextGreater[stack.pop()] = seq[i];
            }
            stack.push(i);
        }

        for (int i = 0; i < inputNum; i++) {
            result.append(nextGreater[i]).append(" ");
        }

        bw.write(result.toString());
        bw.flush();
    }
}
