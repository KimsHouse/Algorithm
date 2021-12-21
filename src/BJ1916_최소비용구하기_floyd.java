import java.util.Arrays;
import java.util.Scanner;

public class BJ1916_최소비용구하기 {
    static int N, M, maxValue = 987654321;
    static int[] dist;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

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

            map[x][y] = v;
            //map[y][x] = v;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        dijk(start, end);
        System.out.println(dist[end]);
    }

    private static void dijk(int start, int end) {

        for (int i = 1; i <= N; i++) {
            dist[i] = map[start][i];
        }
        //System.out.println(Arrays.toString(dist));
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            int idx = getSmallIndex();
            visited[idx] = true;
            for (int j = 1; j <= N; j++) {
                if(!visited[j]){
                    if(dist[j] > dist[idx] + map[idx][j]){
                        dist[j] = dist[idx] + map[idx][j];
                        //System.out.println("dj : "+dist[j]);
                        //System.out.println("di : "+dist[idx]);
                    }
                }
            }
        }

        //System.out.println(Arrays.toString(dist));
    }

    private static int getSmallIndex() {
        int min = maxValue;
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if(min > dist[i] && !visited[i]){
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}
