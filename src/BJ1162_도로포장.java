import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1162_도로포장 {

    static class Node implements Comparable<Node>{
        int next, value;

        public Node(int next, int value) {
            this.next = next;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(this.value == o.value) return 0;
            else if(this.value > o.value) return 1;
            else return -1;
        }
    }

    static long  min = Long.MAX_VALUE,  max  = Integer.MAX_VALUE;;
    static int N, M, K;
    static int[] dist, prev;
    static boolean[] visited;

    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        dist = new int[N+1];
        prev = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());

            list[r].add(new Node(c, v));
            list[c].add(new Node(r, v));
        }

        dijk(1);
        System.out.println(min);
    }

    private static void dijk(int start) {
//        Arrays.fill(dist, max);
//        Arrays.fill(prev, max);
        dist[start] = 0;
        prev[start] = 0;

        PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> a.value-b.value);
        pQ.offer(new Node(start, 0));
        while(!pQ.isEmpty()){
            Node node = pQ.poll();
            int cur = node.next;
            boolean flag = false;

            if(visited[cur]) continue;
            visited[cur] = true;
            for(Node n : list[cur]){
                if(dist[n.next] > dist[cur] + n.value){
                    if(n.next == N) flag = true;
                    dist[n.next] = dist[cur] + n.value;
                    prev[n.next] = cur;
                    pQ.offer(new Node(n.next, dist[n.next]));
                }
            }

            if(flag) min = Math.min(trace(N), min);


            //System.out.println(Arrays.toString(dist));
            //System.out.println(Arrays.toString(prev));
        }
        //System.out.println(min);
    }

    private static long trace(int end) {
        int idx = end;
        Stack<Integer> stack = new Stack<>();
        PriorityQueue<Integer> Q = new PriorityQueue(Collections.reverseOrder());

        long res = 0;

        while(idx != 0){
            stack.push(idx);
            Q.offer(dist[idx]);
            res += dist[idx];
            idx = prev[idx];
        }

        for (int i = 0; i < Math.min(K, Q.size()); i++) {
            res -= Q.poll();
        }

        //System.out.println(res);
        return res;
    }
}
