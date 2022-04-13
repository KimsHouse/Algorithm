package skcote;

public class test2 {


    public static void main(String[] args) {

        tornado(5, true);
        tornado(6, false);
        tornado(9, false);


    }

    private static int[][] tornado(int N, boolean clockwise) {
        int[][] answer = new int[N+1][N+1];

        if(clockwise){
            int halfn = N/2+1;
            answer = time(1, 1, answer, N, 1);
            answer = time(1, N, answer, N, 2);
            answer = time(N, N, answer, N, 3);
            answer = time(N, 1, answer, N, 4);

        } else {
            answer = rtime(answer, N);
        }

        return answer;

    }

    private static int[][] time(int x, int y, int[][] answer, int N, int start){
        int turn = N-1;
        int nextTurn = N-1;
        int num = 1;
        int cnt = 1;
        while (turn >= 1) {

            if(x < 1 || x > N || y < 1 || y > N) break;
            answer[x][y] = cnt++;
            System.out.println(x+" "+y);


            if(start == 1) {
                y++;
            } else if(start == 2) {
                x++;
            } else if(start == 3) {
                y--;
            } else if(start == 4) {
                x--;
            }

            if(--turn == 0) {
                turn = nextTurn--;
                //nextTurn += num;
                //num++;
                start++;
                if(start > 4) start = 1;
            }


            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    System.out.print(answer[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();

        }


        return answer;
    }

    private static int[][] rtime(int[][] answer, int N){

        return answer;
    }

//    private static int[][] time(int[][] answer, int n) {
//
//        for (int i = 1; i < n; i++) {
//            answer[1][i] = i;
//            answer[i][n] = i;
//            answer[n][n-i+1] = i;
//            answer[n-i+1][1] = i;
//        }
//
//        int halfn = n / 2;
//
//        for (int i = n, j = 1; i < n+halfn; i++, j++) {
//            answer[j+1][n-1] = i;
//            answer[n-1][n-j] = i;
//            answer[n-j][2] = i;
//            answer[2][j+1] = i;
//        }
//
//        answer[halfn+1][halfn+1] = n+n-1;
//
//        return answer;
//    }
//
//    private static int[][] rtime(int[][] answer, int n){
//
//        for (int i = n, j = 1; i > 1; i--, j++) {
//            answer[1][i] = j;
//            answer[i][n] = j;
//            answer[n][n-i+1] = j;
//            answer[n-i+1][1] = j;
//        }
//
////        int halfn = n / 2;
////
////        for (int i = 1, j = 1; i < n+halfn; i++, j++) {
////            answer[j+1][n-1] = i;
////            answer[n-1][n-j] = i;
////            answer[n-j][2] = i;
////            answer[2][j+1] = i;
////        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print(answer[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        return answer;
//    }


}
