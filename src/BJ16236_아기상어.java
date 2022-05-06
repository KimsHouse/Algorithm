import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ16236_아기상어 {

    static int[] dx = {-1, 0, 0, 1}; // 상좌우하
    static int[] dy = {0, -1, 1, 0};

    static int N, distance = 0;

    static int[][] map, board;
    static boolean[][] visit;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        board = new int[N][N];


        int[] sharkXY = new int[2];
        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++){

                int n = Integer.parseInt(tk.nextToken());
                if(n == 9){
                    sharkXY[0] = i;
                    sharkXY[1] = j;
                    continue;
                }
                map[i][j] = n;
            }
        }

        int size = 2; // 초기 상어 크기
        int exp = 0; // 먹은 물고기 수


        Queue<int[]> queue = new LinkedList<>();
        int r = sharkXY[0];
        int c = sharkXY[1];
        visit = new boolean[N][N];
        queue.offer(new int[] {r, c, 0});
        visit[r][c] = true;

        while(true){
            List<int[]> fish = new ArrayList<>();
            board = new int[N][N];

            while(!queue.isEmpty()){
                int[] xy = queue.poll();
                int x = xy[0];
                int y = xy[1];
                int dis = xy[2];

                for(int d = 0; d < 4; d++){
                    int sx = x + dx[d];
                    int sy = y + dy[d];

                    if(sx < 0 || sx >= N || sy < 0 || sy >= N || board[sx][sy] != 0 || map[sx][sy] > size) continue;
//
//                    if(board[sx][sy] != 0){
//                    if(sx >= 0 && sy >= 0 && sx < N && sy < N && board[sx][sy]==0 && map[sx][sy] <= size){
                        board[sx][sy] = board[x][y] + 1;
                        queue.offer(new int[]{sx, sy, board[sx][sy]});
                        //
                        //printArr(board);
                        if (1 <= map[sx][sy] && map[sx][sy] <= 6 && map[sx][sy] < size)
                            fish.add(new int[]{sx, sy, board[sx][sy]});


                }
            }

            if(fish.size() == 0) {
                System.out.println(distance);
                return;
            }

            int[] fishXY = fish.get(0);

            for(int i = 1; i < fish.size(); i++){
                int fx = fishXY[0];
                int fy = fishXY[1];
                int fdis = fishXY[2];

                if(fdis > fish.get(i)[2]) {
                    fishXY = fish.get(i);
                } else if(fdis == fish.get(i)[2]) {
                    if(fx > fish.get(i)[0]) fishXY = fish.get(i);
                    else if(fx == fish.get(i)[0]){
                        if(fy > fish.get(i)[1]) fishXY = fish.get(i);
                    }
                }
            }

            distance += fishXY[2];
            r = fishXY[0];
            c = fishXY[1];
            exp++;

            if(exp == size){
                size++;
                exp = 0;
            }
            map[r][c] = 0;
            queue.offer(new int[] {r, c, 0});
            //visit = new boolean[N][N];

            //visit[r][c] = true;
            //board[r][c] = distance;

        }
    }

    private static void printArr(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
