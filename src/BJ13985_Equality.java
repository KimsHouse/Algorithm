import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ13985_Equality {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int result = Integer.parseInt(str[0]) + Integer.parseInt(str[2]);

        if(result == Integer.parseInt(str[4])) System.out.println("YES");
        else System.out.println("NO");

    }
}
