import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class BJ1701_Cubeditor {
    static int N, res;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        N = str.length();

        char[] pat;
        char[] sen = new char[N];

        for (int i = 0; i < N; i++) {
            sen[i] = str.charAt(i);
        }

        for (int i = 0; i <N; i++) {
            pat = str.substring(i).toCharArray();
            //System.out.println(pat);
            arr = makeArr(pat);
            //kmp(sen, pat);
        }

        System.out.println(res);
    }

    private static int[] makeArr(char[] pattern) {
        //char[] pattern = str.toCharArray();
        int[] num = new int[pattern.length];
        //PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int j = 0;
        for (int i = 1; i < pattern.length; i++) {
            while(j > 0 && pattern[i] != pattern[j]) j = num[j-1];
            if(pattern[i] == pattern[j]) {
                int J = ++j;
                num[i] = J;
                if(J > res) res = J;
            }
        }
        //System.out.println(res);
        System.out.println(Arrays.toString(num));
        return num;
    }
}
