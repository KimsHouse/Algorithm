import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ14442_벽부수고이동하기2 {
    static class punch {
        int x;
        int y;
        int distance;
        int isPunch;

        public punch(int x, int y, int distance, int isPunch) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.isPunch = isPunch;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

        public int getIsPunch() {
            return isPunch;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M, P, count = 987654321;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        P = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M][P+1];

        for (int n = 0; n < N; n++) {
            String str = sc.next();
            for (int m = 0; m < M; m++) {
                map[n][m] = str.charAt(m)-'0';
            }
        }

        //long before = System.currentTimeMillis();
        crashWall(0, 0);
        //long after = System.currentTimeMillis();
        //System.out.println((after-before)+"(ms)");
        if(count == 987654321) System.out.println(-1);
        else System.out.println(count);
        //System.out.println(Arrays.deepToString(map));
    }

    private static void crashWall(int r, int c) {
        Queue<punch> queue = new LinkedList<>();
        for (int i = 0; i < P; i++) {
            visited[0][0][i] = true;
        }
        queue.offer(new punch(r, c, 1, P));
        while (!queue.isEmpty()){

            punch xy = queue.poll();
            int x = xy.getX();
            int y = xy.getY();
            int dis = xy.getDistance();

            if (x == N-1 && y == M-1){
                if(count > dis) count = dis;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if (sx < 0 || sx >= N || sy < 0 || sy >= M) continue;
                int p = xy.getIsPunch();

//                System.out.println("현위치 : "+x+" "+y);
//                System.out.println("현재 sx sy : "+sx+" "+sy);
//                System.out.println("펀치 여부 : "+p);
//                System.out.println();
                //----체크-----

                if (map[sx][sy] == 1) { // 가려는 곳이 벽일 때
                    if(p != 0 && !visited[sx][sy][p]){  // 부술 수 있으면
                        //cVisit[sx][sy] = true; // 방문처리
                        // queue.offer(new punch(x, y, dis, cMap, true, cVisit)); // 방문처리만 하고 다시 출발 //
                        //.out.println("두루와");
                        //cMap[sx][sy] = 0; // 벽부수고
                        visited[sx][sy][p] = true;
                        queue.offer(new punch(sx, sy, dis+1, p-1));
                    }
                } else if (map[sx][sy] == 0) { // 벽이 아니면
                    //cVisit[sx][sy] = true;
                    if(p != 0 && !visited[sx][sy][p]) {
                        visited[sx][sy][p] = true;
                        queue.offer(new punch(sx, sy, dis+1, p));
                    } else if (p == 0 && !visited[sx][sy][p]){
                        visited[sx][sy][p] = true;
                        queue.offer(new punch(sx, sy, dis+1, p));
                    }

                }
            }
        }
    }

}
