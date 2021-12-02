import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ1926_그림 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, count, max;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j] || map[i][j] == 0) continue;

                BFS(i, j);
            }
        }
        System.out.println(count);
        System.out.println(max);
        //System.out.println(Arrays.deepToString(map));

    }

    private static void BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        count++;
        int size = 1;
        while (!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 0 || sx >= N || sy < 0 || sy >= M || visited[sx][sy] || map[sx][sy] == 0) continue;
                visited[sx][sy] = true;
                size++;
                queue.offer(new int[]{sx, sy});
            }

        }
        if(size > max) max = size;
    }
}
