import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ1212_8진수2진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int res = 0;

        String[] feight = {"0", "1", "10", "11", "100", "101", "110", "111"};
        String[] eight = {"000", "001", "010", "011", "100", "101", "110", "111"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N.length(); i++) {
            int idx = N.charAt(i)-'0';
            if(i == 0) sb.append(feight[idx]);
            else sb.append(eight[idx]);
        }

        System.out.println(sb);
    }
}
