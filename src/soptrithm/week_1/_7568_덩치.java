package soptrithm.week_1;

/*
*
* 정렬하는 것에 초점을 두지 않아야 한다.
* 대신에, 브루트 포스 방식으로 각 요소르 다른 요소들과 비교해야 한다.
* */

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class _7568_덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // LOGIC START
        // 한꺼번에 정렬하는 것보다, 각 인덱스의 요소를 잡고 나머지와 비교해서 자기 위치를 찾는 게 빠르다.

        int N = Integer.parseInt(reader.readLine());
        List<Body> bodies = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            List<Integer> heightAndWeight = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            bodies.add(new Body(heightAndWeight.get(0), heightAndWeight.get(1)));
        }

        for (int i = 0; i < N; i++) {
            int rank = 1;

            for (int j = 0; j < N; j++) {
                if (bodies.get(i).weight < bodies.get(j).weight && bodies.get(i).height < bodies.get(j).height)
                    ++rank;
            }

            result.append(rank).append(" ");
        }
        // LOGIC FINISH

        writer.write(result.toString());
        writer.flush();

        reader.close();
        writer.close();
    }
}

class Body {
    public int weight;
    public int height;

    public Body(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}
