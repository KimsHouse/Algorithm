package Algorithm;

import java.util.*;

public class 우선순위큐다익스트라 {

    static int N, M, maxValue = 1234567890;
    static int[] dist;
    static int[][] map;
    //static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        dist = new int[N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = maxValue;
            }
        }
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();

            if(map[x][y] < v) continue;
            map[x][y] = v;
            //map[y][x] = v;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        dijk(start);
        //System.out.println(Arrays.toString(dist));

        System.out.println(dist[end]);
    }

    private static void dijk(int start) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //visited = new boolean[N+1];
        Arrays.fill(dist, maxValue);
        dist[start] = 0;
        //visited[start] = true;

        queue.offer(start);
        while (!queue.isEmpty()){
            int u = queue.poll();
            //int u = curr[1];
            //if(visited[u]) continue;

            //if(dist[u] < curr[0]) continue;

            for (int v = 1; v <= N; v++) {
                if(map[u][v] != 0 && v != u) {
                    if (dist[v] > dist[u] + map[u][v] && map[u][v] != maxValue) {
                        dist[v] = dist[u] + map[u][v];
                        queue.offer(v);
                    }
                }
            }
//            visited[u] = true;
        }
    }
}
