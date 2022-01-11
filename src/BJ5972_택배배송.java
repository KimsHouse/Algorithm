import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ5972_택배배송 {
    static class Node {
        int end;
        int cost;

        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }

    static int N, M, max = Integer.MAX_VALUE;
    static int[] dist;

    static PriorityQueue<Node> pQ;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        dist = new int[N+1];
        list = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            dist[i] = max;
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine()," ");

            int x = Integer.parseInt(tk.nextToken());
            int y = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());

            //pQ.offer(new Node(y, c));
            list[x].add(new Node(y, c));
            list[y].add(new Node(x, c));
        }

        dijk(1);
        System.out.println(dist[N]);
    }

    private static void dijk(int start) {
        dist[start] = 0;
        pQ = new PriorityQueue<>((a,b)->a.cost-b.cost);
        pQ.offer(new Node(start, 0));

        while(!pQ.isEmpty()){
            Node xy = pQ.poll();
            int curr = xy.end;
            int value = xy.cost;

            if(value > dist[curr]) continue;

            for (int i = 0; i < list[curr].size(); i++) {
                int next = list[curr].get(i).end;
                int val = list[curr].get(i).cost;

                if(dist[next] > dist[curr] + val) {

                    dist[next] = dist[curr] + val;
                    pQ.offer(new Node(next, dist[next]));
                }
            }
        }

    }
}
