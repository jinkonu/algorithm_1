package low.dataStructure_1;

/*
2023년 8월 18일 금요일
(1)
    circular list를 구현하는 데 애를 먹었다.
    circular list로 생각해보면, ListIterator 마지막 entry의 오른쪽 커서와 첫 entry의 왼쪽 커서가 동일하다.
    한 마디로, circular list에 대한 커서 개수는 N개여야 하는데, ListIterator는 N + 1개를 지원한다.
    이 부분을 맞춰주는 데, 어느 타이밍에 줄여줄 것인가에 대한 고민이 필요했다.
 */

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Josephus_1158 {
    static LinkedList<Integer> circle = new LinkedList<Integer>();
    static ListIterator<Integer> iter = circle.listIterator();
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        for (int i = 0; i < N; i++)
            iter.add(i + 1);
        iter = circle.listIterator();

        while (true) {
            for (int i = 0; i < K - 1; i++) {
                iter.next();
                if (!iter.hasNext()) iter = circle.listIterator();
            }

            ++count;
            if (count == N) {
                sb.append(iter.next()).append(">");
                break;
            }
            else {
                sb.append(iter.next()).append(", ");
                iter.remove();

                if (!iter.hasNext()) iter = circle.listIterator();
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
