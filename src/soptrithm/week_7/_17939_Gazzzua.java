package soptrithm.week_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _17939_Gazzzua {

    static int n;
    static List<Price> prices = new ArrayList<>();
    static List<Price> sortedPrices = new ArrayList<>();
    static boolean[] visited;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * 그리디 알고리즘을 활용하라고 했는데 잘 모르겠다...
        * 그냥 나보다 큰 인덱스에 큰 값이 있으면 사면 될 것 같다.
        * 제일 큰 값을 가진 인덱스부터 작은 순으로 찾아간다.
        * 해당 인덱스의 왼쪽에 대해 아직 방문하지 않은 경우 차의 총합을 구한다.
        * */
        n = Integer.parseInt(reader.readLine());
        visited = new boolean[n];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            prices.add(new Price(i, Integer.parseInt(input[i])));
        }

        sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Price::compareTo);

        for (int i = 0; i < n; i++) {
            if (!visited[sortedPrices.get(i).index]) {
                visited[sortedPrices.get(i).index] = true;

                int index = sortedPrices.get(i).index;
                int value = sortedPrices.get(i).value;

                for (int j = 0; j < index; j++) {
                    if (!visited[j]) {
                        visited[j] = true;

                        total += (value - prices.get(j).value);
                    }
                }
            }
        }

        result.append(total);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}

class Price implements Comparable<Price> {

    int index;
    int value;

    public Price(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Price o) {
        return o.value - value;
    }

    @Override
    public String toString() {
        return index + " " + value;
    }
}