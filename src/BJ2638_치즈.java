import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2638_치즈 {
    static class piece{
        int x;
        int y;
        int count;

        public piece(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static int cheese[][], copy[][];
    static Queue<piece> queue;
    static int max;
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        cheese = new int[N][M];
        copy = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int c = sc.nextInt();
                //cheese[i][j] = c;
                copy[i][j] = c;
                if(c == 1) queue.offer(new piece(i, j, 1));
            }
        }

        meltCheese();
        System.out.println(max);
    }

    private static void meltCheese() {
        while (!queue.isEmpty()){

            piece xy = queue.poll();
            int x = xy.getX();
            int y = xy.getY();
            int cnt = xy.getCount();

            if(max < cnt){
                //System.out.println("바꼈어 "+cnt);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        cheese[i][j] = copy[i][j];
                    }
                }
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(cheese[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                visit = new boolean[N][M];
                visit = bfs(0, 0);
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(visit[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                max = cnt;
            }

            int dCnt = 0;

            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 0 || sx >= N || sy < 0 || sy >= M || !visit[sx][sy] || cheese[sx][sy] == 1) continue;
                dCnt++;
            }
            if(dCnt >= 2) {
                //System.out.println("현위치 "+x+" "+y);
                //System.out.println("검사위치 "+sx+" "+sy);
                copy[x][y] = 0;
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(copy[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
            } else {
                queue.offer(new piece(x, y, cnt + 1));
            }
        }
    }

    private static boolean[][] bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        boolean[][] visited = new boolean[N][M];
        while(!q.isEmpty()){
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];

            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 0 || sx >= N || sy < 0 || sy >= M || visited[sx][sy] || cheese[sx][sy] == 1) continue;
                visited[sx][sy] = true;
                q.offer(new int[]{sx, sy});
            }

        }

        return visited;
    }

}
