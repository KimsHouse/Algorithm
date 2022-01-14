package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class segmenttree_matrix {
    static int[][] matrix = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    };

    static int[][] prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        prefixSum = new int[N+1][M+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                prefixSum[i+1][j+1] = prefixSum[i+1][j]
                                    + prefixSum[i][j+1]
                                    - prefixSum[i][j]
                                    + matrix[i][j];
                System.out.print(prefixSum[i+1][j+1]+" ");
            }
            System.out.println();
        }

        System.out.println(sumRegion(1, 1, 3, 3));
    }

    private static int sumRegion(int r1, int c1, int r2, int c2) {
        return prefixSum[r2+1][c2+1]
             - prefixSum[r2+1][c1]
             - prefixSum[r1][c2+1]
             + prefixSum[r1][c2];
    }
}
