import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20058_마법사상어와파어이스톰 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, Q, L;
    static int maxWid = 0;
    static int[][] map, copy;

    static boolean[][] visited;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken()); // 2의 n제곱
        Q = Integer.parseInt(tk.nextToken()); // 파이어 스톰 시전 횟수

        N = (int)Math.pow(2, N); // N을 2의 N제곱으로 바꾸기
        map = new int[N][N];
        copy = new int[N][N];

        for (int i = 0; i < N; i++) { // input
            tk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(tk.nextToken());
                map[i][j] = v;
                copy[i][j] = v;
            }
        }

        tk = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++) {
            L = Integer.parseInt(tk.nextToken()); // 파이어스톰 시전단계
            fireStorm(L);
        }

        int sum = 0;
        int width = 0;
        visited = new boolean[N][N];
        sum = sumMap();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j]) continue;
                width = findArea(i, j);
                maxWid = Math.max(width, maxWid);
            }
        }

        System.out.println(sum);
        System.out.println(maxWid);

    }

    private static int findArea(int r, int c) {
        int area = 0;
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});

        while(!queue.isEmpty()){
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            for (int d = 0; d < 4; d++) {
                int sx = dx[d] + x;
                int sy = dy[d] + y;

                if(sx < 0 || sx >= N || sy < 0 || sy >= N || visit[sx][sy] || map[sx][sy]==0) continue;
                area++;
                visit[sx][sy] = true;
                queue.offer(new int[]{sx, sy});
            }
        }
        return area;
    }

    private static int sumMap() {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 0) visited[i][j] = true;
                sum += map[i][j];
            }
        }

        return sum;
    }

    private static void fireStorm(int l) {
        int n = (int)Math.pow(2, l);

        for (int i = 1; i <= N; i += n) {
            for (int j = 1; j <= N; j += n) {
                rotateArr(i - 1, i + n - 1, j - 1, j + n - 1, n); // 범위만큼 배열 돌리기
            }
        }

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0){
                    iceMelting(i, j); // 현 위치에서 인접한 얼음이 3개이상 없으면 녹는다
                }
            }
        }
        initAfterMelting();
    }

    private static void initAfterMelting() {
        for (int i = 0; i < list.size(); i++) {
            int[] xy = list.get(i);
            map[xy[0]][xy[1]]--;
        }
    }
    private static void iceMelting(int r, int c) {
        int chk = 0;
        for (int d = 0; d < 4; d++) {
            int sx = dx[d] + r;
            int sy = dy[d] + c;

            if(sx < 0 || sx >= N || sy < 0 || sy >= N || map[sx][sy] == 0) continue;
            chk++;
        }
        if(chk < 3) list.add(new int[]{r, c});
    }

    private static void rotateArr(int rs, int re, int cs, int ce, int n){
        int[][] cont = new int[n][n];
        int[][] cont2 = new int[n][n];

        for (int i = rs, ii = 0; i < re; i++, ii++) {
           // System.out.println("-----");
            for (int j = cs, jj = 0; j < ce; j++, jj++) {
                //System.out.println(i+" "+j);
                //System.out.println(i+" "+j+" -> "+j+" "+(re-1-i));
                //copy[j][re-1-i] = map[i][j];
                cont[ii][jj] = map[i][j];
                //System.out.print(copy[i][j]+" ");
            }
            //System.out.println();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cont2[j][n-i-1] = cont[i][j];
            }
        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(cont2[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        //System.out.println("---map이염---");
        for (int i = rs, ii = 0; i < re; i++, ii++) {
            // System.out.println("-----");
            for (int j = cs, jj = 0; j < ce; j++, jj++) {
                //System.out.println(i+" "+j);
                //System.out.println(i+" "+j+" -> "+j+" "+(re-1-i));
                //copy[j][re-1-i] = map[i][j];
                 map[i][j] = cont2[ii][jj];
                //System.out.print(map[i][j]+" ");
            }
            //System.out.println();
        }
        //System.out.println();

    }
}
