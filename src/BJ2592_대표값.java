import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2592_대표값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] arr = new int[1001];
        int result = 0;
        int tmp = 0;
        arr[0] = -1;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            result += n;
            arr[n]++;
            if(arr[tmp] < arr[n]) tmp = n;
        }
        //System.out.println(result);
        System.out.println(result/10);
        System.out.println(tmp);
    }
}
