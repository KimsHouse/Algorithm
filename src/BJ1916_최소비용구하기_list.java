import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ1916_최소비용구하기_queue {
    static class bus{
        int u;
        int v;
        int val;

        public bus(int u, int v, int val) {
            this.u = u;
            this.v = v;
            this.val = val;
        }

    }


    static int N, M, maxValue = 1234567890;
    static int[] dist;
    static int[][] map;
    static boolean[] visited;

    static PriorityQueue<bus> bQ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        bQ = new PriorityQueue<>((a, b) -> (a.u-b.u));

        for (int i = 1; i <= N; i++) {
            dist[i] = maxValue;
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                map[i][j] = maxValue;
            }
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();

            bQ.add(new bus(x, y, v));

        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijk(start);
        System.out.println(dist[end]);

    }

    private static void dijk(int start) {
        dist[start] = 0;

        //System.out.println("bq size : "+bQ.size());
        //for (int i = 0; i < M; i++) {
        while(!bQ.isEmpty()){
            bus q = bQ.poll();
            int u = q.u;
            int v = q.v;
            int val = q.val;

//            System.out.println("u : "+u);
//            System.out.println("v : "+v);
//            System.out.println("val : "+val);

            //for (int j = 1; j <= N; j++) {
                if(dist[v] > dist[u] + val) {
                    if(v == start) continue;
                    dist[v] = dist[u] + val;
                    bQ.offer(new bus(u, v, dist[v]));
                    //System.out.println(Arrays.toString(dist));
                }
            //}

        }
    }


}
