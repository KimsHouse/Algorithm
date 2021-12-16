import java.util.*;

public class BJ4963_섬의개수 {
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int N, M, count;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            M = sc.nextInt();
            N = sc.nextInt();
            if(N == 0 || M == 0) break;

            map = new int[N][M];
            visited = new boolean[N][M];
            list = new ArrayList<>();
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int s = sc.nextInt();
                    map[i][j] = s;
                    if(s == 1) list.add(new int[]{i, j});
                }
            }

            for (int i = 0; i < list.size(); i++) {

                int r = list.get(i)[0];
                int c = list.get(i)[1];
                if (visited[r][c]) continue;
                BFS(r, c);
                count++;
            }
            //System.out.println(Arrays.deepToString(map));
            System.out.println(count);
        }
    }

    private static void BFS(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int d = 0; d < 8; d++) {
                int sx = x + dx[d];
                int sy = y + dy[d];
//                for (int i = 0; i < N; i++) {
//                    for (int j = 0; j < M; j++) {
//                        System.out.print(visited[i][j]+" ");
//                    }
//                    System.out.println();
//                }
//                System.out.println();
                if(sx < 0 || sx >= N || sy < 0 || sy >= M || visited[sx][sy] || map[sx][sy] == 0) continue;

                visited[sx][sy] = true;
                queue.offer(new int[]{sx, sy});

            }
        }
    }
}
