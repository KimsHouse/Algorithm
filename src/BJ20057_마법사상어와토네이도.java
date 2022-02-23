import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ20057_마법사상어와토네이도 {
    static int[] tx = {0, 1, 0, -1};
    static int[] ty = {-1, 0, 1, 0};

    static int[][] dustX = {
            {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
            {0, 1, 0, -1, 2, 1, 0, -1, 0, 1},
            {2, 1, 1, 1, 0, -1, -1, -1, -2, 0},
            {0, -1, 0, 1, -2, -1, 0, 1, 0, -1}
    };


    static int[][] dustY = {
            {0, -1, 0, 1, -2, -1, 0, 1, 0, -1},
            {-2, -1, -1, -1, 0, 1, 1, 1, 2, 0},
            {0, 1, 0, -1, 2, 1, 0, -1, 0, 1},
            {2, 1, 1, 1, 0, -1, -1, -1, -2, 0}
    };

    static int[] percent = {2, 10, 7, 1, 5, 10, 7, 1, 2, 0};

    static int N, R, C, cnt = 1, result;
    static int[][] map, copy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        copy = new int[N][N];
        R = N / 2;
        C = N / 2;

        for (int i = 0; i < N; i++) {
            tk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(tk.nextToken());
                map[i][j] = v;
            }
        }

        tornado();
        System.out.println(result);

    }

    private static void tornado() {
        int start = 0;

        while (R != 0 && C != 0) {
            go(++start, 0);
            go(start, 1);
            go(++start, 2);
            go(start, 3);
        }
        go(start, 0);


    }

    private static void go(int start, int dir) {

        for (int i = 0; i < start; i++) {
            //copy = new int[N][N];
            if (dir == 0) C--;
            else if (dir == 1) R++;
            else if (dir == 2) C++;
            else if (dir == 3) R--;

            //System.out.println("--"+R+" "+C+"--");
            //System.out.println((R != 0 && C != 0));
            if (R < 0 && C < 0) break;

            //System.out.println("왜안옴?");
            diffusion(R, C, dir);

            copy[R][C] = cnt++;

        }
    }

    private static void diffusion(int r, int c, int dir) {
        //System.out.println("----diffusion-----");
        int res = 0;
        for (int i = 0; i < 9; i++) {
            int sx = dustX[dir][i] + r;
            int sy = dustY[dir][i] + c;

            int maper = (map[r][c] * percent[i]) / 100;
            res += maper;
            if (sx < 0 || sx >= N || sy < 0 || sy >= N) {
                result += maper;
                continue;
            }
            map[sx][sy] += maper;
        }

        int fx = dustX[dir][9] + r;
        int fy = dustY[dir][9] + c;

        if (fx < 0 || fx >= N || fy < 0 || fy >= N) result += (map[r][c] - res);
        else map[fx][fy] += map[r][c] - res;

        map[r][c] = 0;
    }
}