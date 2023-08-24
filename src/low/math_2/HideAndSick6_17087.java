package low.math_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HideAndSick6_17087 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        String[] firstLine = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        long S = Integer.parseInt(firstLine[1]);
        long D = 0;

        long[] broLocations = new long[N + 1];
        for (int i = 0; i < N; i++)
            broLocations[i] = Long.parseLong(secondLine[i]);
        broLocations[N] = S;
        Arrays.sort(broLocations);

        List<Long> gcdList = new ArrayList<>();
        for (int i = 1; i < broLocations.length; i++)
            gcdList.add(broLocations[i] - broLocations[0]);

        if (gcdList.size() == 1)
            result.append(gcdList.get(0));
        else {
            long gcd = 0;
            for (int i = 1; i < gcdList.size(); i++) {
                if (i == 1)
                    gcd = gcd(gcdList.get(0), gcdList.get(1));
                else
                    gcd = gcd(gcd, gcdList.get(i));
            }
            result.append(gcd);
        }
        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static long gcd(long x, long y) {
        if (x < y) {
            long tmp = x;
            x = y;
            y = tmp;
        }

        while (y != 0) {
            long remainder = x % y;
            x = y;
            y = remainder;
        }

        return x;
    }
}
