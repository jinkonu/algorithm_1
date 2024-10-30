import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class _18428_감시_피하기 {

    static int n;
    static int[][] matrix;
    static List<Student> students = new ArrayList<>();
    static List<int[]> emptySpaces = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        // 브루트포스를 사용해야 한다.
        // 모든 조합 가능한 3개의 장애물 점들을 찾는다.
        // 각 조합을 가지고, 학생들로부터 가로 및 세로로 탐색한다.
        // 선생님을 만났다면 그 조합은 실패했으므로 다음 조합으로 넘어간다.
        // 모든 학생들이 선생님을 1번도 안만났다면 성공했으므로 YES를 출력하고 조합을 그만 찾는다.
        // 모든 조합에 대해 학생들의 탐색이 실패했다면 NO를 출력한다.
        n = Integer.parseInt(reader.readLine());
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                String value = line[j];
                switch (value) {
                    case "X" -> {
                        matrix[i][j] = 0;
                        emptySpaces.add(new int[]{i, j});
                    }
                    case "T" -> matrix[i][j] = 2;
                    case "S" -> {
                        matrix[i][j] = 1;
                        students.add(new Student(i, j));
                    }
                }
            }
        }

        // 장애물 배치 조합을 찾고, 탐색 시작
        if (findObstacleCombinations(0, 0)) {
            result.append("YES");
        } else {
            result.append("NO");
        }

        writer.write(result.toString());
        writer.flush();
        reader.close();
        writer.close();
    }

    // 장애물 배치 조합 찾기
    static boolean findObstacleCombinations(int start, int count) {
        if (count == 3) {
            // 3개의 장애물 조합이 완성되었으면 감시 가능 여부 확인
            if (canAvoidSurveillance()) {
                return true;
            }
            return false;
        }

        for (int i = start; i < emptySpaces.size(); i++) {
            int[] pos = emptySpaces.get(i);
            matrix[pos[0]][pos[1]] = 3; // 장애물 배치
            if (findObstacleCombinations(i + 1, count + 1)) {
                return true;
            }
            matrix[pos[0]][pos[1]] = 0; // 장애물 제거 (백트래킹)
        }
        return false;
    }

    // 감시 가능 여부 확인
    static boolean canAvoidSurveillance() {
        for (Student student : students) {
            if (isDetected(student.y, student.x)) {
                return false;
            }
        }
        return true;
    }

    // 특정 학생이 감시되는지 확인
    static boolean isDetected(int y, int x) {
        // 상, 하, 좌, 우 네 방향으로 감시
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int ny = y;
            int nx = x;
            while (true) {
                ny += dy[i];
                nx += dx[i];
                if (ny < 0 || ny >= n || nx < 0 || nx >= n || matrix[ny][nx] == 3) {
                    break;  // 범위를 벗어나거나 장애물이 있는 경우
                }
                if (matrix[ny][nx] == 2) {
                    return true; // 선생님을 만난 경우 감시 가능
                }
            }
        }
        return false;
    }
}

class Student {
    int y;
    int x;

    public Student(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
