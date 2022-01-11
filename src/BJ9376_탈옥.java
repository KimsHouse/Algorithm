import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ9376_탈옥 {
    static class prisoner {
        int x;
        int y;
        int cWall;
        int pair;

        public prisoner(int x, int y, int cWall, int pair) {
            this.x = x;
            this.y = y;
            this.cWall = cWall;
            this.pair = pair;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int T, H, W, D, result;

    static char[][] map;

    static boolean[][][][] visited;

    static Queue<prisoner> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            tk = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(tk.nextToken());
            W = Integer.parseInt(tk.nextToken());
            map = new char[H][W];
            queue = new LinkedList<>();
            for (int h = 0; h < H; h++) { // 높이
                tk = new StringTokenizer(br.readLine());
                String str = tk.nextToken();
                for (int w = 0; w < W; w++) { // 너비
                    map[h][w] = str.charAt(w);
                    if(map[h][w] == '#') D++; // 벽의 개수 세기
                    if(map[h][w] == '$') queue.offer(new prisoner(h, w, 0, 0)); // 죄수 좌표 넣기
                }
            }

            visited = new boolean[2][D+1][H][W]; // 문의 여/닫힘 여부에 따라 방문체크
            result = 0;
            //for (int i = 0; i < 2; i++) { // 죄수는 두명이므로 두 번만
                prisoner p = queue.poll();
                map[p.x][p.y] = '.'; // 본인을 탐색하면 안되므로
                prisonBreak(p.x, p.y, p.cWall);
            System.out.println();
                for (int j = 0; j < H; j++) {
                    for (int k = 0; k < W; k++) {
                        if(visited[1][result][j][k]) System.out.print(1+" ");
                        else System.out.print(0+" ");

                    }
                    System.out.println();
                }
                System.out.println();
                //removeWall(i);
                System.out.println(result);
            //}



            // 테스트용-----------------------------------------
//            for (int i = 0; i < H; i++) {
//                for (int j = 0; j < W; j++) {
//                    System.out.print(map[i][j]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//
//            System.out.println(D);
        }
    }

//    private static void removeWall(int chk) {
//        if(chk == 1) return;
//        for (int i = 0; i < H; i++) {
//            for (int j = 0; j < W; j++) {
//                if(visited[result][i][j]) map[i][j] = '.';
//            }
//        }
//    }

    private static void prisonBreak(int r, int c, int w) {
        PriorityQueue<prisoner> q = new PriorityQueue<>((a, b) -> (a.cWall-b.cWall));
        q.offer(new prisoner(r, c, w, 0));
        // 죄수는 무조건 두 명이므로 초기 작업을 생략략

       while(!q.isEmpty()) {
            prisoner xy = q.poll();
            int x = xy.x;
            int y = xy.y;
            int open = xy.cWall;
            int p = xy.pair;

           if(open > D) return;
           visited[p][open][x][y] = true;

           for (int d = 0; d < 4; d++) { // 상하좌우
               int sx = x + dx[d];
               int sy = y + dy[d];



               if(sx < 0 || sx >= H || sy < 0 || sy >= W) { // 탈출 조건
                   if (p == 0) continue;
                   //if(result > open) result = open;
                   //continue;
                   result += open;
                   return;
                   //continue;
               }

               if(visited[p][open][sx][sy] || map[sx][sy] == '*') continue; // 방문 체크

               if(map[sx][sy] == '$') {
                   q.offer(new prisoner(sx, sy, open, 1));

               }

               else if(map[sx][sy] == '#') {
                   q.offer(new prisoner(sx, sy, open+1, p));
                   //visited[p][open][sx][sy] = true;
               }
               else if(map[sx][sy] == '.'){
                   q.offer(new prisoner(sx, sy, open, p));
                   //visited[p][open][sx][sy] = true;
               }
           }
        }

    }
}
