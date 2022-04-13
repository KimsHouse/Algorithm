import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ1032_명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String command = br.readLine();

        for(int i = 0; i < N-1; i++) {
            String compare = br.readLine();

            command = compStr(command, compare);
        }

        System.out.println(command);
    }

    private static String compStr(String cmd, String cmp) {
        char[] cmd1 = cmd.toCharArray();
        char[] cmp1 = cmp.toCharArray();


        //System.out.println(Arrays.toString(cmd1));

        for (int i = 0; i < cmd1.length; i++) {
            if(cmd1[i] != cmp1[i]) cmd1[i] = '?';
        }


        return new String(cmd1);

    }
}
