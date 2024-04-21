package soptrithm.week_2;

/*
* BFS를 활용한다.
* 소수와 소수가 아닌 수를 미리 boolean[]으로 골라놓는다.
* BFS로 n부터 출발해서 네 가지 연산을 적용하고 Queue에 담는다.
* isVisited[]를 활용해서 이미 방문한 곳은 피한다.
* */

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _17394_핑거_스냅 {

    static int n;
    static int a;
    static int b;

    static boolean[] isNotPrime;
    static boolean[] isVisited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = reader.readLine().split(" ");

            n = Integer.parseInt(input[0]);
            a = Integer.parseInt(input[1]);
            b = Integer.parseInt(input[2]);

            isNotPrime = new boolean[3_000_001];
            getPrimeNumbers(b);
            isVisited = new boolean[3_000_001];
            min = Integer.MAX_VALUE;

            bfs();
            result.append(min).append("\n");
        }


        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void bfs() {
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(0, n));
        isVisited[n] = true;

        while (!queue.isEmpty()) {
            Number current = queue.poll();

            if (isPrime(current.value)) {
                min = Math.min(current.count, min);
                continue;
            }

            List<Integer> possibles = List.of(current.value / 3, current.value / 2, current.value - 1, current.value + 1);
            for (Integer possible : possibles)
                if (canVisit(possible)) {
                    isVisited[possible] = true;
                    queue.add(new Number(current.count + 1, possible));
                }
        }

        if (min == Integer.MAX_VALUE)
            min = -1;
    }

    private static boolean canVisit(int possible) {
        return 1 <= possible && possible <= 1_000_000  && !isVisited[possible];
    }

    private static boolean isPrime(int value) {
        return a <= value && value <= b && !isNotPrime[value];
    }

    private static void getPrimeNumbers(int b) {
        for (int i = 2; i <= Math.sqrt(b); i++)
            for (int j = i * 2; j <= b; j += i)
                isNotPrime[j] = true;
    }
}

class Number {
    int value;
    int count;

    public Number(int count, int value) {
        this.count = count;
        this.value = value;
    }
}