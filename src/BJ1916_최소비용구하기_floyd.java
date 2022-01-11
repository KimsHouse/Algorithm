import java.util.Scanner;

public class BJ1916_최소비용구하기_floyd {
    static int N, M, maxValue = 1000000000;
    static int[] dist;
    static int[][] map, copy;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N+1][N+1];
        copy = new int[N+1][N+1];
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

            if (map[x][y] < v) continue;

            map[x][y] = v;
            //map[y][x] = v;
        }

        int start = sc.nextInt();
        int end = sc.nextInt();


        //dijk(start, end);
        floyd();
                for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(copy[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println(copy[start][end]);
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
                    if(copy[i][k] + copy[k][j] < copy[i][j] && copy[i][j] != maxValue){
                        copy[i][j] = copy[i][k] + copy[k][j];
                    }
                }
            }
        }
//        for (int i = 1; i <= N; i++) {
//            for (int j = 1; j <= N; j++) {
//                System.out.print(copy[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

    }

//    private static void dijk(int start, int end) {
//
//        for (int i = 1; i <= N; i++) {
//            dist[i] = map[start][i];
//        }
//        //System.out.println(Arrays.toString(dist));
//        visited[start] = true;
//
//        for (int i = 1; i <= N; i++) {
//            int idx = getSmallIndex();
//            visited[idx] = true;
//            for (int j = 1; j <= N; j++) {
//                if(!visited[j]){
//                    if(dist[j] > dist[idx] + map[idx][j]){
//                        dist[j] = dist[idx] + map[idx][j];
//                        //System.out.println("dj : "+dist[j]);
//                        //System.out.println("di : "+dist[idx]);
//                    }
//                }
//            }
//        }
//
//        //System.out.println(Arrays.toString(dist));
//    }
//
//    private static int getSmallIndex() {
//        int min = maxValue;
//        int index = 0;
//        for (int i = 1; i <= N; i++) {
//            if(min > dist[i] && !visited[i]){
//                min = dist[i];
//                index = i;
//            }
//        }
//        return index;
//    }
}
