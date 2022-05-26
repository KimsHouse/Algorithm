import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5586_JOI와IOI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int joi = 0;
        int ioi = 0;

        for (int i = 0; i < str.length(); i++) {
            if((i+2) >= str.length()) break;
            if(str.charAt(i) == 'J' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') joi++;
            if(str.charAt(i) == 'I' && str.charAt(i+1) == 'O' && str.charAt(i+2) == 'I') ioi++;
        }
        System.out.println(joi);
        System.out.println(ioi);
    }
}
