package soptrithm.week_3;

/*
* 동일한 풀이인데 인터넷에서 찾은 답변은 통과되고
* 내 것은 통과되지 않았다... 왜일까?
*
* */

/*
 * nCr을 통해 남을 수 있는 치킨집의 조합을 모두 구한다.
 * 각 조합마다 도시의 치킨 거리를 구한다.
 * 도시의 치킨 거리는, 각 집을 기준으로 남아 있는 모든 치킨집과의 거리 중에서 가장 가까운 것을 고른다.
 *
 * 참고로, 조합을 구했을 당시에 바로 구하는 것이
 * 연산의 절차를 줄일 수 있다.
 * */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _15686_치킨_배달 {

    static int N;
    static int M;
    static int[][] city;
    static List<Place> chickens;
    static List<Place> houses;
    static List<List<Place>> leftChickens = new ArrayList<>();
    static int minDistance = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
      BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder result = new StringBuilder();

      // LOGIC START
      String[] metaLine = reader.readLine().split(" ");
      N = Integer.parseInt(metaLine[0]);
      M = Integer.parseInt(metaLine[1]);

      houses = new ArrayList<>();
      chickens = new ArrayList<>();
      city = new int[N][N];
      for (int i = 0; i < N; i++) {
          String[] line = reader.readLine().split(" ");

          for (int j = 0; j < N; j++) {
              city[i][j] = Integer.parseInt(line[j]);

              if (city[i][j] == 1)
                  houses.add(new Place(i, j));

              if (city[i][j] == 2)
                  chickens.add(new Place(i, j));
          }
      }

      combination(0, new boolean[chickens.size()]);
      result.append(minDistance);
      // LOGIC FINISH

      writer.write(result.toString());
      writer.flush();

      reader.close();
      writer.close();
  }

    private static void getDistance(boolean[] visited) {
        int total = 0;

        for (Place house : houses) {
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    Place chicken = chickens.get(i);
                    min = Math.min(min, house.distanceFrom(chicken));
                }
            }

            total += min;
        }

        minDistance = Math.min(minDistance, total);
    }

    static void combination(int size, boolean[] visited) {
      if (size == M)
          getDistance(visited);

      for (int i = 0; i < visited.length; i++)
          if (!visited[i]) {
              visited[i] = true;
              combination(size + 1, visited);
              visited[i] = false;
          }
  }
}

class Place {
    int y;
    int x;

    public Place(int y, int x) {
        this.y = y;
        this.x = x;
    }

    int distanceFrom(Place place) {
        return Math.abs(x - place.x) + Math.abs(y - place.y);
    }
}
