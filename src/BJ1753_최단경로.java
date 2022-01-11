import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_최단경로 {
    static class Node {
        int arrival;
        int cost;

        public Node(int arrival, int cost) {
            this.arrival = arrival;
            this.cost = cost;
        }
    }

    static int N, M;
    static int[] dist;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        list = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());

            list[u].add(new Node(v, c));

        }

        dijk(start);
        for (int i = 1; i <= N; i++) {
            if(dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
                continue;
            }
            sb.append(dist[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijk(int start) {
        dist[start] = 0;
        PriorityQueue<Node> pQ = new PriorityQueue<>((a, b) -> (a.cost-b.cost));
        pQ.offer(new Node(start, 0));

        while(!pQ.isEmpty()){
            Node n = pQ.poll();
            int curr = n.arrival;
            int cost = n.cost;

            if(cost > dist[curr]) continue;

            for (int i = 0; i < list[curr].size(); i++) {
                int next = list[curr].get(i).arrival;
                int val = list[curr].get(i).cost;

                if(dist[next] > dist[curr] + val) {
                    dist[next] = dist[curr] + val;
                    pQ.offer(new Node(next, dist[next]));
                }

            }
        }
    }
}
