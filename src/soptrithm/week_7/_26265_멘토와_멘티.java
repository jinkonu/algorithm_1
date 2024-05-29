package soptrithm.week_7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _26265_멘토와_멘티 {

    static Map<String, List<String>> mentorAndMentees;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
         * 멘토-멘티를 TreeMap으로 운용해보자.
         * 멘토는 자동으로 정렬된다.
         * */
        mentorAndMentees = new TreeMap<>();
        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String mentor = line[0];
            String mentee = line[1];

            if (!mentorAndMentees.containsKey(mentor))
                mentorAndMentees.put(mentor, new ArrayList<>());

            mentorAndMentees.get(mentor).add(mentee);
        }

        for (Map.Entry<String, List<String>> mentorAndMentee : mentorAndMentees.entrySet()) {
            List<String> sortedMentees = mentorAndMentee.getValue().stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            for (String sortedMentee : sortedMentees) {
                result.append(mentorAndMentee.getKey()).append(" ").append(sortedMentee).append("\n");
            }
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}
