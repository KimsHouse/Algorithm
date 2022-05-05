import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7262_나이트의이동 {

    static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};

    static int N, result;

    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){ // 테케

            N = Integer.parseInt(br.readLine());
            result = 0;
            board = new int[N][N];
            visited = new boolean[N][N];

            tk = new StringTokenizer(br.readLine(), " ");
            int sr = Integer.parseInt(tk.nextToken());
            int sc = Integer.parseInt(tk.nextToken());

            tk = new StringTokenizer(br.readLine(), " ");
            int gr = Integer.parseInt(tk.nextToken());
            int gc = Integer.parseInt(tk.nextToken());

            moveHorse(sr, sc, gr, gc);

            System.out.println(result);

        }

    }

    private static void moveHorse(int sr, int sc, int gr, int gc) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc, 0});
        visited[sr][sc] = true;

        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];
            int dis = xy[2];

            for(int d = 0; d < 8; d++){
                int sx = x + dr[d];
                int sy = y + dc[d];

                if(sx < 0 || sx >= N || sy < 0 || sy >= N || visited[sx][sy]) continue;

                board[sx][sy] = 1;
                //printArr();

                if(sx == gr && sy == gc){
                    result = dis+1;
                    return;
                }

                queue.offer(new int[]{sx, sy, dis+1});
                visited[sx][sy] = true;

            }

        }

    }

    private static void printArr() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

