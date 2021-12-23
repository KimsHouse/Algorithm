package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1786_찾기 {
    static int cnt;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pat = br.readLine();

        kmp(str, pat);
        sb.insert(0, cnt+"\n");
        System.out.println(sb);
    }

    private static void kmp(String str, String pat) {
        char[] parent = str.toCharArray();
        char[] pattern = pat.toCharArray();
        int[] num = makeTable(pat);

        int j = 0;
        for (int i = 0; i < parent.length; i++) {
            while(j > 0 && parent[i] != pattern[j]) {
                j = num[j-1];
            }

            if(parent[i] == pattern[j]) {
                if(j == pattern.length-1) {
                    cnt++;
                    //System.out.println((i-pattern.length+2));
                    sb.append((i-pattern.length+2)).append("\n");
                    j = num[j];
                }
                else {
                    j++;
                }

            }
        }
    }

    private static int[] makeTable(String pat) {
        int[] num = new int[pat.length()];

        int j = 0;
        for (int i = 1; i < pat.length(); i++) {
            while(j > 0 && pat.charAt(i) != pat.charAt(j)){
                j = num[j-1];
            }

            if(pat.charAt(i) == pat.charAt(j)){
                num[i] = ++j;
            }
        }

        return num;
    }
}
