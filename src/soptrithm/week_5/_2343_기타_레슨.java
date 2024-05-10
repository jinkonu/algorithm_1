package soptrithm.week_5;

/*
* m개 구간에 대한 모든 합을 비교하면 너무 느리다.
* 대신에, 최대가 되는 블루레이 크기만 구하고 늘이고 줄이면서 찾는 것이 낫다.
*
* */

import java.io.*;
import java.util.StringTokenizer;

public class _2343_기타_레슨 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lessonList = new int[n];

        int left = 0;
        int right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lessonList[i] = Integer.parseInt(st.nextToken());
            right += lessonList[i];
            left = Math.max(left, lessonList[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            int count = getCount(n, lessonList, mid);

            if(count > m){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        System.out.println(left);
    }

    private static int getCount(int n, int[] lessonList, int mid) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum + lessonList[i] > mid) {
                sum = 0;
                count++;
            }
            sum += lessonList[i];
        }

        if(sum != 0) count++;
        return count;
    }
}
