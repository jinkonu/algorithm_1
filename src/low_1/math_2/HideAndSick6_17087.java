package low_1.math_2;

/*
2023년 8월 24일 목요일
(1)
    S의 위치를 어떻게 처리할지가 고민이었다.
    결국에는 S도 broLocations[] 안 하나의 점으로 처리하고 풀었다.
(2)
    원래는 broLocations[] 내 엔트리끼리의 차로 다시 리스트를 만들었다.
    엔트리끼리의 차가 가진 최대공약수를 구해야겠다고 생각했다.
(3)
    그렇지만 그냥 엔트리의 최소공약수만 구해도 충분할 것 같았다.
    그러나 그러려면 중심점이 필요할 것 같았고, 그래서 첫번째 엔트리를 기준으로 다 빼서 최대공약수를 구했다.
 */

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
