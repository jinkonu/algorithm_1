package low_1_again;

/*
* 최소공배수는 A * B / 최소공약수이다.
* 최소공약수는 유클리드 호제법을 통해 구할 수 있다.
* 유클리드 호제법은 나머지가 0가 될 때까지 A % B로 시작해서 몫을 나머지로 나눠간다.
*
* */

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1934_최소공배수 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        List<Long> input = Arrays.stream(reader.readLine().split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        long lcm;
        if (input.get(0) == 0 || input.get(1) == 1)
            lcm = getOne(input);
        else
            lcm = input.get(0) * input.get(1) / gcd(input.get(0), input.get(1));

        result.append(lcm);
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }

    private static long getOne(List<Long> input) {
        return input.get(0) == 0 ? input.get(1) : input.get(0);
    }

    private static long gcd(long x, long y) {
        long mod = x % y;

        if (mod == 0)
            return y;
        else
            return gcd(y, mod);
    }
}
