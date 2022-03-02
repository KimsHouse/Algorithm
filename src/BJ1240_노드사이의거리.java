import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1240_노드사이의거리 {

    static int N, M, max = 1234567890;
    static int[] dist;

    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;
        StringBuilder sb = new StringBuilder();

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        map = new int[N+1][N+1];
        dist = new int[N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = max;
            }
        }

        for (int i = 0; i < N-1; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int v = Integer.parseInt(tk.nextToken());

            map[r][c] = v;
            map[c][r] = v;
        }

        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(tk.nextToken());
            int end = Integer.parseInt(tk.nextToken());

            dijk(start);
            sb.append(dist[end]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dijk(int start) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Arrays.fill(dist, max);
        dist[start] = 0;
        queue.offer(start);

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for (int next = 1; next <= N; next++) {
                if(map[curr][next] != 0 && curr != next){
                    if(dist[next] > dist[curr] + map[curr][next] && map[curr][next] != max){
                        dist[next] = dist[curr] + map[curr][next];
                        queue.offer(next);
                    }
                }

            }
        }

    }
}
