import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11404_플로이드 {
    static int maxValue = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[][] map = new int[N+1][N+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(i == j) continue;
                map[i][j] = maxValue;
            }
        }

        for(int i = 0; i < M; i++){
            tk = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(tk.nextToken());
            int c = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());

            if(map[r][c] < d) continue;

            map[r][c] = d;
        }

        floyd(N, map);



    }
    private static void floyd(int N, int[][] map){
        int[][] stopover = new int[N+1][N+1];

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(map[i][k] + map[k][j] < map[i][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        stopover[i][j] = k;
                    }

                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(map[i][j] == maxValue) {
                    System.out.print(0+" ");
                    continue;
                }
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

    }

}
