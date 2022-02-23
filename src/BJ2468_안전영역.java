import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2468_안전영역 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, count;

    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];


        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(tk.nextToken());
            }
        }

        for (int k = 0; k <= 100; k++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > k && !visited[i][j]) {
                        bfs(i, j, k);
                        cnt++;
                    }
                }
            }
            //System.out.println(k+"층 : "+cnt);
            count = Math.max(count, cnt);
        }

        System.out.println(count);
    }

    private static void bfs(int r, int c, int height) {
        visited[r][c] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];


            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 0 || sx >= N || sy < 0 || sy >= N || visited[sx][sy] || map[sx][sy] <= height) continue;

                visited[sx][sy] = true;

//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < N; j++) {
//                        System.out.print(visited[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                queue.offer(new int[]{sx , sy});
            }
        }
    }
}
