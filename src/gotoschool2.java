import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class gotoschool2 {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int N, M, count;
    static char[][] map;
    static int[][] mapCopy1, mapCopy2;
    static List<Integer> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];

        int acA = 0;
        int acB = 0;

        long before = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'A') {
                    acA = i;
                    acB = j;
                }
            }
        }

        int fir = chkDis(0, 0, acA, acB);
        int sec = chkDis(acA, acB, N-1, M-1);
    }

    private static int chkDis(int sr, int sc, int ar, int ac) {
        int[][] mapCopy = new int[N][M];
        mapCopy[sr][sc] = 1;

        for (int i = sr; i < ar; i++) {
            for (int j = sc; j < ac; j++) {
                int a = 0;
                int b = 0;

                if(i == sr && j == sc) continue;

                if(i-1 < sr) a = 0;
                if(j-1 < sc) b = 0;
                System.out.println(i+" "+j);
                mapCopy[i][j] = a + b;
            }

            for (int k = 0; k < N; k++) {
                for (int l = 0; l < M; l++) {
                    System.out.print(mapCopy[k][l]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return mapCopy[ar][ac];
    }
}
