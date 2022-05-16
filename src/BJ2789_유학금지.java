import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2789_유학금지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String CAMBRIDGE = "CAMBRIDGE";

        String[] str = br.readLine().split("");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; i++) {
            if(!CAMBRIDGE.contains(str[i])) sb.append(str[i]);
        }

        System.out.println(sb);
    }
}
