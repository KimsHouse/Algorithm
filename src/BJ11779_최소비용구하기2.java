import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ11779_최소비용구하기2 {
    static class Node {
        int curr, next, value;

        public Node(int curr, int next, int value) {
            this.curr = curr;
            this.next = next;
            this.value = value;
        }
    }

    static int N, M, count, max = 1234567890, start, end;
    static int[] dist, prev;
    static int[][] map;

    static boolean[] visited;
    static PriorityQueue<Node> pQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[1001][1001];
        dist = new int[1001];
        prev = new int[1001];
        visited = new boolean[1001];
        pQ = new PriorityQueue<>((a, b) -> a.value-b.value);

        for(int i = 1; i <= N; i++){
            dist[i] = max;
            //prev[i] = max;
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                map[i][j] = max;
            }
        }

        for(int i = 0; i < M; i++){
            tk = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());

            if(map[r][c] < v) continue;
            pQ.offer(new Node(r, c, v));

        }

        tk = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(tk.nextToken());
        end = Integer.parseInt(tk.nextToken());


        dijk(start);
        System.out.println(dist[end]);
        trace(prev);

    }

    private static void dijk(int start) {
        dist[start] = 0;
        //prev[start] = -1;

        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            int cur = node.curr;
            int nex = node.next;
            int val = node.value;

            if(val > dist[nex] || visited[cur] ) continue;
            visited[cur] = true;

            for (int j = 1; j <= N; j++ ) {
                if (dist[nex] > dist[cur] + val) {
                    //if(nex == start) continue;
                    dist[nex] = dist[cur] + val;
                    prev[nex] = cur;

                    //System.out.println(Arrays.toString(prev));
                    pQ.offer(new Node(cur, nex, dist[nex]));
                }
            }
        }
        //System.out.println(Arrays.toString(dist));
    }

    private static void trace(int[] list){
        int idx = end;
        Stack<Integer> stack = new Stack<>();
//        System.out.println("bf : "+idx);
//        System.out.println(Arrays.toString(list));
        while(idx != start){
            stack.push(idx);
//            System.out.println("idx : "+idx);
//            System.out.println("ldx : "+list[idx]);
            idx = list[idx];

        }
        stack.push(idx);
        System.out.println(stack.size());
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
