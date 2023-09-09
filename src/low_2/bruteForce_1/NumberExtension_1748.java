package low_2.bruteForce_1;

import java.io.*;

public class NumberExtension_1748 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        long N = Long.parseLong(br.readLine());
        long ans = 0;
        long ten = 0;
        long mod;

        if (N < 10)
            result.append(N);
        else {
            while (true) {
                // all cover
                if (N / Math.pow(10, ten) >= 10) {
                    ++ten;
                    ans += ten * (Math.pow(10, ten) - Math.pow(10, ten - 1));
                }

                // partial cover
                else {
                    ans += (ten + 1) * (N - Math.pow(10, ten) + 1);
                    break;
                }
            }
            result.append(ans);
        }

        // LOGIC FINISH

        bw.write(result.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
