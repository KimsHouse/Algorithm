import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ16948_데스나이트 {
    static class knight {
        int x;
        int y;
        int count;
        boolean[][] visited;

        public knight(int x, int y, int count, boolean[][] visited) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.visited = visited;
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

        public boolean[][] getVisited() {
            return visited;
        }
    }


    static int[] dx = {-2, -2, 0, 0, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -1, 1};

    static int N, nextX, nextY; // 체스판 크기
    static int min = 987654321;
    static int chess[][];
    static boolean visited[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        chess = new int[N][N];
        visited = new boolean[N][N];

        int currx = sc.nextInt();
        int curry = sc.nextInt();
        nextX = sc.nextInt();
        nextY = sc.nextInt();

        chess[currx][curry] = 1; // 체스말
        chess[nextX][nextY] = 2; // 도착지
        visited[currx][curry] = true;
        BFS(currx, curry, 1);

        if(min == 987654321) System.out.println(-1);
        else System.out.println(min);


    }

    private static void BFS(int r, int c, int count) {
        Queue<knight> queue = new LinkedList<>();
        queue.offer(new knight(r, c, count, visited));
        //visited[r][c] = true;
        while (!queue.isEmpty()){
            knight xy = queue.poll();
            int x = xy.getX();
            int y = xy.getY();
            int cnt = xy.count;
            boolean[][] visit = xy.getVisited();

            for (int d = 0; d < 6; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if(sx < 0 || sx >= N || sy < 0 || sy >= N || visit[sx][sy]) continue;
                if(chess[sx][sy] == 2) {
                    if(min > cnt) min = cnt;
                    break;
                }

                visit[sx][sy] = true;
                queue.offer(new knight(sx, sy, cnt+1, visit));

            }


        }
    }

}
