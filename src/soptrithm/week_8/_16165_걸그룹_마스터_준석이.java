package soptrithm.week_8;

import java.io.*;
import java.util.*;

public class _16165_걸그룹_마스터_준석이 {

    static int n;
    static int m;
    static Map<String, List<String>> groups = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        /*
        * Map<String, Queue<String>> groups
        * */
        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String groupName = reader.readLine();
            List<String> members = new ArrayList<>();

            int memberCount = Integer.parseInt(reader.readLine());

            for (int j = 0; j < memberCount; j++) {
                String member = reader.readLine();
                members.add(member);
            }

            Collections.sort(members);
            groups.put(groupName, members);
        }

        for (int i = 0; i < m; i++) {
            String name = reader.readLine();
            int type = Integer.parseInt(reader.readLine());

            if (type == 0) {
                findGroupOfMember(name, result);
            }
            else {
                findMemberOfGroup(name, result);
            }
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static void findMemberOfGroup(String name, StringBuilder result) {
        for (String groupName : groups.keySet()) {
            List<String> members = groups.get(groupName);

            if (members.contains(name)) {
                result.append(groupName).append("\n");
                break;
            }
        }
    }

    private static void findGroupOfMember(String name, StringBuilder result) {
        groups.get(name)
                .forEach(member -> result.append(member).append("\n"));
    }
}
