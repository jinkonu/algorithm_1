import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _9017_크로스_컨트리 {

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // Map<Integer, Integer> sizes를 두고, 각 팀의 사이즈를 구한다.
        // value가 6 미만이면 entry를 삭제한다.
        // Map<Integer, int[7]> scores를 두고, valid한 팀의 점수를 누적합으로 구한다.
        // scores.values.map(int[4])의 최솟값 min을 구한다. (팀 점수 총합의 최솟값)
        // scores.filter(value[4] == min).sorted(value[5])로 min 값을 가진 것들을 [5] 기준으로 정렬하면 구할 수 있다.
        t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] ranks = new int[n + 1];
            Map<Integer, Integer> sizes = new HashMap<>();

            String[] inputs = reader.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                ranks[j] = Integer.parseInt(inputs[j - 1]);
                sizes.put(ranks[j], sizes.getOrDefault(ranks[j], 0) + 1);
            }

            List<Integer> filtered = sizes.keySet().stream()
                    .filter(key -> sizes.get(key) == 6)
                    .collect(Collectors.toUnmodifiableList());

            Map<Integer, int[]> scores = new HashMap<>();
            int[] counts = new int[201];
            Arrays.fill(counts, 1);
            int rank = 1;
            for (int j = 1; j <= n; j++) {
                if (filtered.contains(ranks[j])) {
                    scores.putIfAbsent(ranks[j], new int[7]);
                    scores.get(ranks[j])[counts[ranks[j]]] += scores.get(ranks[j])[counts[ranks[j]] - 1] + rank;

                    counts[ranks[j]]++;
                    rank++;
                }
            }

            int min = scores.values().stream()
                    .map(value -> value[4])
                    .min(Integer::compareTo)
                    .get();

            Integer winner = scores.entrySet().stream()
                    .filter(entry -> entry.getValue()[4] == min)
                    .sorted(Comparator.comparingInt(entry -> entry.getValue()[5]))
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toUnmodifiableList())
                    .get(0);
            result.append(winner).append("\n");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
