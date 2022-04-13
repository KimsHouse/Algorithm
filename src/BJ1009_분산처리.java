import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1009_분산처리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk;

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            tk = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(tk.nextToken());
            char[] b = tk.nextToken().toCharArray();

            int result = (int)Math.pow(a, b[b.length-1]-'0');
            String s = Integer.toString(result);

            //System.out.println(s);
            if(s.charAt(s.length()-1) == '0') System.out.println(10);
            else System.out.println(s.charAt(s.length()-1));
        }
    }
}
