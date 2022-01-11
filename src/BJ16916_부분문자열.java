import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ16916_부분문자열 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String pr = br.readLine();
        String pt = br.readLine();

        kmp(pr, pt);
        System.out.println(cnt);
    }

    private static void kmp(String pr, String pt){
        int[] arr = makeArr(pt);
        char[] parent = pr.toCharArray();
        char[] pattern = pt.toCharArray();

        for(int i = 0, j = 0; i < parent.length; i++){
            while(j > 0 && parent[i] != pattern[j]) j = arr[j - 1];
            if(parent[i] == pattern[j]){
                if(j == pattern.length-1){
                    cnt = 1;
                    j = arr[j];
                } else {
                    j++;
                }
            }
        }
    }

    private static int[] makeArr(String pat){
        int[] num = new int[pat.length()];
        char[] pattern = pat.toCharArray();

        for(int i = 1, j = 0; i < pattern.length; i++){
            while(j > 0 && pattern[i] != pattern[j]) j = num[j-1];
            if(pattern[i] == pattern[j]) num[i] = ++j;
        }

        return num;
    }
}
