import java.util.*;

public class solution {
    static class junu{
        int x;
        int y;
        boolean isVisit;
        boolean[][] visited;
        int dis;

        public junu(int x, int y, boolean isVisit, boolean[][] visited, int dis) {
            this.x = x;
            this.y = y;
            this.isVisit = isVisit;
            this.visited = visited;
            this.dis = dis;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isVisit() {
            return isVisit;
        }

        public boolean[][] getVisited() {
            return visited;
        }

        public int getDis() {
            return dis;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M, count;
    static char[][] map;
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        map = new char[M][N];

        long before = System.currentTimeMillis();

        for (int i = 0; i < M; i++) {
            sc.nextLine();
            String str = sc.next();
            map[i] = str.toCharArray();
        }

        bfs();
        //System.out.println(Arrays.deepToString(map));
        //System.out.println(count);
        Collections.sort(list, (o1, o2) -> o1-o2);
        int result = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(result == list.get(i)) count++;
            else break;
        }
        //System.out.println(list.toString());
        System.out.println(count);
        //long after = System.currentTimeMillis();
        //long diff = after-before;
        //System.out.println(diff+"(ms)");
    }

    private static void bfs() {
        Queue<junu> queue = new LinkedList<>();
        boolean[][] v = new boolean[M][N];
        v[0][0] = true;
        queue.offer(new junu(0, 0, false, v, 1));

        while (!queue.isEmpty()){
            junu xy = queue.poll();
            int x = xy.getX();
            int y = xy.getY();

            for (int d = 0; d < 4; d++) {
                boolean isVisit = xy.isVisit();
                boolean[][] visited = new boolean[M][N];

                for (int i = 0; i < M; i++) {
                    for (int j = 0; j < N; j++) {
                        visited[i][j] = xy.getVisited()[i][j];
                    }
                }
                int dis = xy.getDis();
                int sx = x + dx[d];
                int sy = y + dy[d];

                if (sx < 0 || sx >= M || sy < 0 || sy >= N || visited[sx][sy] || map[sx][sy] == 'X') continue;
//                for (int i = 0; i < M; i++) {
//                    for (int j = 0; j < N; j++) {
//                        System.out.print(visited[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();

                if(map[sx][sy] == 'H') { // 도착했으면
                    if(isVisit) list.add(dis);
                }

                if(map[sx][sy] == 'A') isVisit = true; // 학원 들렸으면

                visited[sx][sy] = true;
                queue.offer(new junu(sx, sy, isVisit, visited, dis+1));

            }

        }
    }
}
