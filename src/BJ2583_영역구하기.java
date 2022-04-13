import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2583_영역구하기 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int M, N, K;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());
        K = Integer.parseInt(tk.nextToken());

        map = new int[M+1][N+1];
        visited = new boolean[M+1][N+1];

        for (int k = 0; k < K; k++) {
            tk = new StringTokenizer(br.readLine(), " ");
            int fx = Integer.parseInt(tk.nextToken());
            int fy = Integer.parseInt(tk.nextToken());
            int sx = Integer.parseInt(tk.nextToken());
            int sy = Integer.parseInt(tk.nextToken());

            makeSquare(fy+1, fx+1, sy, sx);
            //printArr();
        }

        int areaCnt = 0;
        PriorityQueue<Integer> pQ = new PriorityQueue<>((a, b) -> a-b);
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if(!visited[i][j]){
                    pQ.offer(BFS(i, j));
                    areaCnt++;
                    //printArr();
                }
            }
        }
        System.out.println(areaCnt);
        while (!pQ.isEmpty()){
            System.out.print(pQ.poll()+" ");
        }
    }

    private static void printArr() {
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N ; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void makeSquare(int fx, int fy, int sx, int sy) {

        for (int r = fx; r <= sx; r++) {
            for (int c = fy; c <= sy ; c++) {
                //System.out.println(r+" "+c);
                visited[r][c] = true;
                map[r][c] = 1;
            }
        }

    }

    private static int BFS(int i, int j) {
        //System.out.println("hi");
        int res = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 1 || sx > M || sy < 1 || sy > N || visited[sx][sy]) continue;

                //System.out.println(sx+" "+sy);
                res++;
                visited[sx][sy] = true;
                queue.offer(new int[]{sx, sy});
            }
        }

        return res;
    }
}
