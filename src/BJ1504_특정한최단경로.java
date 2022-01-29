import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1504_특정한최단경로 {
    static class Node {
        int next, value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }

    }

    static int N, M, fir, sec, max = 300000000;
    static int[] dist;
    static int[][] map;

    static boolean[] visitArr;

    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        dist = new int[N+1];
        visitArr = new boolean[N+1];
        map = new int[N+1][N+1];
        list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
            for(int j = 1; j <= N; j++){
                if(i == j) map[i][j] = 0;
                map[i][j] = max;
            }
        }

        for(int i = 0; i < M; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());

            if(map[r][c] < v) continue;
            //System.out.println("hi : "+v);
            list[r].add(new Node(c, v));
            list[c].add(new Node(r, v));

        }

        tk = new StringTokenizer(br.readLine(), " ");
        fir = Integer.parseInt(tk.nextToken());
        sec = Integer.parseInt(tk.nextToken());

        int res = solve(fir, sec);
        if(res >= max) System.out.println(-1);
        else System.out.println(res);

    }

    private static int solve(int fir, int sec){
        int res1 = 0;
        res1 += dijk(1, fir);
        res1 += dijk(fir, sec);
        res1 += dijk(sec, N);

        int res2 = 0;
        res2 += dijk(1, sec);
        res2 += dijk(sec, fir);
        res2 += dijk(fir, N);

//        System.out.println("res1 : "+res1);
//        System.out.println("res2 : "+res2);

        return Math.min(res1, res2);

    }

    private static int dijk(int start, int end){
        Arrays.fill(dist, max);
        Arrays.fill(visitArr, false);
        dist[start] = 0;
        PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> a.value-b.value);
        pQ.offer(new Node(start, 0));
        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            int cur = node.next;
            int val = node.value;

            //System.out.println("cur : "+cur);

            if(val > dist[cur] || visitArr[cur]) continue;

            for(Node n : list[cur]){
                if(dist[n.next] > dist[cur] + n.value){
                    //System.out.println("val : "+val);
                    dist[n.next] = dist[cur] + n.value;

                    pQ.offer(new Node(n.next, dist[n.next]));
                }
            }
            visitArr[cur] = true;
        }
        //System.out.println(Arrays.toString(dist));
        return dist[end];
    }
}
