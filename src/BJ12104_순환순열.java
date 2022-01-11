import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ12104_순환순열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pr = br.readLine();
        String pt = br.readLine();

        char[] parent = new char[pr.length()*2];
        char[] pattern = new char[pt.length()];

        for (int i = 0; i < pr.length(); i++) {
            parent[i] = pr.charAt(i);
            parent[i+pr.length()] = pr.charAt(i);
            pattern[i] = pt.charAt(i);
        }

        kmp(parent, pattern);

        //System.out.println(Arrays.toString(parent));

    }

    private static void kmp(char[] parent, char[] pattern) {
        int[] arr = makeArr(pattern);
        int cnt = 0;
        //StringBuilder sb = new StringBuilder();

        //System.out.println("hi");
        for (int i = 0, j = 0; i < parent.length-1; i++) {
            while (j > 0 && parent[i] != pattern[j]) j = arr[j-1];

            if(parent[i] == pattern[j]) {
                if(j == pattern.length-1) {
                    //System.out.println("hi");
                    j = arr[j];
                    cnt++;
                }
                else j++;
            }
        }
        //System.out.println(Arrays.toString(arr));
        System.out.println(cnt);
//        sb.append(cnt);
//        System.out.println(sb);

    }

    private static int[] makeArr(char[] pattern) {
        int[] num = new int[pattern.length];

        for (int i = 1, j = 0; i < pattern.length; i++) {
            while(j > 0 && pattern[i] != pattern[j]) j = num[j-1];
            if(pattern[i] == pattern[j]) num[i] = ++j;
        }

        //System.out.println(Arrays.toString(num));
        return num;
    }
}
