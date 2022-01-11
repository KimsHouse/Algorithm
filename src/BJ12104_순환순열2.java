import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ12104_순환순열2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String pr = br.readLine();
        String pt = br.readLine();

        sb.append(pr).append(pr);

        //System.out.println(pr);
        kmp(sb, pt);

        //System.out.println(Arrays.toString(parent));

    }

    private static void kmp(StringBuilder parent, String pattern) {
        int[] arr = makeArr(pattern);
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        //System.out.println("hi");
        for (int i = 0, j = 0; i < parent.length(); i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) j = arr[j-1];

            if(parent.charAt(i) == pattern.charAt(j)) {
                if(j == pattern.length()-1) {
                    //System.out.println("hi");
                    j = arr[j];
                    cnt++;
                }
                else j++;
            }
        }
        //System.out.println(Arrays.toString(arr));
        sb.append(cnt);
        System.out.println(sb);

    }

    private static int[] makeArr(String pattern) {
        int[] num = new int[pattern.length()];

        for (int i = 1, j = 0; i < pattern.length(); i++) {
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) j = num[j];
            if(pattern.charAt(i) == pattern.charAt(j)) num[i] = ++j;
        }

        //System.out.println(Arrays.toString(num));
        return num;
    }
}
