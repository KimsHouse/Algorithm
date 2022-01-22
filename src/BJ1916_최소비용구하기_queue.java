import java.util.*;

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
    static int[] dist, copy;
    static int[][] map;
    static boolean[] visited;
    static Stack<Integer> stack = new Stack<>();

    static PriorityQueue<bus> bQ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        copy = new int[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];
        bQ = new PriorityQueue<>((a, b) -> (a.val-b.val));

        for (int i = 1; i <= N; i++) {
            dist[i] = maxValue;
            copy[i] = -1;
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                map[i][j] = maxValue;
            }
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();

            map[x][y] = v;
            bQ.add(new bus(x, y, v));

        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijk(start);

        System.out.println(dist[end]);

    }

    private static void dijk(int start) {
        dist[start] = 0;
        Queue<Integer> qq = new LinkedList<>();

        //System.out.println("bq size : "+bQ.size());
        //for (int i = 0; i < M; i++) {
        while(!bQ.isEmpty()){
            Iterator<bus> it = bQ.iterator();
//            while(it.hasNext()){
//                bus b = it.next();
//                System.out.print("[ "+b.u+", "+b.v+", "+b.val+" ], ");
//            }
            //System.out.println();
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
                    qq.offer(v);
                    dist[v] = dist[u] + val;
                    copy[v] = u;
                    //System.out.println("c u : "+u);
                    System.out.println(Arrays.toString(copy));
                    //map[v][u] = dist[v];
                    bQ.offer(new bus(u, v, dist[v]));
                    //System.out.println(Arrays.toString(dist));
                }
            //}

        }

        reverse(copy);
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        //System.out.println(qq);
    }

    private static void reverse(int[] copy) {
        int idx = N;
        while(idx != -1){
            stack.push(idx);
//            System.out.println("idx : "+idx);
//            System.out.println("cdx : "+copy[idx]);
            idx = copy[idx];
        }
        System.out.println(stack.size());
    }


}
