import java.util.*;

public class _1205_등수_구하기 {

    // 구현인데 코너 케이스를 하나하나 풀다 보니 다른 케이스가 꼬이기 시작하면서 해결하지 못했다.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int new_score = scanner.nextInt();
        int p = scanner.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        if (n == p && new_score <= arr[arr.length - 1])
            System.out.print(-1);
        else {
            int rank = 1;
            for (int i = 0; i < arr.length; i++) {
                if (new_score < arr[i])
                    rank++;
                else
                    break;
            }
            System.out.print(rank);
        }
    }
}
