import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1238_파티 {
    static class student {
        int arrival;
        int cost;

        public student(int arrival, int cost) {
            this.arrival = arrival;
            this.cost = cost;
        }

    }

    static int N, M, X, maxValue = 1234567890, tot = -1;
    static int[] dist;
    static int[][] map;
    static ArrayList<student>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        X = Integer.parseInt(tk.nextToken());

        list = new ArrayList[N+1];
        dist = new int[N+1];
        map = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            dist[i] = maxValue;
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());

            list[u].add(new student(v, c));
            //map[u][v] = c;

        }

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist, maxValue);
            dijk(i);
        }

        for (int i = 1; i <= N; i++) {
            if(map[i][X] + map[X][i] > tot) tot = map[i][X] + map[X][i];
        }

        System.out.println(tot);
    }

    private static void dijk(int start) {
        dist[start] = 0;
        PriorityQueue<student> pQ = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        pQ.offer(new student(start, 0));

        while(!pQ.isEmpty()){
            student std = pQ.poll();
            int curr = std.arrival;
            int value = std.cost;

            if(value > dist[curr]) continue;

            for (int i = 0; i < list[curr].size(); i++) {
                int next = list[curr].get(i).arrival;
                int v = list[curr].get(i).cost;

                if(dist[next] > dist[curr] + v) {
                    dist[next] = dist[curr] + v;
                    pQ.offer(new student(next, dist[next]));
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            map[start][i] = dist[i];
        }
    }
}
