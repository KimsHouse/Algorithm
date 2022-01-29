import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ5212_지구온난화 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M;
    static char[][] map, copy;

    static boolean[][] visited;

    static Queue<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());

        map = new char[N][M];
        copy = new char[N][M];
        visited = new boolean[N][M];
        list = new LinkedList<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                map[i][j] = ch;
                copy[i][j] = ch;
                if(ch == 'X') list.add(new int[]{i, j});
            }

        }

        bfs();
        removeOutside();
        //System.out.println(Arrays.deepToString(map));
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(copy[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

    }

    private static void removeOutside() {
        int a = 11;
        int b = 11;
        int c = -1;
        int d = -1;

        for (int i = 0; i < N; i++) { // 왼쪽
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 'X') {
                    a = Math.min(a, i);
                }
            }
        }
        for (int i = 0; i < M; i++) { // 왼쪽
            for (int j = 0; j < N; j++) {
                if(copy[j][i] == 'X') {
                    b = Math.min(b, i);
                }
            }
        }
        for (int i = N-1; i >= 0; i--) { // 왼쪽
            for (int j = M-1; j >= 0; j--) {
                if(copy[i][j] == 'X') {
                    c = Math.max(c, i);
                }
            }
        }
        for (int i = M-1; i >= 0; i--) { // 왼쪽
            for (int j = N-1; j >= 0; j--) {
                if(copy[j][i] == 'X') {
                    d = Math.max(d, i);
                }
            }
        }
//        System.out.println(a+" "+b+" "+c+" "+d);
//        System.out.println();
        for (int i = a; i <= c; i++) {
            for (int j = b; j <= d; j++) {
                System.out.print(copy[i][j]);
            }
            System.out.println();
        }
        //System.out.println();

    }

    private static void bfs() {

        while(!list.isEmpty()){
            int[] rc = list.poll();
            int r = rc[0];
            int c = rc[1];
            visited[r][c] = true;

            int count = 0;
            for(int d = 0; d < 4; d++){
                int sx = dx[d] + r;
                int sy = dy[d] + c;


                if(sx < 0 || sx >= N || sy < 0 || sy >= M || map[sx][sy] == '.') {
                    //if(visited[sx][sy]) continue;
                    count++;
                }
                if(count >= 3) { // 3면이 바다이면
                    visited[r][c] = true;
                    copy[r][c] = '.';
                    break; // 다음 좌표로
                }
            }
        }

    }
}
