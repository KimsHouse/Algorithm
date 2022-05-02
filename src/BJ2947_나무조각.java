import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2947_나무조각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int[] arr = new int[5];

        tk = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(tk.nextToken());
        }

        loop:
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if(arr[j-1] > arr[j]){
                    int tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;

                boolean chk = false;
                for (int k = 0; k < arr.length; k++) {

                    if(arr[k] != k+1) chk = true;
                    System.out.print(arr[k]+" ");
                }
                if(!chk) break loop;
                System.out.println();
                }

            }
        }
    }
}
