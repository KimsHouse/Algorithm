import java.util.*;

public class BJ11780_플로이드2 {
    static int N, M, maxValue = 987654321;
    static int[][] map, copy, stopover;
    static boolean[][] visit;
    static Queue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        copy = new int[N+1][N+1];
        stopover = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                map[i][j] = maxValue;
            }
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int v = sc.nextInt();

            if(map[x][y] != maxValue) {
                if(map[x][y] < v) continue;
            }
            map[x][y] = v;
            //copy[x][y] = v;
        }

        floyd();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (copy[i][j] == 0) {
                    System.out.println(0);
                    continue;
                }
                queue = new LinkedList<>();
                visit = new boolean[N + 1][N + 1];
                queue.offer(i);
                //System.out.print(i+" ");
                stopCheck(i, j);
                //System.out.println(j+" ");
                queue.offer(j);

                int size = queue.size();
                System.out.print(size + " ");
                for (int k = 0; k < size; k++) {
                    System.out.print(queue.poll() + " ");
                }
                System.out.println();
            }
        }
    }

    private static void floyd() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                copy[i][j] = map[i][j];
            }
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(copy[i][k] + copy[k][j] < copy[i][j]){
                        //.out.println("curr : "+copy[i][j]);
                        copy[i][j] = copy[i][k] + copy[k][j];
                        stopover[i][j] = k; // 경유지 넣기
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(copy[i][j] == maxValue) copy[i][j] = 0;
                if(N == 1) {
                    System.out.print(0);
                    break;
                }
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int stopCheck(int r, int c) {
        if(stopover[r][c] != 0) {
            int s = stopover[r][c];
            stopCheck(r, s);
            queue.add(s);
            stopCheck(s, c);

            return s;
        }
        return 0;
    }
}
