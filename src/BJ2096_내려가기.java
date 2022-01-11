import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2096_내려가기 {
    static int[] dx = {-1, -1, -1};
    static int[] dy = {-1, 0, 1};

    static int minValue = 987654321;
    static int maxValue = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][3];
        int[][] copy = new int[N][3];

        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                if(i < 1) {
                    int val = Integer.parseInt(tk.nextToken());
                    map[i][j] = val;
                    copy[i][j] = val;
                }
                else {
                    int val = Integer.parseInt(tk.nextToken());
                    map[i][j] = preMaxIndexCheck(i, j, map, val);
                    copy[i][j] = preMinIndexCheck(i, j, copy, val);
                }
                //if(i < 2) copy[i][j] = map[i][j]; // 최초값 초기화
            }
            //System.out.println(Arrays.deepToString(map));
        }

        //System.out.println(Arrays.deepToString(map));
        //System.out.println(Arrays.deepToString(copy));
        for(int i = 0; i < 3; i++){
            minValue = Math.min(minValue, copy[N-1][i]);
            maxValue = Math.max(maxValue, map[N-1][i]);
        }


        System.out.println(maxValue+" "+minValue);
    }

    private static int preMaxIndexCheck(int r, int c, int[][]map, int key){
        int res = -1;
        for (int d = 0; d < 3; d++) {
            int sx = r + dx[d];
            int sy = c + dy[d];

            if(sy < 0 || sy >= 3) continue;

            res = Math.max(key + map[sx][sy], res);

        }
        return res;
    }

    private static int preMinIndexCheck(int r, int c, int[][]copy, int key){
        int res = 987654321;
        for (int d = 0; d < 3; d++) {
            int sx = r + dx[d];
            int sy = c + dy[d];

            if(sy < 0 || sy >= 3) continue;
            res = Math.min(key + copy[sx][sy], res);

        }
        return res;
    }
}
