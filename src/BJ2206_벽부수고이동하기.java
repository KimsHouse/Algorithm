import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2206_벽부수고이동하기 {
    static class punch {
        int x;
        int y;
        int distance;
        boolean isPunch;

        public punch(int x, int y, int distance, boolean isPunch) {
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

        public boolean isPunch() {
            return isPunch;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M, count = 987654321;
    static int[][] map;
    static boolean[][][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        visited = new boolean[N][M][2];

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
        visited[r][c][0] = true;
        visited[r][c][1] = true;
        queue.offer(new punch(r, c, 1, true));
        while (!queue.isEmpty()){

            punch xy = queue.poll();
            int x = xy.getX();
            int y = xy.getY();
            int dis = xy.getDistance();
            //int[][] copyMap = xy.getCopyMap();
            //int[][] visited = xy.getVisited();

            if (x == N-1 && y == M-1){
                if(count > dis) count = dis;
                //----체크----
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(visited[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(copyMap[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                //----체크-----
                return;
            }
            //visited[x][y] = true;
//            boolean[][] cVisit = new boolean[N][M];
//
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    cVisit[i][j] = visited[i][j];
//                    //cMap[i][j] = copyMap[i][j];
//                }
//            }

            for (int d = 0; d < 4; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];

                if (sx < 0 || sx >= N || sy < 0 || sy >= M) continue;
                boolean p = xy.isPunch();

//                System.out.println("현위치 : "+x+" "+y);
//                System.out.println("현재 sx sy : "+sx+" "+sy);
//                System.out.println("펀치 여부 : "+p);
//                System.out.println();
                //----체크-----

                if (map[sx][sy] == 1) { // 가려는 곳이 벽일 때
                    if(p && !visited[sx][sy][1]){  // 부술 수 있으면
                        //cVisit[sx][sy] = true; // 방문처리
                       // queue.offer(new punch(x, y, dis, cMap, true, cVisit)); // 방문처리만 하고 다시 출발 //
                        //.out.println("두루와");
                        //cMap[sx][sy] = 0; // 벽부수고
                        visited[sx][sy][1] = true;
                        queue.offer(new punch(sx, sy, dis+1, false));
                    }
                } else if (map[sx][sy] == 0) { // 벽이 아니면
                    //cVisit[sx][sy] = true;
                    if(p && !visited[sx][sy][1]) {
                        visited[sx][sy][1] = true;
                        queue.offer(new punch(sx, sy, dis+1, true));
                    } else if (!p && !visited[sx][sy][0]){
                        visited[sx][sy][0] = true;
                        queue.offer(new punch(sx, sy, dis+1, false));
                    }

                }
            }
        }
    }

}
