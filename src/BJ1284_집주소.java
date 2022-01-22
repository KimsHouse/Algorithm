import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1284_집주소 {
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("0")) break;
            char[] s = str.toCharArray();

            int result = 1;

            for (int i = 0; i < s.length; i++) {
                result += whatNumber(s[i]-'0') + 1;
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int whatNumber(int num) {
        int res = 0;

        switch (num){
            case 0:
                res = 4;
                break;
            case 1:
                res = 2;
                break;
            default:
                res = 3;
                break;
        }
        return res;

    }
}
