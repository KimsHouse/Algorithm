import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7569_토마토 {

    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};

    static int N, M, H, totalTomato, result;

    static Queue<int[]> queue;

    static int[][][] boxes;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(tk.nextToken());
        N = Integer.parseInt(tk.nextToken());
        H = Integer.parseInt(tk.nextToken());

        boxes = new int[H][N][M];
        visited = new boolean[H][N][M];
        queue = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                tk = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    boxes[h][n][m] = Integer.parseInt(tk.nextToken());
                    if(boxes[h][n][m] == 0) totalTomato++;
                    else if(boxes[h][n][m] == 1) queue.offer(new int[]{h, n, m});
                }
            }
        }


        //printArr();
        bfs();

        if(totalTomato != 0) System.out.println(-1);
        else System.out.println(result);

    }

    private static void bfs() {

        while(!queue.isEmpty()){
            int[] xyz = queue.poll();
            int z = xyz[0];
            int x = xyz[1];
            int y = xyz[2];

            for(int d = 0; d < 6; d++){ // 6방향
                int sz = z + dz[d];
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sz < 0 || sz >= H || sx < 0 || sx >= N || sy < 0 || sy >= M || boxes[sz][sx][sy] != 0) continue;

                boxes[sz][sx][sy] = boxes[z][x][y] + 1;
                totalTomato--;
//                System.out.println("현재 일 수 : "+boxes[sz][sx][sy]);
//                printArr();
//                System.out.println("남은 토마토 개수 : "+totalTomato);
                queue.offer(new int[]{sz, sx, sy});
                result = Math.max(boxes[z][x][y], result);
            }
        }
    }


    private static void printArr() {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    System.out.print(boxes[h][n][m]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }

}
