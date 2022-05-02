import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14912_숫자빈도수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        tk = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(tk.nextToken());
        int n = Integer.parseInt(tk.nextToken());
        int count = 0;

        for (int i = 1; i <= N; i++) {
            char[] s = Integer.toString(i).toCharArray();

            for (int j = 0; j < s.length; j++) {
                if(s[j] == n+'0') count++;
            }
        }

        System.out.println(count);

    }
}
