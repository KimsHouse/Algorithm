import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ18108_내가태국에서는2541년생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(N-543);
    }

}
