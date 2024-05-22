package soptrithm.week_6;

import java.io.*;
import java.util.Arrays;

public class _7795_먹을_것인가_먹힐_것인가 {

    static int T;
    static int N;
    static int M;

    static int[] A;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * A와 B를 정렬한다.
        * A에서 각 인덱스의 수 a를 잡는다.
        * a가 이전 인덱스의 수와 동일하면 그대로 받는다.
        * a의 이전 인덱스가 이미 B 크기를 가지고 있으면 그대로 가진다.
        * 둘 다 아니면, a의 이전 인덱스의 크기 +a로 탐색하기 위해 이전 인덱스가 마지막에 훑은 곳 이후부터 찾는다.
        * */
        T  = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= T; t++) {
            String[] input = reader.readLine().split(" ");

            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);

            A = new int[N];
            B = new int[M];

            input = reader.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(A);

            input = reader.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(B);

            result.append(eatOrEaten()).append("\n");
        }


        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static int eatOrEaten() {
        int total = 0;

        // initialize
        int firstElement = A[0];
        int index = 0;

        for (index = 0; index < M; index++)
            if (firstElement <= B[index])
                break;

        total += index;

        // proceed
        for (int i = 1; i < N; i++) {
            if (A[i] == A[i - 1]) {
                total += index;
                continue;
            }

            for (; index < M; index++)
                if (A[i] <= B[index])
                    break;

            total += index;
        }

        return total;
    }
}

class Bigger {

    int index;
    int size;

    public Bigger(int index, int size) {
        this.index = index;
        this.size = size;
    }
}