package soptrithm.week_2;

// -10_000_000 ~ 10_000_000 사이의 수에 대한 각각의 개수를 알아야 한다.
// int[] negative, int[] positive로 각 인덱스를 수로 생각하고, 개수마다 더해서 리스트를 유지해보자.

import java.io.*;

public class _10816_숫자_카드_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int[] negative = new int[10_000_001];
        int[] positive = new int[10_000_001];

        int N = Integer.parseInt(reader.readLine());
        String[] cards = reader.readLine().split(" ");
        int M = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int card = Integer.parseInt(cards[i]);

            if (card < 0)
                negative[-card]++;
            else
                positive[card]++;
        }

        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(numbers[i]);

            if (number < 0)
                result.append(negative[-number]).append(" ");
            else
                result.append(positive[number]).append(" ");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
