import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1913_달팽이 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int a, b, N, turn = 1, turnchk;
    static int[][] snail;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int xy = Integer.parseInt(br.readLine());

        snail = new int[N][N];
        int halfN = N / 2;

        rotateArr(halfN, halfN, xy, 1, 0, 0);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(snail[i][j]+" ");
            }
            sb.append("\n");
        }
        sb.append(a+1).append(" ").append(b+1);
        System.out.println(sb);

    }

    private static void rotateArr(int r, int c, int loc, int num, int dir, int chk) {

        if(loc == num) {
            a = r;
            b = c;
        }

        snail[r][c] = num;

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(snail[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        if(r == 0 && c == 0) return;

        if(chk == turn) {
            chk = 0;
            turnchk++;
            dir++;
            if(turnchk == 2) {
                turn++;
                turnchk = 0;
            }
            if(dir == 4) dir = 0;
        }

        int sx = r + dx[dir];
        int sy = c + dy[dir];

        //System.out.println(sx+" "+sy);

        rotateArr(sx, sy, loc, num+1, dir, chk+1);


    }
}
