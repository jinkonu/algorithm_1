package low.dataStructure_1;

/*
2023년 8월 18일 금요일
(1)
    BufferedReader, BufferedWriter를 사용하면 Scanner보다 빠른 입출력이 가능하다.
    다만, BufferedReader는 한 줄 읽기만 가능한 것 같다.
(2)
    LinkedList와 ListIterator를 활용해서 "시간 초과"를 극복할 수 있었다.
    Stack과 같은 자료형도 구성되어 있는 것 같으니 다음에 활용해보자.
*/

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Editer_1406 {
    static int count;
    static LinkedList<Character> list = new LinkedList<Character>();
    static ListIterator<Character> iter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        count = Integer.parseInt(br.readLine());
        iter = list.listIterator();
        for (int i = 0; i < input.length(); i++)
            iter.add(input.charAt(i));

        for (int i = 0; i < count; i++) {
            String cmd = br.readLine();

            switch (cmd.charAt(0)) {
                case 'L' -> left();
                case 'D' -> right();
                case 'B' -> remove();
                case 'P' -> add(cmd.charAt(2));
            }
        }

        for (Character c : list) {
            bw.write(c);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void left() {
        if (iter.hasPrevious())
            iter.previous();
    }

    private static void right() {
        if (iter.hasNext())
            iter.next();
    }

    private static void remove() {
        if (iter.hasPrevious()) {
            iter.previous();
            iter.remove();
        }
    }

    private static void add(char c) {
        iter.add(c);
    }
}