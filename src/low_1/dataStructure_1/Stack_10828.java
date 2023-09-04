package low_1.dataStructure_1;

/* 2023년 8월 16일 수요일
(1)
    String보다 StringBuilder가 빠르다.
(2)
    StringBuilder는 append("\n")을 통해 여러 줄을 한꺼번에 담고 있을 수 있다.
 */

import java.util.Scanner;

import static low_1.dataStructure_1.Stack_10828.Service.*;

public class Stack_10828 {
    static int[] stack;
    static int count;

    public Stack_10828() {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int commandNum = scanner.nextInt();
        stack = new int[commandNum];
        count = 0;


        for (int i = 0; i < commandNum; i++) {
            String command = scanner.next();

            if (command.equals("pop"))
                sb.append(pop()).append("\n");

            else if (command.equals("size"))
                sb.append(size()).append("\n");

            else if (command.equals("empty"))
                sb.append(empty()).append("\n");

            else if (command.equals("top"))
                sb.append(top()).append("\n");

            else {
                push(scanner.nextInt());
            }
        }

        System.out.println(sb);
    }

    static class Service {
        public static void push(int elem) {
            stack[count++] = elem;
        }

        public static int pop() {
            if (count == 0) return -1;
            else return stack[--count];
        }

        public static int size() {
            return count;
        }

        public static int empty() {
            if (count == 0) return 1;
            else return 0;
        }

        public  static int top() {
            if (empty() == 1) return -1;
            return stack[count - 1];
        }
    }
}
