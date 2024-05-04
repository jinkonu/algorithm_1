package soptrithm.week_4;

/*
* 메모리 초과가 계속 발생해서
* 결국 다른 답안을 보고 제출하게 되었다.
*
* */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _24446_알고리즘_수업_너비_우선_탐색_3 {
    static ArrayList<ArrayList<Integer>> arr;
    static int d[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken())-1;

        arr=new ArrayList<>();
        d=new int[n];

        for(int i=0; i<n; i++) {
            arr.add(new ArrayList<>());
            d[i]=-1;
        }

        for(int i=0; i<m; i++) {
            st=new StringTokenizer(bf.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        d[r]=0;
        bfs(r);

        for(int i=0; i<n; i++) {
            bw.write(d[i]+"\n");
        }
        bw.flush();
    }

    private static void bfs(int r) {
        Queue<Integer>queue=new LinkedList<>();
        queue.add(r);

        while(!queue.isEmpty()) {
            int num=queue.poll();
            for(int i=0; i<arr.get(num).size(); i++) {
                int temp=arr.get(num).get(i);
                if(d[temp]==-1){
                    d[temp]=d[num]+1;
                    queue.add(temp);
                }
            }
        }
    }
}