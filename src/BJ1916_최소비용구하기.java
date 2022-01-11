import java.util.Arrays;
import java.util.Scanner;

public class BJ1916_최소비용구하기 {
    static int N, M, maxValue = 1000000000;
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

            if(map[x][y] > v) map[x][y] = v;

            //map[x][y] = v;
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
        dijk(start);
//        System.out.println(Arrays.toString(dist));

        System.out.println(dist[end]);
    }

    private static void dijk(int start) {

        for (int i = 1; i <= N; i++) {
            if(i == start) continue;
            dist[i] = maxValue;
        }
        //System.out.println(Arrays.toString(dist));
        //visited[start] = true;

        for (int i = 1; i <= N; i++) {
            int idx = getSmallIndex();

            for (int j = 1; j <= N; j++) {
                if(!visited[j] && map[idx][j] != 0){
                    if(dist[j] > dist[idx] + map[idx][j]){
                        dist[j] = dist[idx] + map[idx][j];
                        //System.out.println("dj : "+dist[j]);
                        //System.out.println("di : "+dist[idx]);
                    }
                }
            }

            visited[idx] = true;
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
