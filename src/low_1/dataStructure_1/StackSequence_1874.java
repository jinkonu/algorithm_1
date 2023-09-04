package low_1.dataStructure_1;

/* 2023년 8월 17일 목요일

 */

import java.util.Scanner;

public class StackSequence_1874 {
    static int[] stack;
    static boolean[] popped;
    static int top = 0;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] input = new int[num];
        for (int i = 0; i < num; i++)
            input[i] = scanner.nextInt();

        stack = new int[num];
        popped = new boolean[num];

        int tmpNum = 1;
        for (int i = 0; i < num; i++) {
            if (popped[input[i] - 1]) {
                System.out.println("NO");
                return;
            }

            while (input[i] >= tmpNum) {
                push(tmpNum++);
            }
            while (input[i] != pop());
        }

        System.out.println(result);
    }

    private static void push(int i) {
        stack[top++] = i;
        result.append("+").append("\n");
    }

    private static int pop() {
        int target = stack[--top];
        popped[target - 1] = true;
        result.append("-").append("\n");

        return target;
    }
}
