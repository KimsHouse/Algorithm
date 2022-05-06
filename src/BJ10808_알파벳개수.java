import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10808_알파벳개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        int[] alpha = new int[27];

        for (int i = 0; i < str.length; i++) {
            int idx = str[i] - 'a';
            alpha[idx]++;
        }

        for (int i = 0; i < alpha.length-1; i++) {
            System.out.print(alpha[i]+" ");
        }

    }
}
