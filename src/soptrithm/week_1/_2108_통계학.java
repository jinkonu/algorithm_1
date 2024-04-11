package soptrithm.week_1;

// Arrays.sort()로 정렬한다.
// 하나씩 더해가면서 평균을 구한다. long을 사용한다.
// 중앙값은 N/2 인덱스로 구한다.
// 최빈값은 Map 구조를 운용하면서 찾는다.
// 범위는 [0]과 [N-1]의 차로 찾는다.

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _2108_통계학 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        int N = Integer.parseInt(reader.readLine());
        long total = 0;
        int maxFrequency = 1;
        Map<Integer, Integer> frequency = new LinkedHashMap<>();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(numbers);

        for (int i = 0; i < N; i++) {
            total += numbers[i];

            if (!frequency.containsKey(numbers[i]))
                frequency.put(numbers[i], 1);
            else {
                int currentFrequency = frequency.get(numbers[i]) + 1;
                frequency.put(numbers[i],  currentFrequency);

                if (currentFrequency > maxFrequency)
                    maxFrequency = currentFrequency;
            }
        }

        // 평균
        long average = Math.round((double) total / N);
        result.append(average).append("\n");

        // 중앙값
        int mid = numbers[N / 2];
        result.append(mid).append("\n");

        // 최빈값
        int finalMaxFrequency = maxFrequency;
        List<Integer> mostFrequentNumbers = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == finalMaxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        if (mostFrequentNumbers.size() == 1)
            result.append(mostFrequentNumbers.get(0)).append("\n");
        else
            result.append(mostFrequentNumbers.get(1)).append("\n");

        // 범위
        int coverage = numbers[N - 1] - numbers[0];
        result.append(coverage).append("\n");
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
