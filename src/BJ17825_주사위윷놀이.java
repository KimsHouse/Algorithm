import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17825_주사위윷놀이 {
    static int[][] board = {
            {-1, 0, 0, 0, 0},
            {2, 0, 0, 0, -2, 0, 0, 0, 38},
            {4, 0, 0, 0, 40, 0, 0, 0, 36},
            {6, 0, 0, 0, 35, 0, 0, 0, 34},
            {8, 0, 0, 0, 30, 0, 0, 0, 32},
            {10, 13, 16, 19, 25, 26, 27, 28, 30},
            {12, 0, 0, 0, 24, 0, 0, 0, 28},
            {14, 0, 0, 0, 22, 0, 0, 0, 26},
            {16, 0, 0, 0, 20, 0, 0, 0, 24},
            {18, 0, 0, 0, 0, 0, 0, 0, 22}
    };

    static int[][] horse = {
            {0, 0, 0},
            {1, 0, 0},
            {2, 0, 0},
            {3, 0, 0},
            {4, 0, 0}
    }; // 말

    static int[][] map;

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int[] arr = new int[10];
        map = new int[6][5];
        tk = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < 10; i++) {
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        pickHorse(0, arr, new int[10]);

    }

    private static void pickHorse(int cnt, int[] arr, int[] selected) {
        if(cnt == 10){
            //System.out.println("cnt : "+cnt);
            System.out.println(Arrays.toString(selected));
            int sum = 0;
            for (int i = 0; i < selected.length; i++) {
                sum += moveHorse(selected[i], arr[i], 0);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            selected[cnt] = i+1;
            pickHorse(cnt+1, arr, selected);
        }
    }

    private static int moveHorse(int h, int dis, int sum) {
        if(dis == 0) return 0;
        int stamp = horse[h][0];
        int x = horse[h][1];
        int y = horse[h][2];

        if(x < 5 && y == 0) x+=dis; // s,2,4,6,8
        else if(x == 5 && y < 4 ) y+= dis;
//        else if()


        return 0;
    }
}
