import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ7568_덩치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for(int n = 0; n < N; n++){
            tk = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(tk.nextToken());
            int b = Integer.parseInt(tk.nextToken());

            arr[n][0] = a;
            arr[n][1] = b;
            arr[n][2] = 1;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) arr[i][2]++;
            }

            System.out.print(arr[i][2]+" ");
        }


    }
}
